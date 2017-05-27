package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;
import projetEchec.UI.DirectionsEnum;
import projetEchec.UI.MainWindow;

public class King extends Piece {

	public King(IPlayer owner) {
		super(owner);
	}
	
	// TODO Auto-generated method stub
	// Rock's problem, implement it or not ? 
	
	@Override
	public ArrayList<Cell> getPossibleDestinations(Board board) {
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		for (DirectionsEnum dir : DirectionsEnum.values()) {
			try {
				if(board.getCellInDirection(this.getCell(),dir, 1).getPiece() == null || board.getCellInDirection(this.getCell(),dir, 1).getPiece().getOwner() != this.getOwner() )
					
					result.add(board.getCellInDirection(this.getCell(),dir, 1));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Use only one between 2nd and 3rd condition
		/*Roque 1st player
		if (getInitCell() == true && board.getCell(7,0).getPiece().getInitCell() == true && board.getCellInDirection(getCell(), DirectionsEnum.DIRECTION_EAST, 3).getPiece() == Rook(MainWindow.getInstance().getModel().getFirstPlayer()) && board.getCellInDirection(getCell(), DirectionsEnum.DIRECTION_EAST, 2 ).getPiece() == null && board.getCellInDirection(getCell(), DirectionsEnum.DIRECTION_EAST, 1).getPiece() == null)
				result.add (board.getCellInDirection(getCell(), DirectionsEnum.DIRECTION_EAST, 2));
		*/
		//Roque 2nd player
			/*
			 * if (getInitCell() == true && board.getCell(0,7).getPiece().getInitCell() == true && board.getCellInDirection(getCell(), DirectionsEnum.DIRECTION_WEST, 3).getPiece() == Rook(MainWindow.getInstance().getModel().getSecondPlayer()) && board.getCellInDirection(getCell(), DirectionsEnum.DIRECTION_WEST, 2 ).getPiece() == null && board.getCellInDirection(getCell(), DirectionsEnum.DIRECTION_WEST, 1).getPiece() == null)
				result.add (board.getCellInDirection(getCell(), DirectionsEnum.DIRECTION_EAST, 2));
			 */
		return result;
	}


	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer()) 
			return "/king_black.png";
		else 
			return "/king_white.png";
		
	}
}
