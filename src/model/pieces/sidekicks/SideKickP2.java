package model.pieces.sidekicks;

import exceptions.GameActionException;
import exceptions.InvalidMovementException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class SideKickP2 extends SideKick {
	
	
	
	
	public SideKickP2(Game game, String name){ 
		super(game.getPlayer2(),game,name);
	}
	
	@Override
	public void move(Direction r) throws   GameActionException {  
		
		if(!(this.getOwner().equals(this.getGame().getCurrentPlayer()))){
			throw new WrongTurnException("Wrong turn! NOOB",this);
		}
		
		switch(r){
		
			case RIGHT: moveRight(r); break;
			case LEFT: moveLeft(r); break;
			case UP: throw new UnallowedMovementException("you cant move in this direction",this,r);
			case DOWN: moveDown(r); break; 
			case UPRIGHT: throw new UnallowedMovementException("you cant move in this direction",this,r); 
			case UPLEFT: throw new UnallowedMovementException("you cant move in this direction",this,r);
			case DOWNRIGHT: moveDownRight(r); break; 
			case DOWNLEFT: moveDownLeft(r); break; 
			default: break;
		
		}
		this.getGame().switchTurns();
	}	
	
}	