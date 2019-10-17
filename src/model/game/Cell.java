package model.game;

import model.pieces.Piece;

public class Cell {

	Piece piece;
	
	public Cell(){}
		
	public Cell(Piece piece){
		this.piece = piece;
	}
	
	public Piece getPiece(){
		return this.piece;
	}
	
	public void setPiece(Piece p){
		this.piece = p;
	}
	@Override
	public String toString() {
		if(piece != null)
			return piece.toString();
		
		return "n";
	}

	
}
