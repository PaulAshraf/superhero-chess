package model.pieces;

import exceptions.GameActionException;
import exceptions.InvalidMovementException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Cell;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.heroes.Armored;
import model.pieces.sidekicks.SideKick;

public abstract class Piece extends Throwable implements Movable {

	private String name; // read only
	private Player owner; // read only
	private Game game; // read only
	private int posI;
	private int posJ;

	public Piece(Player player, Game game, String name) {
		this.owner = player;
		this.game = game;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Player getOwner() {
		return this.owner;
	}

	public Game getGame() {
		return this.game;
	}

	public int getPosI() {
		return posI;
	}

	public void setPosI(int posI) {
		this.posI = posI;

	}

	public int getPosJ() {
		return posJ;
	}

	public void setPosJ(int posJ) {
		this.posJ = posJ;
	}

	////////////////////////////////////////////////////////////// ATTACK//////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////// ATTACK//////////////////////////////////////////////////////////////////////////////////////////
	public void attack(Piece target) {
		
		
		
		if (target instanceof SideKick) {
			target.getOwner().getDeadCharacters().add(target);
			
			owner.setSideKilled(owner.getSideKilled() + 1);
			//getOwner().setDeadSideKick(getOwner().getDeadSideKick() + 1);
			
			
			
			if (getOwner().getSideKilled() % 2 == 0) {
				//getOwner().setDeadSideKick(0);
				owner.setPayloadPos((owner.getPayloadPos()) + 1);
				
				
			}
			game.getCellAt(target.getPosI(), target.getPosJ()).setPiece(null);
			this.getGame().checkWinner();
			
			// getGame().setCellAt(target.getPosI(), target.getPosJ(), null);

		} else {
			if (target instanceof Armored) {
				if (((Armored) target).isArmorUp()) {
					((Armored) target).setArmorUp(false);
				} else {
					target.getOwner().getDeadCharacters().add(target);
					game.getCellAt(target.getPosI(), target.getPosJ()).setPiece(null);
					// getGame().setCellAt(target.getPosI(),target.getPosJ(),null);

					owner.setPayloadPos((owner.getPayloadPos()) + 1);
					this.getGame().checkWinner();
				}
			} else {
				target.getOwner().getDeadCharacters().add(target);
				game.getCellAt(target.getPosI(), target.getPosJ()).setPiece(null);
				// getGame().setCellAt(target.getPosI(),target.getPosJ(),null);

				owner.setPayloadPos((owner.getPayloadPos()) + 1);
				this.getGame().checkWinner();
			}
		}

		//this.getGame().checkWinner();
	}

	///////////////////////////////////////////////////////////////////// MOVING//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////// MOVING//////////////////////////////////////////////////////////////////////////

	public int moveHelperI(int i) {
		if (i == -1)
			return 6;
		else if (i == 7)
			return 0;
		return i;
	}

	public int moveHelperJ(int j) {
		if (j == -1)
			return 5;
		else if (j == 6)
			return 0;
		return j;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void moveUp(Direction r) throws OccupiedCellException {

		if (getPosI() == 0) {

			if (this.getGame().getCellAt(6, getPosJ()).getPiece() == null) {
				this.getGame().getCellAt(6, getPosJ()).setPiece(this);
				
				this.getGame().getCellAt(0, getPosJ()).setPiece(null);
				this.setPosI(6);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(6, getPosJ()).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(6, getPosJ()).getPiece());
					if (this.getGame().getCellAt(6, getPosJ()).getPiece() == null) {
						this.getGame().getCellAt(6, getPosJ()).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());
						
						this.getGame().getCellAt(0, getPosJ()).setPiece(null);
						getGame().getCellAt(6, getPosJ()).getPiece().setPosI(6);
					}
				} else {
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}

			}
		}
		//////////////////////////////// ------------------------------------------------------/////////////////////////////////////
		else { // base case
			if (this.getGame().getCellAt(getPosI() - 1, getPosJ()).getPiece() == null) {
				this.getGame().getCellAt(getPosI() - 1, getPosJ()).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() - 1);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI() - 1, getPosJ()).getPiece().getOwner()))) {
					
					attack(this.getGame().getCellAt(getPosI() - 1, getPosJ()).getPiece());
					if (this.getGame().getCellAt(getPosI() - 1, getPosJ()).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 1, getPosJ()).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						getGame().getCellAt(getPosI()-1, getPosJ()).getPiece().setPosI(getPosI() - 1);
					}
				} else {
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}

		}
		// game.switchTurns();

	}
	/////////////////////////////////////////////////////////////// end of moveUp
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////// end of moveUp
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////

	public void moveDown(Direction r) throws OccupiedCellException {

		if (getPosI() == 6) {
			if (this.getGame().getCellAt(0, getPosJ()).getPiece() == null) {
				this.getGame().getCellAt(0, getPosJ()).setPiece(this);

				this.getGame().getCellAt(6, getPosJ()).setPiece(null);
				this.setPosI(0);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(0, getPosJ()).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(0, getPosJ()).getPiece());
					if (this.getGame().getCellAt(0, getPosJ()).getPiece() == null) {
						this.getGame().getCellAt(0, getPosJ()).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

						this.getGame().getCellAt(6, getPosJ()).setPiece(null);
						getGame().getCellAt(0, getPosJ()).getPiece().setPosI(0);
					}
				} else {
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}
		}
		//////////////////////////////// ------------------------------------------------------/////////////////////////////////////
		else { // base case
			if (this.getGame().getCellAt(getPosI() + 1, getPosJ()).getPiece() == null) {
				this.getGame().getCellAt(getPosI() + 1, getPosJ()).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() + 1);
			} else {
				if (!(this.getOwner()
						.equals(this.getGame().getCellAt(getPosI() + 1, getPosJ()).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI() + 1, getPosJ()).getPiece());
					if (this.getGame().getCellAt(getPosI() + 1, getPosJ()).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 1, getPosJ()).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						getGame().getCellAt(getPosI() + 1, getPosJ()).getPiece().setPosI(getPosI() + 1);
					}
				} else {
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}

		}
		// game.switchTurns();

	}

	/////////////////////////////////////////////////////////////// end of moveDown
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////// end of moveDown
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////

	public void moveLeft(Direction r) throws OccupiedCellException {

		if (getPosJ() == 0) {
			if (this.getGame().getCellAt(getPosI(), 5).getPiece() == null) {
				this.getGame().getCellAt(getPosI(), 5).setPiece(this);

				this.getGame().getCellAt(getPosI(), 0).setPiece(null);
				this.setPosJ(5);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI(), 5).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI(), 5).getPiece());
					if (this.getGame().getCellAt(getPosI(), 5).getPiece() == null) {
						this.getGame().getCellAt(getPosI(), 5).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

						this.getGame().getCellAt(getPosI(), 0).setPiece(null);
						getGame().getCellAt(getPosI(), 5).getPiece().setPosJ(5);
					}
				} else {
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}
		}

		//////////////////////////////// ------------------------------------------------------/////////////////////////////////////
		else { // base case
			if (this.getGame().getCellAt(getPosI(), getPosJ() - 1).getPiece() == null) {
				this.getGame().getCellAt(getPosI(), getPosJ() - 1).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosJ(getPosJ() - 1);
			} else {
				if (!(this.getOwner()
						.equals(this.getGame().getCellAt(getPosI(), getPosJ() - 1).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI(), getPosJ() - 1).getPiece());
					if (this.getGame().getCellAt(getPosI(), getPosJ() - 1).getPiece() == null) {
						this.getGame().getCellAt(getPosI(), getPosJ() - 1).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						getGame().getCellAt(getPosI(), getPosJ()-1).getPiece().setPosJ(getPosJ() - 1);
					}
				} else {
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}

		}
		// game.switchTurns();
	}

	/////////////////////////////////////////////////////////////// end of moveLeft
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////// end of moveLeft
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////

	public void moveRight(Direction r) throws OccupiedCellException {

		if (getPosJ() == 5) {
			if (this.getGame().getCellAt(getPosI(), 0).getPiece() == null) {
				this.getGame().getCellAt(getPosI(), 0).setPiece(this);

				this.getGame().getCellAt(getPosI(), 5).setPiece(null);
				this.setPosJ(0);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI(), 0).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI(), 0).getPiece());
					if (this.getGame().getCellAt(getPosI(), 0).getPiece() == null) {
						this.getGame().getCellAt(getPosI(), 0).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

						this.getGame().getCellAt(getPosI(), 5).setPiece(null);
						getGame().getCellAt(getPosI(), 0).getPiece().setPosJ(0);
					}
				} else {
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}
		}
		//////////////////////////////// ------------------------------------------------------/////////////////////////////////////

		else { // base case
			if (this.getGame().getCellAt(getPosI(), getPosJ() + 1).getPiece() == null) {
				this.getGame().getCellAt(getPosI(), getPosJ() + 1).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosJ(getPosJ() + 1);
			} else {
				if (!(this.getOwner()
						.equals(this.getGame().getCellAt(getPosI(), getPosJ() + 1).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI(), getPosJ() + 1).getPiece());
					if (this.getGame().getCellAt(getPosI(), getPosJ() + 1).getPiece() == null) {
						this.getGame().getCellAt(getPosI(), getPosJ() + 1).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						getGame().getCellAt(getPosI(), getPosJ()+1).getPiece().setPosJ(getPosJ() + 1);
					}
				} else {
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);

				}
			}

		}
		// game.switchTurns();
	}

	/////////////////////////////////////////////////////////////// end of moveRight
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////// end of moveRight
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////

	public void moveDownLeft(Direction r) throws OccupiedCellException {
		

		if (getPosJ() == 0 && getPosI() != 6) { // if piece is at left side
			if (this.getGame().getCellAt(getPosI() + 1, 5).getPiece() == null) {
				this.getGame().getCellAt(getPosI() + 1, 5).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() + 1);
				this.setPosJ(5);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI() + 1, 5).getPiece().getOwner()))) { /// start
					
					attack(this.getGame().getCellAt(getPosI() + 1, 5).getPiece());
					if (this.getGame().getCellAt(getPosI() + 1, 5).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 1, 5).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						if(!(this.equals(getGame().getCellAt(getPosI()+1, 5).getPiece()))){
						getGame().getCellAt(getPosI()+1, 5).getPiece().setPosI(getPosI() + 1);
						getGame().getCellAt(getPosI()+1, 5).getPiece().setPosJ(5);
						}
						else {
							this.setPosI(getPosI() + 1);
							this.setPosJ(5);	
						}
					}
				} // stop
				else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);

			}
		}
		//////////////////////////////// ------------------------------------------------------/////////////////////////////////////

		else { // if piece is at bottom side
			if (getPosI() == 6 && getPosJ() != 0) {
				if (this.getGame().getCellAt(0, getPosJ() - 1).getPiece() == null) {
					this.getGame().getCellAt(0, getPosJ() - 1).setPiece(this);

					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
					this.setPosI(0);
					this.setPosJ(getPosJ() - 1);
				} else {
					if (!(this.getOwner().equals(this.getGame().getCellAt(0, getPosJ() - 1).getPiece().getOwner()))) {
						attack(this.getGame().getCellAt(0, getPosJ() - 1).getPiece());
						if (this.getGame().getCellAt(0, getPosJ() - 1).getPiece() == null) {
							this.getGame().getCellAt(0, getPosJ() - 1).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

							this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
							if(!(this.equals(getGame().getCellAt(0, getPosJ()-1).getPiece()))){
								getGame().getCellAt(0, getPosJ()-1).getPiece().setPosI(getPosI() + 1);
								getGame().getCellAt(0, getPosJ()-1).getPiece().setPosJ(5);
								}
								else {
									this.setPosI(0);
									this.setPosJ(getPosJ() - 1);	
								}
						}

					} else
						throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}
			//////////////////////////////// ------------------------------------------------------/////////////////////////////////////

			else { // corner
				if (getPosI() == 6 && getPosJ() == 0) {
					if (this.getGame().getCellAt(0, 5).getPiece() == null) {
						this.getGame().getCellAt(0, 5).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(0);
						this.setPosJ(5);
					} else {
						if (!(this.getOwner().equals(this.getGame().getCellAt(0, 5).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(0, 5).getPiece());
							if (this.getGame().getCellAt(0, 5).getPiece() == null) {
								this.getGame().getCellAt(0, 5).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								if(!(this.equals(getGame().getCellAt(0, 5).getPiece()))){
									getGame().getCellAt(0, 5).getPiece().setPosI(getPosI() + 1);
									getGame().getCellAt(0, 5).getPiece().setPosJ(5);
									}
									else {
										this.setPosI(0);
										this.setPosJ(5);	
									}
							}

						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				}

				//////////////////////////////// ------------------------------------------------------/////////////////////////////////////

				else { // base case (general case)
					if (this.getGame().getCellAt(getPosI() + 1, getPosJ() - 1).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 1, getPosJ() - 1).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 1);
						this.setPosJ(getPosJ() - 1);
					} else {
						if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI() + 1, getPosJ() - 1).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() + 1, getPosJ() - 1).getPiece());
							if (this.getGame().getCellAt(getPosI() + 1, getPosJ() - 1).getPiece() == null) {
								this.getGame().getCellAt(getPosI() + 1, getPosJ() - 1).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								if(!(this.equals(getGame().getCellAt(getPosI()+1, getPosJ()-1).getPiece()))){
									getGame().getCellAt(getPosI()+1, getPosJ()-1).getPiece().setPosI(getPosI() + 1);
									getGame().getCellAt(getPosI()+1, getPosJ()-1).getPiece().setPosJ(5);
									}
									else {
										this.setPosI(getPosI()+1);
										this.setPosJ(getPosJ() - 1);	
									}
							}
						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				}
			}
		}

		// game.switchTurns();
	}
	/////////////////////////////////////////////////////////////// end of
	/////////////////////////////////////////////////////////////// moveDownLeft
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////// end of
	/////////////////////////////////////////////////////////////// moveDownLeft
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////

	public void moveDownRight(Direction r) throws OccupiedCellException {
		if (getPosJ() == 5 && getPosI() != 6) { // if piece is at right side
			if (this.getGame().getCellAt(getPosI() + 1, 0).getPiece() == null) {
				this.getGame().getCellAt(getPosI() + 1, 0).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() + 1);
				this.setPosJ(0);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI() + 1, 0).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI() + 1, 0).getPiece());
					if (this.getGame().getCellAt(getPosI() + 1, 0).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 1, 0).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						if(!(this.equals(getGame().getCellAt(getPosI()+1, 0).getPiece()))){
							getGame().getCellAt(getPosI()+1, 0).getPiece().setPosI(getPosI() + 1);
							getGame().getCellAt(getPosI()+1, 0).getPiece().setPosJ(0);
							}
							else {
								this.setPosI(getPosI()+1);
								this.setPosJ(0);	
							}
					}
				} else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
			}
		}
		//////////////////////////////// ------------------------------------------------------/////////////////////////////////////
		else {
			if (getPosI() == 6 && getPosJ() != 5) { // if piece is at bottom side
				if (this.getGame().getCellAt(0, getPosJ() + 1).getPiece() == null) {
					this.getGame().getCellAt(0, getPosJ() + 1).setPiece(this);

					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
					this.setPosI(0);
					this.setPosJ(getPosJ() + 1);
				} else {
					if (!(this.getOwner().equals(this.getGame().getCellAt(0, getPosJ() + 1).getPiece().getOwner()))) {
						attack(this.getGame().getCellAt(0, getPosJ() + 1).getPiece());
						if (this.getGame().getCellAt(0, getPosJ() + 1).getPiece() == null) {
							this.getGame().getCellAt(0,getPosJ() +1).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

							this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
							if(!(this.equals(getGame().getCellAt(0, getPosJ()+1).getPiece()))){
								getGame().getCellAt(0, getPosJ()+1).getPiece().setPosI(getPosI() + 1);
								getGame().getCellAt(0, getPosJ()+1).getPiece().setPosJ(0);
								}
								else {
									this.setPosI(0);
									this.setPosJ(getPosJ()+1);	
								}
						}
					} else
						throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}

			//////////////////////////////// ------------------------------------------------------/////////////////////////////////////
			else {
				if (getPosI() == 6 && getPosJ() == 5) {
					if (this.getGame().getCellAt(0, 0).getPiece() == null) { // corner
						this.getGame().getCellAt(0, 0).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(0);
						this.setPosJ(0);
					} else {
						if (!(this.getOwner().equals(this.getGame().getCellAt(0, 0).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(0, 0).getPiece());
							if (this.getGame().getCellAt(0, 0).getPiece() == null) {
								this.getGame().getCellAt(0,0).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								if(!(this.equals(getGame().getCellAt(0, 0).getPiece()))){
									getGame().getCellAt(0, 0).getPiece().setPosI(0);
									getGame().getCellAt(0, 0).getPiece().setPosJ(0);
									}
									else {
										this.setPosI(0);
										this.setPosJ(0);	
									}
							}
						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
						// else
					}
				} // if

				//////////////////////////////// ------------------------------------------------------/////////////////////////////////////
				else { // base case (general case)
					if (this.getGame().getCellAt(getPosI() + 1, getPosJ() + 1).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 1, getPosJ() + 1).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 1);
						this.setPosJ(getPosJ() + 1);
					} else {
						if (!(this.getOwner().equals(
								this.getGame().getCellAt(getPosI() + 1, getPosJ() + 1).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() + 1, getPosJ() + 1).getPiece());
							if (this.getGame().getCellAt(getPosI() + 1, getPosJ() + 1).getPiece() == null) {
								this.getGame().getCellAt(getPosI() + 1, getPosJ() + 1).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								if(!(this.equals(getGame().getCellAt(getPosI() + 1, getPosJ() + 1).getPiece()))){
									getGame().getCellAt(getPosI() + 1, getPosJ() + 1).getPiece().setPosI(getPosI() + 1);
									getGame().getCellAt(getPosI() + 1, getPosJ() + 1).getPiece().setPosJ( getPosJ() + 1);
									}
									else {
										this.setPosI(getPosI() + 1);
										this.setPosJ(getPosJ() + 1);	
									}
							}
						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				}
			}
		}
		// game.switchTurns();
	}
	///////////////////////////////////////////////////////////////////// end of
	///////////////////////////////////////////////////////////////////// moveDownRight
	///////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////// end of
	///////////////////////////////////////////////////////////////////// moveDownRight
	///////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////

	public void moveUpRight(Direction r) throws OccupiedCellException {
		if (getPosJ() == 5 && getPosI() != 0) { // if piece is at right side
			if (this.getGame().getCellAt(getPosI() - 1, 0).getPiece() == null) {
				this.getGame().getCellAt(getPosI() - 1, 0).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() - 1);
				this.setPosJ(0);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI() - 1, 0).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI() - 1, 0).getPiece());
					if (this.getGame().getCellAt(getPosI() - 1, 0).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 1, 0).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						if(!(this.equals(getGame().getCellAt(getPosI() - 1, 0).getPiece()))){
							getGame().getCellAt(getPosI() - 1, 0).getPiece().setPosI(getPosI() - 1);
							getGame().getCellAt(getPosI() - 1, 0).getPiece().setPosJ( 0);
							}
							else {
								this.setPosI(getPosI() - 1);
								this.setPosJ(0);	
							}
					}
				} else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
			}

		}
		//////////////////////////////// ------------------------------------------------------/////////////////////////////////////

		else {
			if (getPosI() == 0 && getPosJ() != 5) { // if piece is at top side
				if (this.getGame().getCellAt(6, getPosJ() + 1).getPiece() == null) {
					this.getGame().getCellAt(6, getPosJ() + 1).setPiece(this);

					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
					this.setPosI(6);
					this.setPosJ(getPosJ() + 1);
				} else {
					if (!(this.getOwner().equals(this.getGame().getCellAt(6, getPosJ() + 1).getPiece().getOwner()))) {
						attack(this.getGame().getCellAt(6, getPosJ() + 1).getPiece());
						if (this.getGame().getCellAt(6, getPosJ() + 1).getPiece() == null) {
							this.getGame().getCellAt(6, getPosJ() + 1).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

							this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
							if(!(this.equals(getGame().getCellAt(6, getPosJ() + 1).getPiece()))){
								getGame().getCellAt(6, getPosJ() + 1).getPiece().setPosI(6);
								getGame().getCellAt(6, getPosJ() + 1).getPiece().setPosJ(getPosJ() + 1);
								}
								else {
									this.setPosI(6);
									this.setPosJ(getPosJ() + 1);	
								}
						}
					} else
						throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}
			//////////////////////////////// ------------------------------------------------------/////////////////////////////////////
			else {
				if (getPosI() == 0 && getPosJ() == 5) {
					if (this.getGame().getCellAt(6, 0).getPiece() == null) { // corner
						this.getGame().getCellAt(6, 0).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(6);
						this.setPosJ(0);
					} else {
						if (!(this.getOwner().equals(this.getGame().getCellAt(6, 0).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(6, 0).getPiece());
							if (this.getGame().getCellAt(6, 0).getPiece() == null) {
								this.getGame().getCellAt(6, 0).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								if(!(this.equals(getGame().getCellAt(6, 0).getPiece()))){
									getGame().getCellAt(6, 0).getPiece().setPosI(6);
									getGame().getCellAt(6, 0).getPiece().setPosJ(0);
									}
									else {
										this.setPosI(6);
										this.setPosJ(0);	
									}
							}
						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				}

				//////////////////////////////// ------------------------------------------------------/////////////////////////////////////
				else { // base case (general case)
					if (this.getGame().getCellAt(getPosI() - 1, getPosJ() + 1).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 1, getPosJ() + 1).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() - 1);
						this.setPosJ(getPosJ() + 1);
					} else {
						if (!(this.getOwner().equals(
								this.getGame().getCellAt(getPosI() - 1, getPosJ() + 1).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() - 1, getPosJ() + 1).getPiece());
							if (this.getGame().getCellAt(getPosI() - 1, getPosJ() + 1).getPiece() == null) {
								this.getGame().getCellAt(getPosI() - 1, getPosJ() + 1).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								if(!(this.equals(getGame().getCellAt(getPosI() - 1, getPosJ() + 1).getPiece()))){
									getGame().getCellAt(getPosI() - 1, getPosJ() + 1).getPiece().setPosI(getPosI() - 1);
									getGame().getCellAt(getPosI() - 1, getPosJ() + 1).getPiece().setPosJ( getPosJ() + 1);
									}
									else {
										this.setPosI(getPosI() - 1);
										this.setPosJ(getPosJ() + 1);	
									}
							}
						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);

					}
				}
			}
		}

		// game.switchTurns();
	}

	///////////////////////////////////////////////////////////////////// end of
	///////////////////////////////////////////////////////////////////// moveUpRight
	///////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////// end of
	///////////////////////////////////////////////////////////////////// moveUpRight
	///////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////////////////////////////////
	public void moveUpLeft(Direction r) throws OccupiedCellException {
		if (getPosJ() == 0 && getPosI() != 0) { // if piece is at left side
			if (this.getGame().getCellAt(getPosI() - 1, 5).getPiece() == null) {
				this.getGame().getCellAt(getPosI() - 1, 5).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() - 1);
				this.setPosJ(5);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI() - 1, 5).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI() - 1, 5).getPiece());
					if (this.getGame().getCellAt(getPosI() - 1, 5).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 1, 5).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						if(!(this.equals(getGame().getCellAt(getPosI() - 1, 5).getPiece()))){
							getGame().getCellAt(getPosI() - 1, 5).getPiece().setPosI(getPosI() - 1);
							getGame().getCellAt(getPosI() - 1, 5).getPiece().setPosJ( 5);
							}
							else {
								this.setPosI(getPosI() - 1);
								this.setPosJ(5);	
							}
					}
				} else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
			}
		}
		//////////////////////////////// ------------------------------------------------------/////////////////////////////////////
		else {
			if (getPosI() == 0 && getPosJ() != 0) { // if piece is at top side
				if (this.getGame().getCellAt(6, getPosJ() - 1).getPiece() == null) {
					this.getGame().getCellAt(6, getPosJ() - 1).setPiece(this);

					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
					this.setPosI(6);
					this.setPosJ(getPosJ() - 1);
				} else {
					if (!(this.getOwner().equals(this.getGame().getCellAt(6, getPosJ() - 1).getPiece().getOwner()))) {
						attack(this.getGame().getCellAt(6, getPosJ() - 1).getPiece());
						if (this.getGame().getCellAt(6, getPosJ() - 1).getPiece() == null) {
							this.getGame().getCellAt(6, getPosJ() - 1).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

							this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
							if(!(this.equals(getGame().getCellAt(6, getPosJ() - 1).getPiece()))){
								getGame().getCellAt(6, getPosJ() - 1).getPiece().setPosI(6);
								getGame().getCellAt(6, getPosJ() - 1).getPiece().setPosJ( getPosJ() - 1);
								}
								else {
									this.setPosI(6);
									this.setPosJ(getPosJ() - 1);	
								}
						}
					} else
						throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}
			//////////////////////////////// ------------------------------------------------------/////////////////////////////////////
			else {
				if (getPosI() == 0 && getPosJ() == 0) {
					if (this.getGame().getCellAt(6, 5).getPiece() == null) { // corner
						this.getGame().getCellAt(6, 5).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(6);
						this.setPosJ(5);
					} else {
						if (!(this.getOwner().equals(this.getGame().getCellAt(6, 5).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(6, 5).getPiece());
							if (this.getGame().getCellAt(6, 5).getPiece() == null) {
								this.getGame().getCellAt(6, 5).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								if(!(this.equals(getGame().getCellAt(6, 5).getPiece()))){
									getGame().getCellAt(6, 5).getPiece().setPosI(6);
									getGame().getCellAt(6, 5).getPiece().setPosJ( 5);
									}
									else {
										this.setPosI(6);
										this.setPosJ(5);	
									}
							}
						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				}
				//////////////////////////////// ------------------------------------------------------/////////////////////////////////////
				else { // base case (general case)
					if (this.getGame().getCellAt(getPosI() - 1, getPosJ() - 1).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 1, getPosJ() - 1).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() - 1);
						this.setPosJ(getPosJ() - 1);
					} else {
						if (!(this.getOwner().equals(
								this.getGame().getCellAt(getPosI() - 1, getPosJ() - 1).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() - 1, getPosJ() - 1).getPiece());
							if (this.getGame().getCellAt(getPosI() - 1, getPosJ() - 1).getPiece() == null) {
								this.getGame().getCellAt(getPosI() - 1, getPosJ() - 1).setPiece(getGame().getCellAt(getPosI(), getPosJ()).getPiece());

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								if(!(this.equals(getGame().getCellAt(getPosI() - 1, getPosJ() - 1).getPiece()))){
									getGame().getCellAt(getPosI() - 1, getPosJ() - 1).getPiece().setPosI(getPosI() - 1);
									getGame().getCellAt(getPosI() - 1, getPosJ() - 1).getPiece().setPosJ( getPosJ() - 1);
									}
									else {
										this.setPosI(getPosI() - 1);
										this.setPosJ(getPosJ() - 1);	
									}
							}
						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				}
			}
		}

		// game.switchTurns();
	}
	/////////////////////////////////////////////////////////////// end of
	/////////////////////////////////////////////////////////////// moveUPLeft
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////// end of
	/////////////////////////////////////////////////////////////// moveUpLeft
	/////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////

	public void move(Direction r) throws GameActionException {
		
		if (!(this.getOwner().equals(this.getGame().getCurrentPlayer()))) {
			throw new WrongTurnException("Wrong turn! NOOB", this);
		}

		switch (r) {

		case RIGHT: moveRight(r);  break;
		case LEFT: moveLeft(r);  break;
		case UP: moveUp(r);  break;
		case DOWN: moveDown(r); break;
		case UPRIGHT: moveUpRight(r); break;
		case UPLEFT: moveUpLeft(r); break;
		case DOWNRIGHT: moveDownRight(r);  break;
		case DOWNLEFT: moveDownLeft(r);  break;
		default:break;

		}
		game.switchTurns();

	}

	////////////////////////

}
