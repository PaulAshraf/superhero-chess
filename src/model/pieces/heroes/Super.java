package model.pieces.heroes;


import java.awt.Point;

import exceptions.GameActionException;
import exceptions.InvalidMovementException;
import exceptions.InvalidPowerDirectionException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Game;
import model.game.Player;
import model.pieces.Movable;
import model.pieces.Piece;
import model.game.Direction;


public class Super extends ActivatablePowerHero  {
	
	public Super(Player player, Game game, String name){
		super(player,game,name);
		}
	
	
	
	@Override
	public void move(Direction r) throws   GameActionException {  
		
		if(!(this.getOwner().equals(this.getGame().getCurrentPlayer()))){
			throw new WrongTurnException("Wrong turn! NOOB",this);
		}
		switch(r){
		
			case RIGHT: moveRight(r); break;
			case LEFT: moveLeft(r); break;
			case UP: moveUp(r); break;
			case DOWN: moveDown(r); break;
			case UPRIGHT: throw new UnallowedMovementException("This hero can't move in this direction (Ma3lesh ðŸ�¸) ",this,r); 
			case UPLEFT: throw new UnallowedMovementException("This hero can't move in this direction (Ma3lesh ðŸ�¸) ",this,r); 
			case DOWNRIGHT: throw new UnallowedMovementException("This hero can't move in this direction (Ma3lesh ðŸ�¸) ",this,r); 
			case DOWNLEFT: throw new UnallowedMovementException("This hero can't move in this direction (Ma3lesh ðŸ�¸ ) ",this,r); 
			default: break;
		
		}
		
		this.getGame().switchTurns();
	}
	
	@Override	
	public void usePower(Direction d, Piece target, Point newPos) throws GameActionException {
		
		if(!(this.getOwner().equals(this.getGame().getCurrentPlayer()))){
			throw new WrongTurnException("Wrong turn! NOOB",this);
		}
		if(this.isPowerUsed()){
			throw new PowerAlreadyUsedException("You can only use a power once :) ",this);
		}
		
		switch(d){
			case RIGHT: if(getPosJ()<=3){
				if(this.getGame().getCellAt(getPosI(), getPosJ()+1).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI(), getPosJ()+1).getPiece().getOwner()))){
					this.attack(this.getGame().getCellAt(getPosI(), getPosJ()+1).getPiece());
				}
				if(this.getGame().getCellAt(getPosI(), getPosJ()+2).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI(), getPosJ()+2).getPiece().getOwner()))){	
					this.attack(this.getGame().getCellAt(getPosI(), getPosJ()+2).getPiece());
				}
			}	
				else{
					if(getPosJ()==4){
						if(this.getGame().getCellAt(getPosI(), getPosJ()+1).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI(), getPosJ()+1).getPiece().getOwner()))){
							this.attack(this.getGame().getCellAt(getPosI(), getPosJ()+1).getPiece());	
						}
					}
				}	
				this.setPowerUsed(true);
				break;
				//////////////////////////////////
			case LEFT: if(getPosJ()>=2){
				if(this.getGame().getCellAt(getPosI(), getPosJ()-1).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI(), getPosJ()-1).getPiece().getOwner()))){
					this.attack(this.getGame().getCellAt(getPosI(), getPosJ()-1).getPiece());
				}
				if(this.getGame().getCellAt(getPosI(), getPosJ()-2).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI(), getPosJ()-2).getPiece().getOwner()))){
					this.attack(this.getGame().getCellAt(getPosI(), getPosJ()-2).getPiece());
				}
			}	
				else{
					if(getPosJ()==1){
						if(this.getGame().getCellAt(getPosI(), getPosJ()-1).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI(), getPosJ()-1).getPiece().getOwner()))){
							this.attack(this.getGame().getCellAt(getPosI(), getPosJ()-1).getPiece());
						}	
					}
				}
			this.setPowerUsed(true);
				break;
			case UP:if(getPosI()>=2){
				if(this.getGame().getCellAt(getPosI()-1, getPosJ()).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI()-1, getPosJ()).getPiece().getOwner()))){
					this.attack(this.getGame().getCellAt(getPosI()-1, getPosJ()).getPiece());
				}
				if(this.getGame().getCellAt(getPosI()-2, getPosJ()).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI()-2, getPosJ()).getPiece().getOwner()))){
					this.attack(this.getGame().getCellAt(getPosI()-2, getPosJ()).getPiece());
				}
			}	
				else{
					if(getPosI()==1){
						if(this.getGame().getCellAt(getPosI()-1, getPosJ()).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI()-1, getPosJ()).getPiece().getOwner()))){
							this.attack(this.getGame().getCellAt(getPosI()-1, getPosJ()).getPiece());
						}
					}
				}
			this.setPowerUsed(true);
				break;
			case DOWN: if(getPosI()<=4){
				if(this.getGame().getCellAt(getPosI()+1, getPosJ()).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI()+1, getPosJ()).getPiece().getOwner()))){
					this.attack(this.getGame().getCellAt(getPosI()+1, getPosJ()).getPiece());
				}
				if(this.getGame().getCellAt(getPosI()+2, getPosJ()).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI()+2, getPosJ()).getPiece().getOwner()))){
					this.attack(this.getGame().getCellAt(getPosI()+2, getPosJ()).getPiece());
				}
				}
				else{
					if(getPosI()==5){
						if(this.getGame().getCellAt(getPosI()+1, getPosJ()).getPiece() != null && !(this.getOwner().equals(this.getGame().getCellAt(getPosI()+1, getPosJ()).getPiece().getOwner()))){
							this.attack(this.getGame().getCellAt(getPosI()+1, getPosJ()).getPiece());
						}
					}
				}
			this.setPowerUsed(true);
				break;
				
			case UPRIGHT: throw new InvalidPowerDirectionException("Can't attack in this direction :( ",this,d); 
			case UPLEFT: throw new InvalidPowerDirectionException("Can't attack in this direction :( ",this,d); 
			case DOWNRIGHT: throw new InvalidPowerDirectionException("Can't attack in this direction :( ",this,d); 
			case DOWNLEFT: throw new InvalidPowerDirectionException("Can't attack in this direction :( ",this,d); 
			
			default: break;
		
		}
		
		this.getGame().switchTurns();
		
	}

	
	@Override
	public String toString() {
		return "P";
	}
	
}
	

