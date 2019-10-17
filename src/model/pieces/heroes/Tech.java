package model.pieces.heroes;

import java.awt.Point;

import exceptions.GameActionException;
import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.InvalidPowerUseException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Tech extends ActivatablePowerHero {
	
	public Tech(Player player, Game game, String name){
		super(player,game,name);
		
	}
	

			
		public void usePower(Direction d, Piece target, Point newPos) throws GameActionException {
			
			if(!(this.getOwner().equals(this.getGame().getCurrentPlayer()))){
				throw new WrongTurnException("Wrong turn! NOOB",this);
			}
			if(this.isPowerUsed()){
				throw new PowerAlreadyUsedException("You can only use a power once :) ",this);
			}
			
			
			if(newPos != null){       //teleport
				if(target.getOwner().equals(this.getOwner())){
					if(this.getGame().getCellAt((int)newPos.getX(),(int) newPos.getY()).getPiece() != null){
						//this.getGame().switchTurns();
						throw new InvalidPowerTargetException("you cant teleport here (STAAAAAHHHAAAAAPPEET)",this,target);
					}	
					else{
						this.getGame().getCellAt((int)newPos.getX(),(int)newPos.getY()).setPiece(target);
						
						this.getGame().getCellAt(target.getPosI(), target.getPosJ()).setPiece(null);
						target.setPosI((int)newPos.getX());
						target.setPosJ((int)newPos.getY());
						
					}		
				}
				
				else{
					throw new InvalidPowerTargetException(this,target);
				}
			}
			else{
				if(target.getOwner().equals(this.getOwner())){      //restore
					if(target instanceof Armored){
						if(!((Armored) target).isArmorUp()){
							((Armored) target).setArmorUp(true);
						}
						else{
							throw new InvalidPowerTargetException("power is not used yet",this,target);
						}
					}
					else{
						if(((ActivatablePowerHero)target).isPowerUsed()){
							((ActivatablePowerHero)target).setPowerUsed(false);
						}
						else{
							throw new InvalidPowerTargetException("power is not used yet",this,target);
						}
					}
				}	
				else{                     //hack
					if(target instanceof Armored){
						if(((Armored) target).isArmorUp()){
							((Armored) target).setArmorUp(false);
						}
						else{
							throw new InvalidPowerTargetException("power is already used",this,target);
						}
					}
					else{
						if(((ActivatablePowerHero)target).isPowerUsed()){
							throw new InvalidPowerTargetException("power is already used",this,target);
						}
						else{
							((ActivatablePowerHero)target).setPowerUsed(true);
						}
					}
				}	
			}
			
			this.setPowerUsed(true);
			//this.getGame().switchTurns();
			
		}

	
		public void move(Direction r) throws   GameActionException { 
			
			if(!(this.getOwner().equals(this.getGame().getCurrentPlayer()))){
				throw new WrongTurnException("Wrong turn! NOOB",this);
			}
			
			
			switch(r){
			
				case RIGHT: throw new UnallowedMovementException("This hero can't move in this direction (Ma3lesh ¸) ",this,r); 
				case LEFT: throw new UnallowedMovementException("This hero can't move in this direction (Ma3lesh ) ",this,r); 
				case UP: throw new UnallowedMovementException("This hero can't move in this direction (Ma3lesh ) ",this,r); 
				case DOWN: throw new UnallowedMovementException("This hero can't move in this direction (Ma3lesh ) ",this,r); 
				case UPRIGHT: moveUpRight(r); break;
				case UPLEFT: moveUpLeft(r); break;
				case DOWNRIGHT: moveDownRight(r); break;
				case DOWNLEFT: moveDownLeft(r); break;
				default: break;
				
				
			
			}
			this.getGame().switchTurns();

	}
		
		@Override
		public String toString() {
			return "T";
		}
	
	
}
