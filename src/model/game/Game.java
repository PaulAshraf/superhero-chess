package model.game;
import java.util.*;

import exceptions.OccupiedCellException;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Hero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKickP1;
import model.pieces.sidekicks.SideKickP2;





public class Game {
		
		   //read only unless stated otherwise
	private final int payloadPosTarget;
	private final int boardWidth;
	private final int boardHeight;
	private Player player1;
	private Player player2;
	private Player currentPlayer; //read and write
	private Cell[][] board; //Neither read nor write
	
	public Game(Player player1, Player player2){
		this.boardHeight = 7;
		this.boardWidth = 6;
		this.currentPlayer = player1;
		this.player1 = player1;
		this.player2 = player2;
		this.payloadPosTarget = 6;
		this.board = new Cell [7][6];
		assemblePieces();   //FIX THIS
	}

	public int getPayloadPosTarget() {
		return payloadPosTarget;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}
	
	public Player getPlayer1(){
		return this.player1;
	}
	
	public Player getPlayer2(){
		return this.player2;
	}
	
	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}

	public void setCurrentPlayer(Player p){
		this.currentPlayer = p;
	}
	
	public void assemblePieces(){
		
		// double randomGenerator = (int)(Math.random() * 6 ); //pick hero randomly 
		
		Hero[] p1 = new Hero [6];
		Hero[] p2 = new Hero [6];
		SideKickP1[] s1 = new SideKickP1[6];
		SideKickP2[] s2 = new SideKickP2[6];
		
		p1[0] = new Armored(this.player1,this,this.player1.getName());  
		p2[0]= new Armored(this.player2,this,this.player2.getName());  
		
		p1[1] = new Medic(this.player1,this,this.player1.getName());  
		p2[1] = new Medic(this.player2,this,this.player2.getName());  
		
		p1[2] = new Ranged(this.player1,this,this.player1.getName());  
		p2[2] = new Ranged(this.player2,this,this.player2.getName());  
		
		p1[3] = new Speedster(this.player1,this,this.player1.getName());  
		p2[3] = new Speedster(this.player2,this,this.player2.getName());  
		
		p1[4] = new Super(this.player1,this,this.player1.getName());  
		p2[4] = new Super(this.player2,this,this.player2.getName());  
		
		p1[5] = new Tech(this.player1,this,this.player1.getName());  
		p2[5] = new Tech(this.player2,this,this.player2.getName());  
		
		
		Integer[] num1 = new Integer[6];            //random numbers for p1 heros
		for (int i = 0; i < num1.length; i++) {
		    num1[i] = i;
		    s1[i] = new SideKickP1(this,this.getPlayer1().getName());
		 }
		 Collections.shuffle(Arrays.asList(num1));
		 
		 Integer[] num2 = new Integer[6];			// random numbers for p2 heros
			for (int i = 0; i < num2.length; i++) {
			    num2[i] = i;
			    s2[i] = new SideKickP2(this,this.getPlayer2().getName());
			 }
			 Collections.shuffle(Arrays.asList(num2));
			
		
		 
		 for(int i=0;i<6;i++){
			 board[0][i] = new Cell(null);
			 board[1][i] = new Cell(p2[num1[i]]);
			 p2[num1[i]].setPosI(1);
			 p2[num1[i]].setPosJ(i);
			 board[2][i] = new Cell(s2[i]);
			 s2[i].setPosI(2);
			 s2[i].setPosJ(i);
			 board[3][i] = new Cell(null);
			 board[4][i] = new Cell(s1[i]);
			 s1[i].setPosI(4);
			 s1[i].setPosJ(i);
			 board[5][i] = new Cell(p1[num2[i]]);
			 p1[num2[i]].setPosI(5);
			 p1[num2[i]].setPosJ(i);
			 board[6][i] = new Cell(null);
			 
			
			
		 } 
		}
		

	
	
	
	
	
	
	
	
	
		public Cell getCellAt(int i, int j){
	
				return board[i][j];
	
		}

		
		public void switchTurns(){
			if(getCurrentPlayer().equals(getPlayer1()))
				setCurrentPlayer(getPlayer2());
			else
				setCurrentPlayer(getPlayer1());
		}
		
		public boolean checkWinner(){
			
			return currentPlayer.getPayloadPos()==payloadPosTarget;
			
			
			
		}
		
		public String toString() {
			String s = "";
			System.out.println("      " + getPlayer2().getName());
			System.out.print("| ");
			for (int i = 0; i < board[0].length; i++)
				System.out.print("--");
			System.out.println("|");
			for (int i = 0; i < board.length; i++) {
				System.out.print("| ");
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == null)
						System.out.print("n ");
					else
						System.out.print(board[i][j] + " ");
				}
				System.out.println("|");
			}
			System.out.print("| ");
			for (int i = 0; i < board[0].length; i++)
				System.out.print("--");
			System.out.println("|");
			System.out.println("    " + getPlayer1().getName());
			return s;
		}
	
	

}


