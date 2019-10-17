package model.pieces.heroes;

import java.awt.Point;

import exceptions.GameActionException;
import exceptions.InvalidPowerDirectionException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Ranged extends ActivatablePowerHero {
	
	public Ranged(Player player, Game game, String name){
		super(player,game,name);
		
	}
	
	public void usePower(Direction d, Piece target, Point newPos) throws GameActionException {
		
		
		if(!(this.getOwner().equals(this.getGame().getCurrentPlayer()))){
			throw new WrongTurnException("Wrong turn! NOOB",this);
		}
		if(this.isPowerUsed()){
			throw new PowerAlreadyUsedException("You can only use a power once :) ",this);
		}
		
		
		int k = 0;
		//this.getGame().switchTurns();
		switch(d){
			
			case RIGHT:
				
			if(getPosJ() != 5)	{
				for(k=getPosJ()+1;k<6;k++){
				if(this.getGame().getCellAt(getPosI(), k).getPiece() != null && !(this.getGame().getCellAt(getPosI(), k).getPiece().getOwner().equals(this.getOwner()))){
					this.attack(this.getGame().getCellAt(getPosI(), k).getPiece());
				//	this.setPowerUsed(true);
					break;
				}
				else{
					if(this.getGame().getCellAt(getPosI(), k).getPiece() != null && (this.getGame().getCellAt(getPosI(), k).getPiece().getOwner().equals(this.getOwner()))){
						throw new InvalidPowerDirectionException("There is no friendly fire in this game",this,d);
					}
				}
			}
			if(k==6)
				throw new InvalidPowerDirectionException("there is no one here",this,d);
			
			}
			else {
				throw new InvalidPowerDirectionException("Ranged cant wrap",this,d);
			}
			; 
			break;	
			
			case LEFT:
				
			if(getPosJ() != 0)	{	
				for( k=getPosJ()-1;k>=0;k--){
				if(this.getGame().getCellAt(getPosI(), k).getPiece() != null && !(this.getGame().getCellAt(getPosI(), k).getPiece().getOwner().equals(this.getOwner()))){
					this.attack(this.getGame().getCellAt(getPosI(), k).getPiece());
				//	this.setPowerUsed(true);
					break;
				}
				else{
					if(this.getGame().getCellAt(getPosI(), k).getPiece() != null && (this.getGame().getCellAt(getPosI(), k).getPiece().getOwner().equals(this.getOwner()))){
						throw new InvalidPowerDirectionException("There is no friendly fire in this game",this,d);
					}
				}
			}
			
			if(k==-1) {
								throw new InvalidPowerDirectionException("There is no pieces in this direction1",this,d);
			}
			
			}
			else {
				throw new InvalidPowerDirectionException("Ranged cant wrap",this,d);
			}
			; 
			break;
				

			case UP:
				
			if(getPosI() != 0)	{	
				for(k=getPosI()-1;k>=0;k--){
				if(this.getGame().getCellAt(k, getPosJ()).getPiece() != null && !(this.getGame().getCellAt(k, getPosJ()).getPiece().getOwner().equals(this.getOwner()))){
					this.attack(this.getGame().getCellAt(k,getPosJ()).getPiece());
				//	this.setPowerUsed(true);
					break;
					
				}
				else{
					if(this.getGame().getCellAt(k,getPosJ()).getPiece() != null && (this.getGame().getCellAt(k,getPosJ()).getPiece().getOwner().equals(this.getOwner()))){
						throw new InvalidPowerDirectionException("There is no friendly fire in this game",this,d);
					}
				}
			}
			if(k==-1)
				throw new InvalidPowerDirectionException("There is no pieces in this direction2",this,d);
			}
			else {
				throw new InvalidPowerDirectionException("Ranged cant wrap",this,d);
			}
			; 
			break;		

			case DOWN:
				
			if(getPosI() != 6) {	
				for(k=getPosI()+1;k<7;k++){
				if(this.getGame().getCellAt(k, getPosJ()).getPiece() != null && !(this.getGame().getCellAt(k, getPosJ()).getPiece().getOwner().equals(this.getOwner()))){
					this.attack(this.getGame().getCellAt(k,getPosJ()).getPiece());
					//this.setPowerUsed(true);
					break;
				}
				else{
					if(this.getGame().getCellAt(k,getPosJ()).getPiece() != null && (this.getGame().getCellAt(k,getPosJ()).getPiece().getOwner().equals(this.getOwner()))){
						throw new InvalidPowerDirectionException("There is no friendly fire in this game", this,d);
					}
				}
			}
			if(k==7)
				throw new InvalidPowerDirectionException("There is no pieces in this direction3",this,d);
			
			}
			else {
				throw new InvalidPowerDirectionException("Ranged cant wrap",this,d);
			}
			;
			break;
			
			
			case UPRIGHT: throw new InvalidPowerDirectionException("Can't attack in this direction", this,d); 
			case UPLEFT: throw new InvalidPowerDirectionException("Can't attack in this direction",this,d); 
			case DOWNRIGHT: throw new InvalidPowerDirectionException("Can't attack in this direction",this,d); 
			case DOWNLEFT: throw new InvalidPowerDirectionException("Can't attack in this direction",this,d); 
			
			default: break;
		}
		
		this.getGame().switchTurns();
		this.setPowerUsed(true);
	}
	

	public String toString() {
		return "R";
	}
	
	
}
