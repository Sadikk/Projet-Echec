package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.UI.Board;
import projetEchec.UI.Cell;

public abstract class Piece {
	private Cell _cell;
	
	public abstract ArrayList<Cell> getPossibleDestinations(Board board);
	
	public Cell getCell()
	{
		return _cell;
	}
	
	public void setCell(Cell cell)
	{
		_cell = cell;
	}
}
