package model.pieces;

import exceptions.GameActionException;
import exceptions.InvalidMovementException;
import exceptions.UnallowedMovementException;
import model.game.Direction;

public interface Movable {

	public void move(Direction r) throws  GameActionException ;
		
		
		
		
	}
