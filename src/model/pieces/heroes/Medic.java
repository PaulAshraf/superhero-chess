package model.pieces.heroes;

import java.awt.Point;

import exceptions.GameActionException;
import exceptions.InvalidMovementException;
import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Medic extends ActivatablePowerHero {
	
	public Medic(Player player, Game game, String name){
		super(player,game,name);
		
	}
	
	public void move(Direction r) throws   GameActionException {  
		
		if(!(this.getOwner().equals(this.getGame().getCurrentPlayer()))){
			throw new WrongTurnException("Wrong turn! NOOB",this);
		}
		
		switch(r){
		
			case RIGHT: moveRight(r); break;
			case LEFT: moveLeft(r); break;
			case UP: moveUp(r); break;
			case DOWN: moveDown(r); break;
			case UPRIGHT: throw new UnallowedMovementException(this,r); 
			case UPLEFT: throw new UnallowedMovementException(this,r); 
			case DOWNRIGHT: throw new UnallowedMovementException(this,r); 
			case DOWNLEFT: throw new UnallowedMovementException(this,r); 
			default: break;
		}
		
		this.getGame().switchTurns();
	}
	
	
	
		 
	public void usePower(Direction d, Piece target, Point newPos) throws  GameActionException {
		
		if(!(this.getOwner().equals(this.getGame().getCurrentPlayer()))){
			throw new WrongTurnException("Wrong turn! NOOB",this);
		}
		if(this.isPowerUsed()){
			throw new PowerAlreadyUsedException("You can only use a power once :) ",this);
		}
		
		if(!(this.getOwner().getDeadCharacters().contains(target)) &&  target.getOwner().equals(this.getOwner())){   // check if reviving an alive friendly piece
			throw new InvalidPowerTargetException("piece is already alive (But not for long :) )",this,target);
		}
		else{
			if(!(target.getOwner().equals(this.getOwner()))){     //check if reviving an enemy piece
				throw new InvalidPowerTargetException("You can't revive an enemy piece (da msh ma3ak yahbal)",this,target);
			}
				
		}
			switch(d){
			
			case RIGHT: 
			
			if(getPosJ() != 5){
				if(this.getGame().getCellAt(getPosI(), getPosJ()+1).getPiece() != null){
					throw new InvalidPowerTargetException("Cant revive an piece on an occupied cell (ya 2a3ma)",this,target);}
				else{
					Piece c =  this.getOwner().getDeadCharacters().remove(this.getOwner().getDeadCharacters().indexOf(target));
					this.getGame().getCellAt(getPosI(), getPosJ()+1).setPiece(c);
					c.setPosI(getPosI());
					c.setPosJ(getPosJ()+1);
					if(c instanceof Armored){
						((Armored) c).setArmorUp(true);
					}
					else {
						if(c instanceof ActivatablePowerHero){
							((ActivatablePowerHero) c).setPowerUsed(false);
						}
					}
				}
			}
//			else{
//				if(this.getGame().getCellAt(getPosI(), 0) != null){
//					throw new InvalidPowerTargetException("Cant revive an piece on an occupied cell (ya 2a3ma)",this,target);}
//				else{
//					Piece c =  this.getOwner().getDeadCharacters().remove(this.getOwner().getDeadCharacters().indexOf(target));
//					this.getGame().getCellAt(getPosI(), 0).setPiece(c);
//					if(c instanceof Armored){
//						((Armored) c).setArmorUp(true);
//					}
//					else {
//						if(c instanceof ActivatablePowerHero){
//							((ActivatablePowerHero) c).setPowerUsed(false);
//						}
//					}
//				}
//			}
//				
			break;
			case LEFT:
				if(getPosJ() != 0){
				if(this.getGame().getCellAt(getPosI(), getPosJ()-1).getPiece() != null){
				throw new InvalidPowerTargetException("Cant revive an piece on an occupied cell (ya 2a3ma)",this,target);}
				else{
					Piece c =  this.getOwner().getDeadCharacters().remove(this.getOwner().getDeadCharacters().indexOf(target));
					this.getGame().getCellAt(getPosI(), getPosJ()-1).setPiece(c);
					c.setPosI(getPosI());
					c.setPosJ(getPosJ()-1);
					if(c instanceof Armored){
						((Armored) c).setArmorUp(true);
					}
					else{
						if(c instanceof ActivatablePowerHero){
							((ActivatablePowerHero) c).setPowerUsed(false);
						}
					}
				}
			}
				
			break;
			case UP:
				if(getPosI() != 0){
				if(this.getGame().getCellAt(getPosI()-1, getPosJ()).getPiece() != null){
					throw new InvalidPowerTargetException("Cant revive an piece on an occupied cell (ya 2a3ma)",this,target);}
				else{
					Piece c =  this.getOwner().getDeadCharacters().remove(this.getOwner().getDeadCharacters().indexOf(target));
					this.getGame().getCellAt(getPosI()-1, getPosJ()).setPiece(c);
					c.setPosI(getPosI()-1);
					c.setPosJ(getPosJ());
					if(c instanceof Armored){
						((Armored) c).setArmorUp(true);
					}
					else{
						if(c instanceof ActivatablePowerHero){
							((ActivatablePowerHero) c).setPowerUsed(false);
						}
					}
				}
				}
				
			break;
			case DOWN: 
				if(getPosI() != 6){
				if(this.getGame().getCellAt(getPosI()+1, getPosJ()).getPiece() != null){
					throw new InvalidPowerTargetException("Cant revive an piece on an occupied cell (ya 2a3ma)",this,target);}
				else{
					Piece c =  this.getOwner().getDeadCharacters().remove(this.getOwner().getDeadCharacters().indexOf(target));
					this.getGame().getCellAt(getPosI()+1, getPosJ()).setPiece(c);
					c.setPosI(getPosI()+1);
					c.setPosJ(getPosJ());
					if(c instanceof Armored){
						((Armored) c).setArmorUp(true);
					}
					else{
						if(c instanceof ActivatablePowerHero){
							((ActivatablePowerHero) c).setPowerUsed(false);
						}
					}
				}
				}
							break;
			case UPRIGHT:
				if(getPosI() != 0 && getPosJ() != 5) {
					if(this.getGame().getCellAt(getPosI()-1, getPosJ()+1).getPiece() != null){
						throw new InvalidPowerTargetException("Cant revive an piece on an occupied cell (ya 2a3ma)",this,target);}
						else{
							Piece c =  this.getOwner().getDeadCharacters().remove(this.getOwner().getDeadCharacters().indexOf(target));
							this.getGame().getCellAt(getPosI()-1, getPosJ()+1).setPiece(c);
							c.setPosI(getPosI()-1);
							c.setPosJ(getPosJ()+1);
							if(c instanceof Armored){
								((Armored) c).setArmorUp(true);
							}
							else{
								if(c instanceof ActivatablePowerHero){
									((ActivatablePowerHero) c).setPowerUsed(false);
								}
							}
						}
				}
					
			break; 
			///////////////////////////////////////////////////////////////////////////////////////////////////
			case UPLEFT:
				if(getPosI() != 0 && getPosJ() != 0){
				if(this.getGame().getCellAt(getPosI()-1, getPosJ()-1).getPiece() != null){
				throw new InvalidPowerTargetException("Cant revive an piece on an occupied cell (ya 2a3ma)",this,target);}
				else{
					Piece c =  this.getOwner().getDeadCharacters().remove(this.getOwner().getDeadCharacters().indexOf(target));
					this.getGame().getCellAt(getPosI()-1, getPosJ()-1).setPiece(c);
					c.setPosI(getPosI()-1);
					c.setPosJ(getPosJ()-1);
					if(c instanceof Armored){
						((Armored) c).setArmorUp(true);
					}
					else{
						if(c instanceof ActivatablePowerHero){
							((ActivatablePowerHero) c).setPowerUsed(false);
						}
					}
				}
				}
			break; 
			case DOWNRIGHT:
				if(getPosI() != 6 && getPosJ() != 5){
				if(this.getGame().getCellAt(getPosI()+1, getPosJ()+1).getPiece() != null){
				throw new InvalidPowerTargetException("Cant revive an piece on an occupied cell (ya 2a3ma)",this,target);}
				else{
					Piece c =  this.getOwner().getDeadCharacters().remove(this.getOwner().getDeadCharacters().indexOf(target));
					this.getGame().getCellAt(getPosI()+1, getPosJ()+1).setPiece(c);
					c.setPosI(getPosI()+1);
					c.setPosJ(getPosJ()+1);
					if(c instanceof Armored){
						((Armored) c).setArmorUp(true);
					}
					else{
						if(c instanceof ActivatablePowerHero){
							((ActivatablePowerHero) c).setPowerUsed(false);
						} 
					}
				}
				}
			break;
			case DOWNLEFT:
				if(getPosI() != 6 && getPosJ() != 0){
				if(this.getGame().getCellAt(getPosI()+1, getPosJ()-1).getPiece() != null){
				throw new InvalidPowerTargetException("Cant revive an piece on an occupied cell (ya 2a3ma)",this,target);}
				else{
					Piece c =  this.getOwner().getDeadCharacters().remove(this.getOwner().getDeadCharacters().indexOf(target));
					this.getGame().getCellAt(getPosI()+1, getPosJ()-1).setPiece(c);
					c.setPosI(getPosI()+1);
					c.setPosJ(getPosJ()-1);
					if(c instanceof Armored){
						((Armored) c).setArmorUp(true);
					}
					else{
						if(c instanceof ActivatablePowerHero){
							((ActivatablePowerHero) c).setPowerUsed(false);
						} 
					}
				}
				}
			break;
			default: break;
		}
			
			this.getGame().switchTurns();
			this.setPowerUsed(true);
		}
	
	@Override
	public String toString() {
		return "M";
	}
		
	}

