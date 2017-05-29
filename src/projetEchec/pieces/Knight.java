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
		// Knights black&white don't work
		ArrayList<Cell> result = new ArrayList<Cell>();
		try {
			
			Cell cellSouth = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1);
			Cell cellNorth = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1);
			Cell cellWest = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_WEST, 1);
			Cell cellEast = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_EAST, 1);
			
		Cell cellSouthWest = board.getCellInDirection(cellSouth, DirectionsEnum.DIRECTION_SOUTH_WEST, 1);
		
		if (cellSouthWest.getPiece() == null || cellSouthWest.getPiece().getOwner() != this.getOwner())
			result.add(cellSouthWest);
		
		Cell cellSouthEast = board.getCellInDirection(cellSouth, DirectionsEnum.DIRECTION_SOUTH_EAST, 1);
		
		if (cellSouthEast.getPiece() == null || cellSouthEast.getPiece().getOwner() != this.getOwner())
			result.add(cellSouthEast);
		
		Cell cellWestSouth = board.getCellInDirection(cellWest, DirectionsEnum.DIRECTION_SOUTH_WEST, 1);
		
		if ( cellWestSouth.getPiece() == null || cellWestSouth.getPiece().getOwner() != this.getOwner())
			result.add(cellWestSouth);
		
		Cell cellWestNorth =  board.getCellInDirection(cellWest, DirectionsEnum.DIRECTION_NORTH_WEST, 1);
		
		if ( cellWestNorth.getPiece() == null || cellWestNorth.getPiece().getOwner() != this.getOwner())
			result.add(cellWestNorth);
		
		Cell cellEastSouth =  board.getCellInDirection(cellEast, DirectionsEnum.DIRECTION_SOUTH_EAST, 1);
		
		if ( cellEastSouth.getPiece() == null || cellEastSouth.getPiece().getOwner() != this.getOwner())
			result.add(cellEastSouth);
		
		Cell cellEastNorth = board.getCellInDirection(cellEast, DirectionsEnum.DIRECTION_NORTH_EAST, 1);
		
		if ( cellEastNorth.getPiece() == null || cellEastNorth.getPiece().getOwner() != this.getOwner())
			result.add(cellEastNorth);
		
		Cell cellNorthWest = board.getCellInDirection(cellNorth, DirectionsEnum.DIRECTION_NORTH_WEST, 1);
		
		if ( cellNorthWest.getPiece() == null || cellNorthWest.getPiece().getOwner() != this.getOwner())
			result.add(cellNorthWest);
		
		Cell cellNorthEast = board.getCellInDirection(cellNorth, DirectionsEnum.DIRECTION_NORTH_EAST, 1);
		
		if ( cellNorthEast.getPiece() == null || cellNorthEast.getPiece().getOwner() != this.getOwner())
			result.add(cellNorthEast);
		
		}
		catch (Exception e)
		{}
		
		return result;
	}

	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer())  
			return "/knight_black.png";
		else 
			return "/knight_white.png";
		
	}

}
