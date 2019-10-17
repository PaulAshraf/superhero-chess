package model.pieces.sidekicks;

import exceptions.GameActionException;
import exceptions.InvalidMovementException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class SideKickP1 extends SideKick {
	
	//Player p = this.getOwner();
	

	public SideKickP1(Game game, String name){ 
		super(game.getPlayer1(),game,name);
		
	}
	
	public void move(Direction r) throws   GameActionException {  
		
		if(!(this.getOwner().equals(this.getGame().getCurrentPlayer()))){
			throw new WrongTurnException("Wrong turn! NOOB",this);
		}
		
		switch(r){
		
			case RIGHT: moveRight(r); break;
			case LEFT: moveLeft(r); break;
			case UP: moveUp(r); break;
			case DOWN: throw new UnallowedMovementException("you cant move in this direction",this,r); 
			case UPRIGHT: moveUpRight(r); break; 
			case UPLEFT: moveUpLeft(r); break; 
			case DOWNRIGHT: throw new UnallowedMovementException("you cant move in this direction",this,r); 
			case DOWNLEFT: throw new UnallowedMovementException("you cant move in this direction",this,r); 
			default: break;
		
		}
		
		this.getGame().switchTurns();	
	}	
}
