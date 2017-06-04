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
		
		try {
			
			Cell cellEast = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_EAST, 1);
			Cell cellWest = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_WEST, 1);
			
			if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer()){
				
				Cell cellNorth = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1);
				Cell cellNorthRank2 = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 2);
				Cell cellNorthWest = board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_WEST, 1);
				Cell cellNorthEast = board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_EAST, 1);

				/* prise en passant 
				if (cellEast != null && cellEast.getPiece() != null && 
						(cellEast.getPiece().getUseAcc() == false && this.getCell().getCellY() == 3))
					result.add(cellNorthEast);
				
				if (cellWest != null && cellWest.getPiece() != null &&
						(cellWest.getPiece().getUseAcc() == false && this.getCell().getCellY() == 3))
					result.add(cellNorthWest);
					*/
				
				if (cellNorth != null) {
					
					if (cellNorth.getPiece() == null) 
						result.add(cellNorth);
			
					if (cellNorthRank2 != null && this.getInitCell() == true &&
							cellNorthRank2.getPiece() == null && cellNorth.getPiece() == null) {
						result.add(cellNorthRank2);
					}
				}
				if (cellNorthWest != null && 
						(cellNorthWest.getPiece() != null && cellNorthWest.getPiece().getOwner() != this.getOwner()) )
					result.add(cellNorthWest);
			
				if (cellNorthEast != null &&
						(cellNorthEast.getPiece() != null && cellNorthEast.getPiece().getOwner() != this.getOwner()))
					result.add(cellNorthEast);
			}
			else {
				
				Cell cellSouth = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1);
				Cell cellSouth2= board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 2);
				Cell cellSouthWest = board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_SOUTH_WEST, 1);
				Cell cellSouthEast = board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_SOUTH_EAST, 1);
				
				/*prise en passant 
				if (cellEast != null && cellEast.getPiece() != null && 
						(cellEast.getPiece().getUseAcc() == false && this.getCell().getCellY() == 4 ))
					result.add(cellSouthEast);
				
				if (cellWest != null && cellWest.getPiece() != null &&
						(cellWest.getPiece().getUseAcc() == false && this.getCell().getCellY() == 4))
					result.add(cellSouthWest);
				*/
				
				if(cellSouth != null) {
					if (cellSouth.getPiece() == null ) 
						result.add(cellSouth);
					
					if (cellSouth2 != null &&
							(this.getInitCell()== true && cellSouth2.getPiece() == null && cellSouth.getPiece() == null)) {
						result.add(cellSouth2);
					}
				}
					if (cellSouthWest != null &&
							(cellSouthWest.getPiece() != null && cellSouthWest.getPiece().getOwner() != this.getOwner()))
						result.add(cellSouthWest);
					
					if (cellSouthEast != null &&
							(cellSouthEast.getPiece() != null && cellSouthEast.getPiece().getOwner() != this.getOwner()))
						result.add(cellSouthEast);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer()) 
			return "/pawn_black.png";
		else 
			return "/pawn_white.png";
	}
	

}
