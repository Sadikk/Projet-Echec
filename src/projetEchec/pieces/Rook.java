package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;
import projetEchec.UI.DirectionsEnum;
import projetEchec.UI.MainWindow;

public class Rook extends Piece {

	public Rook(IPlayer owner) {
		super(owner);
	}

	/**
	 * Chemins proposés spécifiques à la Tour
	 */
	@Override
	public ArrayList<Cell> getPossibleDestinations(Board board) {
		ArrayList<Cell> result = new ArrayList<Cell>();
		{
			try {
				if (board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 8).getPiece() == null || board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1).getPiece().getOwner() != this.getOwner() )
					result.add(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1));
				
				if (board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 8).getPiece() == null || board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1).getPiece().getOwner() != this.getOwner() )
					result.add(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1));
				
				if ( board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_WEST, 8).getPiece() == null || board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_WEST, 1).getPiece().getOwner() != this.getOwner() )
					result.add(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_WEST, 1));
				
				if ( board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_EAST, 8).getPiece() == null || board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_EAST, 1).getPiece().getOwner() != this.getOwner() )
					result.add(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_EAST, 1));
			}
				catch (Exception e)
				{}
				
				return result;
			}
		
	}

	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer())  
			return "/rook_black.png";
		else 
			return "/rook_white.png";
	}

}
