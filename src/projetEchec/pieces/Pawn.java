package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;
import projetEchec.UI.DirectionsEnum;
import projetEchec.UI.MainWindow;

public class Pawn extends Piece {

	public Pawn(IPlayer owner) {
		super(owner);
	}

	@Override
	public ArrayList<Cell> getPossibleDestinations(Board board) {
		ArrayList<Cell> result = new ArrayList<Cell>();
		//result.add()
		// TODO Auto-generated method stub
		
		try {
			if (board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1).getPiece() == null ) 
				result.add(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1));
			
			// Add 1st round ==> Dans le jeu, mettre au début (initialisation de cellInit();
			if (this.getCell() == cellInit() && (board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 2).getPiece() == null))
					result.add(board.getCellInDirection(this.getCell(),  DirectionsEnum.DIRECTION_NORTH, 2)); 
					
			// manger:
			if (board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_WEST, 1).getPiece().getOwner() != this.getOwner() )
				result.add(board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_WEST, 1));
			
			if (board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_EAST, 1).getPiece().getOwner() != this.getOwner() )
				result.add(board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_EAST, 1));
		}
		catch (Exception e)
		{}
		return result;
	}

	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer()) 
			return "chess_resources\\" + "pawn_black.png";
		else 
			return "chess_resources\\" + "pawn_white.png";
	}
	// in main, add : pawn.cellInit()
	public Cell cellInit() {
		Cell init = this.getCell();
		return init;
	}

}
