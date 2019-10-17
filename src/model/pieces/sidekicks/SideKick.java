package model.pieces.sidekicks;

import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Hero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;

public abstract class SideKick extends Piece{
	
	public SideKick(Player player, Game game, String name){
		super(player,game,name);
	}

	@Override
	public void attack(Piece target){
		
		if(target instanceof Hero){
			if(target instanceof Armored){
				if (((Armored)target).isArmorUp()){
					((Armored)target).setArmorUp(false);
				}	
				else{
					Armored a = new Armored(this.getOwner(),this.getGame(),this.getOwner().getName());
					target.getOwner().getDeadCharacters().add(target);
					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(a); 
					a.setPosI(this.getPosI());
					a.setPosJ(this.getPosJ());
					a.getGame().getCellAt(target.getPosI(),target.getPosJ()).setPiece(null); 
					a.getOwner().setPayloadPos((a.getOwner().getPayloadPos())+1);
					this.getGame().checkWinner();	
				}
			}
			else{
				if(target instanceof Speedster) {
					Speedster a = new Speedster(this.getOwner(),this.getGame(),this.getOwner().getName());
					target.getOwner().getDeadCharacters().add(target);
					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(a); 
					a.setPosI(this.getPosI());
					a.setPosJ(this.getPosJ());
					a.getOwner().setPayloadPos((this.getOwner().getPayloadPos())+1);
					a.getGame().getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
					this.getGame().checkWinner();	
				}
				if(target instanceof Super) {
					Super a = new Super(this.getOwner(),this.getGame(),this.getOwner().getName());
					target.getOwner().getDeadCharacters().add(target);
					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(a); 
					a.setPosI(this.getPosI());
					a.setPosJ(this.getPosJ());
					a.getOwner().setPayloadPos((this.getOwner().getPayloadPos())+1);
					a.getGame().getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
					this.getGame().checkWinner();	
				}
				if(target instanceof Ranged) {
					Ranged a = new Ranged(this.getOwner(),this.getGame(),this.getOwner().getName());
					target.getOwner().getDeadCharacters().add(target);
					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(a); 
					a.setPosI(this.getPosI());
					a.setPosJ(this.getPosJ());
					a.getOwner().setPayloadPos((this.getOwner().getPayloadPos())+1);
					a.getGame().getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
					this.getGame().checkWinner();	
				}
				if(target instanceof Tech) {
					Tech a = new Tech(this.getOwner(),this.getGame(),this.getOwner().getName());
					target.getOwner().getDeadCharacters().add(target);
					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(a); 
					a.setPosI(this.getPosI());
					a.setPosJ(this.getPosJ());
					a.getOwner().setPayloadPos((this.getOwner().getPayloadPos())+1);
					a.getGame().getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
					this.getGame().checkWinner();	
				}
				if(target instanceof Medic) {
					Medic a = new Medic(this.getOwner(),this.getGame(),this.getOwner().getName());
					target.getOwner().getDeadCharacters().add(target);
					this.getGame().getCellAt(getPosI(), getPosJ()).setPiece(a); 
					a.setPosI(this.getPosI());
					a.setPosJ(this.getPosJ());
					a.getOwner().setPayloadPos((this.getOwner().getPayloadPos())+1);
					a.getGame().getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
					this.getGame().checkWinner();	
				}
				
				
			}
		}
		else{
			target.getOwner().getDeadCharacters().add(target);
			this.getOwner().setSideKilled(this.getOwner().getSideKilled()+1);
			//this.getOwner().setDeadSideKick(this.getOwner().getDeadSideKick()+1);
			if(this.getOwner().getSideKilled() % 2 == 0){   // ++(this.getDeadSIdeKilled) == 2
				//this.getOwner().setDeadSideKick(0);
				this.getOwner().setPayloadPos((this.getOwner().getPayloadPos())+1);
					
				
			}
			this.getGame().getCellAt(target.getPosI(), target.getPosJ()).setPiece(null);
			this.getGame().checkWinner();
			
			
			
		}
		
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "K";
	}
}