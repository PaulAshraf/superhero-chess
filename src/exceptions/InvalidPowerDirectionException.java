package exceptions;

import model.game.Direction;
import model.pieces.Piece;


public class InvalidPowerDirectionException extends InvalidPowerUseException {

	Direction direction;
	
	public InvalidPowerDirectionException(Piece trigger, Direction d){
		super(trigger);
		this.direction = d;
		
	}
	
	public InvalidPowerDirectionException(String s, Piece trigger, Direction d){
		super(s,trigger);
		this.direction = d;
	}
	
	public Direction getDirection(){
		return this.direction;
	}
}
