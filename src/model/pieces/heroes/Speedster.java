package model.pieces.heroes;

import exceptions.GameActionException;
import exceptions.OccupiedCellException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Speedster extends NonActivatablePowerHero {

	public Speedster(Player player, Game game, String name) {
		super(player, game, name);

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void moveUp(Direction r) throws OccupiedCellException {

		if (getPosI() == 1 || getPosI() == 0) {
			if (this.getGame().getCellAt(getPosI() + 5, getPosJ()).getPiece() == null) {
				this.getGame().getCellAt(getPosI() + 5, getPosJ()).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() + 5);
			} else {
				if (!(this.getOwner()
						.equals(this.getGame().getCellAt(getPosI() + 5, getPosJ()).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI() + 5, getPosJ()).getPiece());
					if (this.getGame().getCellAt(getPosI() + 5, getPosJ()).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 5, getPosJ()).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 5);
					}
				} else {
					
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}
		} else { // base case
			if (this.getGame().getCellAt(getPosI() - 2, getPosJ()).getPiece() == null) {
				this.getGame().getCellAt(getPosI() - 2, getPosJ()).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() - 2);
			} else {
				if (!(this.getOwner()
						.equals(this.getGame().getCellAt(getPosI() - 2, getPosJ()).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI() - 2, getPosJ()).getPiece());
					if (this.getGame().getCellAt(getPosI() - 2, getPosJ()).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 2, getPosJ()).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() - 2);
					}
				} else {
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}
		}
		
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void moveDown(Direction r) throws OccupiedCellException {
		if (getPosI() == 5) {
			if (this.getGame().getCellAt(0, getPosJ()).getPiece() == null) {
				this.getGame().getCellAt(0, getPosJ()).setPiece(this);

				this.getGame().getCellAt(5, getPosJ()).setPiece(null);
				this.setPosI(0);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(0, getPosJ()).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(0, getPosJ()).getPiece());
					if (this.getGame().getCellAt(0, getPosJ()).getPiece() == null) {
						this.getGame().getCellAt(0, getPosJ()).setPiece(this);

						this.getGame().getCellAt(5, getPosJ()).setPiece(null);
						this.setPosI(0);
					}
					// else
					// throw new OccupiedCellException("You can't move here (da
					// ma3ak yahbal) ",this,r);
				} else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
			}
		} else if (getPosI() == 6) {
			if (this.getGame().getCellAt(1, getPosJ()).getPiece() == null) {
				this.getGame().getCellAt(1, getPosJ()).setPiece(this);

				this.getGame().getCellAt(6, getPosJ()).setPiece(null);
				this.setPosI(1);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(1, getPosJ()).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(1, getPosJ()).getPiece());
					if (this.getGame().getCellAt(1, getPosJ()).getPiece() == null) {
						this.getGame().getCellAt(1, getPosJ()).setPiece(this);

						this.getGame().getCellAt(6, getPosJ()).setPiece(null);
						this.setPosI(1);
					}
					// else
					// throw new OccupiedCellException("You can't move here (da
					// ma3ak yahbal) ",this,r);
				} else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
			}
		} else { // base case
			if (this.getGame().getCellAt(getPosI() + 2, getPosJ()).getPiece() == null) {
				this.getGame().getCellAt(getPosI() + 2, getPosJ()).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() + 2);
			} else {
				if (!(this.getOwner()
						.equals(this.getGame().getCellAt(getPosI() + 2, getPosJ()).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI() + 2, getPosJ()).getPiece());
					if (this.getGame().getCellAt(getPosI() + 2, getPosJ()).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 2, getPosJ()).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 2);
					}
				} else {
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}

		}
		
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void moveLeft(Direction r) throws OccupiedCellException {
		if (getPosJ() == 1) {
			if (this.getGame().getCellAt(getPosI(), 5).getPiece() == null) {
				this.getGame().getCellAt(getPosI(), 5).setPiece(this);

				this.getGame().getCellAt(getPosI(), 1).setPiece(null);
				this.setPosJ(5);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI(), 5).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI(), 5).getPiece());
					if (this.getGame().getCellAt(getPosI(), 5).getPiece() == null) {
						this.getGame().getCellAt(getPosI(), 5).setPiece(this);

						this.getGame().getCellAt(getPosI(), 1).setPiece(null);
						this.setPosJ(5);
					}
					// else
					// throw new OccupiedCellException("You can't move here (da
					// ma3ak yahbal) ",this,r);
				} else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
			}
		} else {
			if (getPosJ() == 0) {
				if (this.getGame().getCellAt(getPosI(), 4).getPiece() == null) {
					this.getGame().getCellAt(getPosI(), 4).setPiece(this);

					this.getGame().getCellAt(getPosI(), 0).setPiece(null);
					this.setPosJ(4);
				} else {
					if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI(), 4).getPiece().getOwner()))) {
						attack(this.getGame().getCellAt(getPosI(), 4).getPiece());
						if (this.getGame().getCellAt(getPosI(), 4).getPiece() == null) {
							this.getGame().getCellAt(getPosI(), 4).setPiece(this);

							this.getGame().getCellAt(getPosI(), 0).setPiece(null);
							this.setPosJ(4);
						}
						// else
						// throw new OccupiedCellException("You can't move here
						// (da ma3ak yahbal) ",this,r);
					} else
						throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			} else { // base case
				if (this.getGame().getCellAt(getPosI(), getPosJ() - 2).getPiece() == null) {
					this.getGame().getCellAt(getPosI(), getPosJ() - 2).setPiece(this);

					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
					this.setPosJ(getPosJ() - 2);
				} else {
					if (!(this.getOwner()
							.equals(this.getGame().getCellAt(getPosI(), getPosJ() - 2).getPiece().getOwner()))) {
						attack(this.getGame().getCellAt(getPosI(), getPosJ() - 2).getPiece());
						if (this.getGame().getCellAt(getPosI(), getPosJ() - 2).getPiece() == null) {
							this.getGame().getCellAt(getPosI(), getPosJ() - 2).setPiece(this);

							this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
							this.setPosJ(getPosJ() - 2);
						}
					} else {
						throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				}

			}
		}
		
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void moveRight(Direction r) throws OccupiedCellException {
		if (getPosJ() == 5) {
			if (this.getGame().getCellAt(getPosI(), 1).getPiece() == null) {
				this.getGame().getCellAt(getPosI(), 1).setPiece(this);

				this.getGame().getCellAt(getPosI(), 5).setPiece(null);
				this.setPosJ(1);
			} else {
				if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI(), 1).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI(), 1).getPiece());
					if (this.getGame().getCellAt(getPosI(), 1).getPiece() == null) {
						this.getGame().getCellAt(getPosI(), 1).setPiece(this);

						this.getGame().getCellAt(getPosI(), 5).setPiece(null);
						this.setPosJ(1);
					}
					// else
					// throw new OccupiedCellException("You can't move here (da
					// ma3ak yahbal) ",this,r);
				} else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) 3", this, r);
			}

		} else if (getPosJ() == 4) {
			if (this.getGame().getCellAt(getPosI(), 0).getPiece() == null) {
				this.getGame().getCellAt(getPosI(), 0).setPiece(this);

				this.getGame().getCellAt(getPosI(), 4).setPiece(null);
				this.setPosJ(0);
			}
			else{
			if (!(this.getOwner().equals(this.getGame().getCellAt(getPosI(), 0).getPiece().getOwner()))) {
				attack(this.getGame().getCellAt(getPosI(), 0).getPiece());
				if (this.getGame().getCellAt(getPosI(), 0).getPiece() == null) {
					this.getGame().getCellAt(getPosI(), 0).setPiece(this);

					this.getGame().getCellAt(getPosI(), 4).setPiece(null);
					this.setPosJ(0);
				}
				// else
				// throw new OccupiedCellException("You can't move here (da
				// ma3ak yahbal) ",this,r);
			}
			else
				throw new OccupiedCellException("You can't move here (da ma3ak yahbal) 2", this, r);
		}
		}
		else { // base case
			if (this.getGame().getCellAt(getPosI(), getPosJ() + 2).getPiece() == null) {
				this.getGame().getCellAt(getPosI(), getPosJ() + 2).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosJ(getPosJ() + 2);
			} else {
				if (!(this.getOwner()
						.equals(this.getGame().getCellAt(getPosI(), getPosJ() + 2).getPiece().getOwner()))) {
					attack(this.getGame().getCellAt(getPosI(), getPosJ() + 2).getPiece());
					if (this.getGame().getCellAt(getPosI(), getPosJ() + 2).getPiece() == null) {
						this.getGame().getCellAt(getPosI(), getPosJ() + 2).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosJ(getPosJ() + 2);
					}
				} else {
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal)1 ", this, r);
				}
			}

		}
		
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void moveDownLeft(Direction r) throws OccupiedCellException {
		if ((getPosJ() == 0 || getPosJ() == 1) && getPosI() != 6 && getPosI() != 5) { // if
																						// piece
																						// is
																						// at
																						// left
																						// side
			if (this.getGame().getCellAt(getPosI() + 2, getPosJ() + 4).getPiece() == null) {
				this.getGame().getCellAt(getPosI() + 2, getPosJ() + 4).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() + 2);
				this.setPosJ(getPosJ() + 4);
			} else {
				if (!(this.getOwner()
						.equals(this.getGame().getCellAt(getPosI() + 2, getPosJ() + 4).getPiece().getOwner()))) { /// start
					attack(this.getGame().getCellAt(getPosI() + 2, getPosJ() + 4).getPiece());
					if (this.getGame().getCellAt(getPosI() + 2, getPosJ() + 4).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 2, getPosJ() + 4).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 2);
						this.setPosJ(getPosJ() + 4);
					}
				} // stop
				else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);

			}
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////
		else { // if piece is at bottom side
			if ((getPosI() == 6 || getPosI() == 5) && getPosJ() != 0 && getPosJ() != 1) {
				if (this.getGame().getCellAt(getPosI() - 5, getPosJ() - 2).getPiece() == null) {
					this.getGame().getCellAt(getPosI() - 5, getPosJ() - 2).setPiece(this);

					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
					this.setPosI(getPosI() - 5);
					this.setPosJ(getPosJ() - 2);
				} else {
					if (!(this.getOwner()
							.equals(this.getGame().getCellAt(getPosI() - 5, getPosJ() - 2).getPiece().getOwner()))) {
						attack(this.getGame().getCellAt(getPosI() - 5, getPosJ() - 2).getPiece());
						if (this.getGame().getCellAt(getPosI() - 5, getPosJ() - 2).getPiece() == null) {
							this.getGame().getCellAt(getPosI() - 5, getPosJ() - 2).setPiece(this);

							this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
							this.setPosI(getPosI() - 5);
							this.setPosJ(getPosJ() - 2);
						}

					} else
						throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);

				}
			}

			///////////////////////////////////////////////////////////////////////////////////////////////////
			else { // corner
				if ((getPosI() == 6 || getPosI() == 5) && getPosJ() == 0) {
					if (this.getGame().getCellAt(getPosI() - 5, 4).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 5, 4).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() - 5);
						this.setPosJ(4);
					} else {
						if (!(this.getOwner()
								.equals(this.getGame().getCellAt(getPosI() - 5, 4).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() - 5, 4).getPiece());
							if (this.getGame().getCellAt(getPosI() - 5, 4).getPiece() == null) {
								this.getGame().getCellAt(getPosI() - 5, 4).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() - 5);
								this.setPosJ(4);
							}

						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				} else if ((getPosI() == 6 || getPosI() == 5) && getPosJ() == 1) {
					if (this.getGame().getCellAt(getPosI() - 5, 5).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 5, 5).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() - 5);
						this.setPosJ(5);
					} else {
						if (!(this.getOwner()
								.equals(this.getGame().getCellAt(getPosI() - 5, 5).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() - 5, 5).getPiece());
							if (this.getGame().getCellAt(getPosI() - 5, 5).getPiece() == null) {
								this.getGame().getCellAt(getPosI() - 5, 5).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() - 5);
								this.setPosJ(5);
							}
						} else {
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
						}
					}
				}

				//////////////////////////////////////////////////////////////////////////////////////////
				else { // base case (general case)
					if (this.getGame().getCellAt(getPosI() + 2, getPosJ() - 2).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 2, getPosJ() - 2).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 2);
						this.setPosJ(getPosJ() - 2);
					} else {
						if (!(this.getOwner().equals(
								this.getGame().getCellAt(getPosI() + 2, getPosJ() - 2).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() + 2, getPosJ() - 2).getPiece());
							if (this.getGame().getCellAt(getPosI() + 2, getPosJ() - 2).getPiece() == null) {
								this.getGame().getCellAt(getPosI() + 2, getPosJ() - 2).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() + 2);
								this.setPosJ(getPosJ() - 2);
							}
						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				}
			}
		}

		

	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void moveDownRight(Direction r) throws OccupiedCellException {
		if ((getPosJ() == 4 || getPosJ() == 5) && getPosI() != 5 && getPosI() != 6) { // if
																						// piece
																						// is
																						// at
																						// right
																						// side
			if (this.getGame().getCellAt(getPosI() + 2, getPosJ() - 4).getPiece() == null) {
				this.getGame().getCellAt(getPosI() + 2, getPosJ() - 4).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() + 2);
				this.setPosJ(getPosJ() - 4);
			} else {
				if (!(this.getOwner()
						.equals(this.getGame().getCellAt(getPosI() + 2, getPosJ() - 4).getPiece().getOwner()))) { /// start
					attack(this.getGame().getCellAt(getPosI() + 2, getPosJ() - 4).getPiece());
					if (this.getGame().getCellAt(getPosI() + 2, getPosJ() - 4).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 2, getPosJ() - 4).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 2);
						this.setPosJ(getPosJ() - 4);
					}
				} // stop
				else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);

			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		else { // if piece is at bottom side
			if ((getPosI() == 6 || getPosI() == 5) && getPosJ() != 5 && getPosJ() != 4) {
				if (this.getGame().getCellAt(getPosI() - 5, getPosJ() + 2).getPiece() == null) {
					this.getGame().getCellAt(getPosI() - 5, getPosJ() + 2).setPiece(this);

					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
					this.setPosI(getPosI() - 5);
					this.setPosJ(getPosJ() + 2);
				} else {
					if (!(this.getOwner()
							.equals(this.getGame().getCellAt(getPosI() - 5, getPosJ() + 2).getPiece().getOwner()))) {
						attack(this.getGame().getCellAt(getPosI() - 5, getPosJ() + 2).getPiece());
						if (this.getGame().getCellAt(getPosI() - 5, getPosJ() + 2).getPiece() == null) {
							this.getGame().getCellAt(getPosI() - 5, getPosJ() + 2).setPiece(this);

							this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
							this.setPosI(getPosI() - 5);
							this.setPosJ(getPosJ() + 2);
						}

					} else
						throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}

			///////////////////////////////////////////////////////////////////////////////////////////////////
			else { // corner
				if ((getPosI() == 6 || getPosI() == 5) && getPosJ() == 5) {
					if (this.getGame().getCellAt(getPosI() - 5, 1).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 5, 1).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() - 5);
						this.setPosJ(1);
					} else {
						if (!(this.getOwner()
								.equals(this.getGame().getCellAt(getPosI() - 5, 1).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() - 5, 1).getPiece());
							if (this.getGame().getCellAt(getPosI() - 5, 1).getPiece() == null) {
								this.getGame().getCellAt(getPosI() - 5, 1).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() - 5);
								this.setPosJ(1);
							}

						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				} else if ((getPosI() == 6 || getPosI() == 5) && getPosJ() == 4) {
					if (this.getGame().getCellAt(getPosI() - 5, 0).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 5, 0).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() - 5);
						this.setPosJ(0);
					} else {
						if (!(this.getOwner()
								.equals(this.getGame().getCellAt(getPosI() - 5, 0).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() - 5, 0).getPiece());
							if (this.getGame().getCellAt(getPosI() - 5, 0).getPiece() == null) {
								this.getGame().getCellAt(getPosI() - 5, 0).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() - 5);
								this.setPosJ(0);
							}
						} else {
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
						}
					}
				}

				//////////////////////////////////////////////////////////////////////////////////////////
				else { // base case (general case)
					if (this.getGame().getCellAt(getPosI() + 2, getPosJ() + 2).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 2, getPosJ() + 2).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 2);
						this.setPosJ(getPosJ() + 2);
					} else {
						if (!(this.getOwner().equals(
								this.getGame().getCellAt(getPosI() + 2, getPosJ() + 2).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() + 2, getPosJ() + 2).getPiece());
							if (this.getGame().getCellAt(getPosI() + 2, getPosJ() + 2).getPiece() == null) {
								this.getGame().getCellAt(getPosI() + 2, getPosJ() + 2).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() + 2);
								this.setPosJ(getPosJ() + 2);
							}
						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}

				}
			}
		}

		

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void moveUpRight(Direction r) throws OccupiedCellException {
		if ((getPosJ() == 4 || getPosJ() == 5) && getPosI() != 0 && getPosI() != 1) { // if
																						// piece
																						// is
																						// at
																						// right
																						// side
			if (this.getGame().getCellAt(getPosI() - 2, getPosJ() - 4).getPiece() == null) {
				this.getGame().getCellAt(getPosI() - 2, getPosJ() - 4).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() - 2);
				this.setPosJ(getPosJ() - 4);
			} else {
				if (!(this.getOwner()
						.equals(this.getGame().getCellAt(getPosI() - 2, getPosJ() - 4).getPiece().getOwner()))) { /// start
					attack(this.getGame().getCellAt(getPosI() - 2, getPosJ() - 4).getPiece());
					if (this.getGame().getCellAt(getPosI() - 2, getPosJ() - 4).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 2, getPosJ() - 4).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() - 2);
						this.setPosJ(getPosJ() - 4);
					}
				} // stop
				else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);

			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		else { // if piece is at top side
			if ((getPosI() == 0 || getPosI() == 1) && getPosJ() != 5 && getPosJ() != 4) {
				if (this.getGame().getCellAt(getPosI() + 5, getPosJ() + 2).getPiece() == null) {
					this.getGame().getCellAt(getPosI() + 5, getPosJ() + 2).setPiece(this);

					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
					this.setPosI(getPosI() + 5);
					this.setPosJ(getPosJ() + 2);
				} else {
					if (!(this.getOwner()
							.equals(this.getGame().getCellAt(getPosI() + 5, getPosJ() + 2).getPiece().getOwner()))) {
						attack(this.getGame().getCellAt(getPosI() + 5, getPosJ() + 2).getPiece());
						if (this.getGame().getCellAt(getPosI() + 5, getPosJ() + 2).getPiece() == null) {
							this.getGame().getCellAt(getPosI() + 5, getPosJ() + 2).setPiece(this);

							this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
							this.setPosI(getPosI() + 5);
							this.setPosJ(getPosJ() + 2);
						}

					} else
						throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
				}
			}

			///////////////////////////////////////////////////////////////////////////////////////////////////
			else { // corner
				if ((getPosI() == 1 || getPosI() == 0) && getPosJ() == 5) {
					if (this.getGame().getCellAt(getPosI() + 5, 1).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 5, 1).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 5);
						this.setPosJ(1);
					} else {
						if (!(this.getOwner()
								.equals(this.getGame().getCellAt(getPosI() + 5, 1).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() + 5, 1).getPiece());
							if (this.getGame().getCellAt(getPosI() + 5, 1).getPiece() == null) {
								this.getGame().getCellAt(getPosI() + 5, 1).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() + 5);
								this.setPosJ(1);
							}

						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				} else if ((getPosI() == 1 || getPosI() == 0) && getPosJ() == 4) {
					if (this.getGame().getCellAt(getPosI() + 5, 0).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 5, 0).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 5);
						this.setPosJ(0);
					} else {
						if (!(this.getOwner()
								.equals(this.getGame().getCellAt(getPosI() + 5, 0).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() + 5, 0).getPiece());
							if (this.getGame().getCellAt(getPosI() + 5, 0).getPiece() == null) {
								this.getGame().getCellAt(getPosI() + 5, 0).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() + 5);
								this.setPosJ(0);
							}
						} else {
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
						}
					}
				}

				//////////////////////////////////////////////////////////////////////////////////////////
				else { // base case (general case)
					if (this.getGame().getCellAt(getPosI() - 2, getPosJ() + 2).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 2, getPosJ() + 2).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() - 2);
						this.setPosJ(getPosJ() + 2);
					} else {
						if (!(this.getOwner().equals(
								this.getGame().getCellAt(getPosI() - 2, getPosJ() + 2).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() - 2, getPosJ() + 2).getPiece());
							if (this.getGame().getCellAt(getPosI() - 2, getPosJ() + 2).getPiece() == null) {
								this.getGame().getCellAt(getPosI() - 2, getPosJ() + 2).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() - 2);
								this.setPosJ(getPosJ() + 2);
							}
						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, r);
					}
				}
			}
		}

		
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void moveUpLeft(Direction moveUpLeft) throws OccupiedCellException {
		if ((getPosJ() == 0 || getPosJ() == 1) && getPosI() != 0 && getPosI() != 1) { // if
																						// piece
																						// is
																						// at
																						// left
																						// side
			if (this.getGame().getCellAt(getPosI() - 2, getPosJ() + 4).getPiece() == null) {
				this.getGame().getCellAt(getPosI() - 2, getPosJ() + 4).setPiece(this);

				this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
				this.setPosI(getPosI() - 2);
				this.setPosJ(getPosJ() + 4);
			} else {
				if (!(this.getOwner()
						.equals(this.getGame().getCellAt(getPosI() - 2, getPosJ() + 4).getPiece().getOwner()))) { /// start
					attack(this.getGame().getCellAt(getPosI() - 2, getPosJ() + 4).getPiece());
					if (this.getGame().getCellAt(getPosI() - 2, getPosJ() + 4).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 2, getPosJ() + 4).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() - 2);
						this.setPosJ(getPosJ() + 4);
					}
				} // stop
				else
					throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, moveUpLeft);

			}
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////
		else { // if piece is at top side
			if ((getPosI() == 1 || getPosI() == 0) && getPosJ() != 0 && getPosJ() != 1) {
				if (this.getGame().getCellAt(getPosI() + 5, getPosJ() - 2).getPiece() == null) {
					this.getGame().getCellAt(getPosI() + 5, getPosJ() - 2).setPiece(this);

					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
					this.setPosI(getPosI() + 5);
					this.setPosJ(getPosJ() - 2);
				} else {
					if (!(this.getOwner()
							.equals(this.getGame().getCellAt(getPosI() + 5, getPosJ() - 2).getPiece().getOwner()))) {
						attack(this.getGame().getCellAt(getPosI() + 5, getPosJ() - 2).getPiece());
						if (this.getGame().getCellAt(getPosI() + 5, getPosJ() - 2).getPiece() == null) {
							this.getGame().getCellAt(getPosI() + 5, getPosJ() - 2).setPiece(this);

							this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
							this.setPosI(getPosI() + 5);
							this.setPosJ(getPosJ() - 2);
						}

					} else
						throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, moveUpLeft);

				}
			}

			///////////////////////////////////////////////////////////////////////////////////////////////////
			else { // corner
				if ((getPosI() == 1 || getPosI() == 0) && getPosJ() == 0) {
					if (this.getGame().getCellAt(getPosI() + 5, 4).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 5, 4).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 5);
						this.setPosJ(4);
					} else {
						if (!(this.getOwner()
								.equals(this.getGame().getCellAt(getPosI() + 5, 4).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() + 5, 4).getPiece());
							if (this.getGame().getCellAt(getPosI() + 5, 4).getPiece() == null) {
								this.getGame().getCellAt(getPosI() + 5, 4).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() + 5);
								this.setPosJ(4);
							}

						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, moveUpLeft);
					}
				} else if ((getPosI() == 0 || getPosI() == 1) && getPosJ() == 1) {
					if (this.getGame().getCellAt(getPosI() + 5, 5).getPiece() == null) {
						this.getGame().getCellAt(getPosI() + 5, 5).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() + 5);
						this.setPosJ(5);
					} else {
						if (!(this.getOwner()
								.equals(this.getGame().getCellAt(getPosI() + 5, 5).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() + 5, 5).getPiece());
							if (this.getGame().getCellAt(getPosI() + 5, 5).getPiece() == null) {
								this.getGame().getCellAt(getPosI() + 5, 5).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() + 5);
								this.setPosJ(5);
							}
						} else {
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, moveUpLeft);
						}
					}
				}

				//////////////////////////////////////////////////////////////////////////////////////////
				else { // base case (general case)
					if (this.getGame().getCellAt(getPosI() - 2, getPosJ() - 2).getPiece() == null) {
						this.getGame().getCellAt(getPosI() - 2, getPosJ() - 2).setPiece(this);

						this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
						this.setPosI(getPosI() - 2);
						this.setPosJ(getPosJ() - 2);
					} else {
						if (!(this.getOwner().equals(
								this.getGame().getCellAt(getPosI() - 2, getPosJ() - 2).getPiece().getOwner()))) {
							attack(this.getGame().getCellAt(getPosI() - 2, getPosJ() - 2).getPiece());
							if (this.getGame().getCellAt(getPosI() - 2, getPosJ() - 2).getPiece() == null) {
								this.getGame().getCellAt(getPosI() - 2, getPosJ() - 2).setPiece(this);

								this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(null);
								this.setPosI(getPosI() - 2);
								this.setPosJ(getPosJ() - 2);
							}
						} else
							throw new OccupiedCellException("You can't move here (da ma3ak yahbal) ", this, moveUpLeft);
					}
				}
			}
		}

		

	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "S";
	}

} // end of class
