package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;
import projetEchec.UI.DirectionsEnum;
import projetEchec.UI.MainWindow;

public class Knight extends Piece {

	public Knight(IPlayer owner) {
		super(owner);
	}

	@Override
	public ArrayList<Cell> getPossibleDestinations(Board board) {
		// TODO Auto-generated method stub
		
		ArrayList<Cell> result = new ArrayList<Cell>();
		try {
		if ( board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece() == null || board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece().getOwner() != this.getOwner())
			result.add(board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1));
		
		if ( board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_EAST, 1).getPiece() == null || board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece().getOwner() != this.getOwner())
			result.add(board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_EAST, 1));
		
		if ( board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_WEST, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece() == null || board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece().getOwner() != this.getOwner())
			result.add(board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_WEST, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1));
		
		if ( board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_WEST, 1), DirectionsEnum.DIRECTION_NORTH_WEST, 1).getPiece() == null || board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece().getOwner() != this.getOwner())
			result.add(board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_WEST, 1), DirectionsEnum.DIRECTION_NORTH_WEST, 1));
		
		if ( board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_EAST, 1), DirectionsEnum.DIRECTION_SOUTH_EAST, 1).getPiece() == null || board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece().getOwner() != this.getOwner())
			result.add(board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_EAST, 1), DirectionsEnum.DIRECTION_SOUTH_EAST, 1));
		
		if ( board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_EAST, 1), DirectionsEnum.DIRECTION_NORTH_EAST, 1).getPiece() == null || board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece().getOwner() != this.getOwner())
			result.add(board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_EAST, 1), DirectionsEnum.DIRECTION_NORTH_EAST, 1));
		
		if ( board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1), DirectionsEnum.DIRECTION_NORTH_WEST, 1).getPiece() == null || board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece().getOwner() != this.getOwner())
			result.add(board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1), DirectionsEnum.DIRECTION_NORTH_WEST, 1));
		
		if ( board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1), DirectionsEnum.DIRECTION_NORTH_EAST, 1).getPiece() == null || board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1), DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece().getOwner() != this.getOwner())
			result.add(board.getCellInDirection(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1), DirectionsEnum.DIRECTION_NORTH_EAST, 1));
		}
		catch (Exception e)
		{}
		
		return result;
	}

	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer())  
			return "chess_resources" + "knight_black.png";
		else 
			return "chess_resources" + "knight_white.png";
		
	}

}
