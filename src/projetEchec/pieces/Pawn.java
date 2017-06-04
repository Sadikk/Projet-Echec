package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;
import projetEchec.UI.DirectionsEnum;
import projetEchec.UI.MainWindow;

public class Pawn extends Piece implements IMovementListener {

	public Pawn(IPlayer owner) {
		super(owner);
		addMovementListener(this);
	}

	@Override
	
	public ArrayList<Cell> getPossibleDestinations(Board board) {
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		try {
			if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer()){
				
				Cell cellNorth = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1);
				Cell cellNorthRank2 = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 2);
				Cell cellNorthWest = board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_WEST, 1);
				Cell cellNorthEast = board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_EAST, 1);
				
				if (cellNorth != null) {
					
					if (cellNorth.getPiece() == null) 
						result.add(cellNorth);
			
					if (cellNorthRank2 != null && 
							this.getInitCell() == true && cellNorthRank2.getPiece() == null && cellNorth.getPiece() == null)
						result.add(cellNorthRank2); 
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
				Cell cellSouth2=board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 2);
				Cell cellSouthWest = board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_SOUTH_WEST, 1);
				Cell cellSouthEast = board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_SOUTH_EAST, 1);
				
				if(cellSouth != null) {
					if (cellSouth.getPiece() == null ) 
						result.add(cellSouth);
					
					if (cellSouth2 != null &&
							(this.getInitCell()== true && cellSouth2.getPiece() == null && cellSouth.getPiece() == null))
						result.add(board.getCellInDirection(this.getCell(),  DirectionsEnum.DIRECTION_SOUTH, 2));
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
	
	public void positionChanged(Cell oldCell, Cell newCell){
			if (newCell.getCellY() == 0 || newCell.getCellY() == 7 ){
				newCell.setPiece(new Queen(this.getOwner()));
			}
	}
}
