package model.pieces.heroes;

import java.awt.Point;

import exceptions.GameActionException;
import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerUseException;
import exceptions.PowerAlreadyUsedException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public abstract class ActivatablePowerHero extends Hero {
	
	private boolean powerUsed; //read and write
	
	
	public ActivatablePowerHero(Player player, Game game, String name) {
		super(player, game, name);
		this.powerUsed = false;
	}


	public boolean isPowerUsed() {
		return powerUsed;
	}


	public void setPowerUsed(boolean powerUsed) {
		this.powerUsed = powerUsed;
	}
	
	public void usePower(Direction d, Piece target, Point newPos) throws  GameActionException {
		
		if(!(this.getOwner().equals(this.getGame().getCurrentPlayer()))){
			throw new WrongTurnException("Wrong turn! NOOB",this);
		}
		if(this.isPowerUsed()){
			throw new PowerAlreadyUsedException("You can only use a power once :) ",this);
		}
		
		this.getGame().switchTurns();
		
	}

	
		
	
}
