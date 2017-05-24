package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;

public abstract class Piece {
	private IPlayer _owner;
	
	public abstract ArrayList<Cell> getPossibleDestinations(Board board);
	public abstract String getIconPath();
	
	public IPlayer getOwner(){
		return _owner;
	}
	
	public Piece(IPlayer owner) {
		_owner = owner;
	}
	
	 private Cell _cell;
	 
	public Cell getCell() {
		return _cell; 
	}
	
	public void setCell (Cell cell) {
		_cell = cell; 
	}
		
		
	
}
