package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;
import projetEchec.UI.DirectionsEnum;
import projetEchec.UI.MainWindow;

public class Bishop extends Piece {

	public Bishop(IPlayer owner) {
		super(owner);
	}

	/**
	 * Chemins proposés spécifiques au Fou
	 */
	@Override
	public ArrayList<Cell> getPossibleDestinations(Board board) {
		ArrayList<Cell> result = new ArrayList<Cell>();
		{
			try {
				if ( board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH_WEST, 8).getPiece() == null || board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH_WEST, 1).getPiece().getOwner() != this.getOwner() )
					result.add(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH_WEST, 1));
				
				if ( board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH_EAST, 8).getPiece() == null || board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_EAST, 1).getPiece().getOwner() != this.getOwner()  )
					result.add(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH_EAST, 1));
				
				if ( board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH_WEST, 8).getPiece() == null || board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece().getOwner() != this.getOwner() )
					result.add(board.getCellInDirection(this.getCell(),DirectionsEnum.DIRECTION_SOUTH_WEST, 1));
				
				if ( board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH_WEST, 8).getPiece() == null || board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece().getOwner() != this.getOwner() )
					result.add(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH_WEST, 1));
		
			}
			catch (Exception e)
			{}
		return result;
		}
	}

	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer())  
			return "/bishop_black.png";
		else 
			return "/bishop_white.png";
		
	}

}
