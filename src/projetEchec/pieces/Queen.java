package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;
import projetEchec.UI.DirectionsEnum;
import projetEchec.UI.MainWindow;

public class Queen extends Piece {

	public Queen(IPlayer owner) {
		super(owner);
	}
	/**
	 * Chemins proposés spécifiques à la Reine
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
			return "/queen_black.png";
		else 
			return "/queen_white.png";
	}

}
