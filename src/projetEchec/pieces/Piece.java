package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;
import projetEchec.UI.MainWindow;

public abstract class Piece {
	private IPlayer _owner;
	private Cell _cell;
	
	public abstract ArrayList<Cell> getPossibleDestinations(Board board);
	public abstract String getIconPath();
	
	public IPlayer getOwner(){
		return _owner;
	}
	
	public Piece(IPlayer owner) {
		_owner = owner;
	}
	
	public Cell getCell() {
		return _cell; 
	}
	
	public void setCell (Cell cell) {
		_cell = cell; 
	}
	
	public void moveTo(Cell cell){
		_cell.setPiece(null);
		setCell(cell);
		_cell.setPiece(this);
		MainWindow.getInstance().getModel().switchTurn();
	}
		
}
