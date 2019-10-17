package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerDirectionException;
import exceptions.PowerAlreadyUsedException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Armored extends NonActivatablePowerHero {

	private boolean armorUp; //read and write
	
	public Armored(Player player, Game game, String name) {
		super(player, game, name);
		this.setArmorUp(true);
		
	}

	public boolean isArmorUp() {
		return armorUp;
	}

	public void setArmorUp(boolean armorUp) {
		this.armorUp = armorUp;
	}
	
//	public void usePower(Direction d, Piece target, Point newPos) throws  PowerAlreadyUsedException {   //??????
//			if(this.isArmorUp() == false){
//				throw new PowerAlreadyUsedException(this);
//			}
//			else{
//				this.setArmorUp(false);
//			}
//	
//	
//	}
	
	
	@Override
	public String toString() {
		return "A";
	}

	
}
