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
			
			Cell cellEast = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_EAST, 1);
			Cell cellWest = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_WEST, 1);
			
			if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer()){
				
				Cell cellNorth = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1);
				Cell cellNorthRank2 = board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 2);
				Cell cellNorthWest = board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_WEST, 1);
				Cell cellNorthEast = board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_EAST, 1);

				 // prise en passant 
				if (cellEast != null && cellEast.getPiece() != null && cellEast.getPiece() instanceof Pawn &&
						(((Pawn)cellEast.getPiece()).getUseAcc() == true && 
						this.getCell().getCellY() == 3)) {
				
					result.add(cellNorthEast);
					_priseEnPassant = true;
				}
				
				if (cellWest != null && cellWest.getPiece() != null && cellWest.getPiece() instanceof Pawn &&
						(((Pawn)cellWest.getPiece()).getUseAcc() == true &&
						this.getCell().getCellY() == 3)){
				
					result.add(cellNorthWest);
					_priseEnPassant = true;
				}
				
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
				
				// prise en passant 
				if (cellEast != null && cellEast.getPiece() != null && cellEast.getPiece() instanceof Pawn &&
						(((Pawn)cellEast.getPiece()).getUseAcc() == true && 
						this.getCell().getCellY() == 4 )) {
					result.add(cellSouthEast);
					_priseEnPassant = true;
				}
				
				if (cellWest != null && cellWest.getPiece() != null && cellWest.getPiece() instanceof Pawn &&
						(((Pawn)cellWest.getPiece()).getUseAcc() == true &&
						this.getCell().getCellY() == 4)) {
					result.add(cellSouthWest );
					_priseEnPassant = true;
				}
			
				
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
	
	private boolean _useAcc = false;
	
	public boolean getUseAcc () {
		return _useAcc ;
	}
	
	public void setUseAcc(boolean useAcc) {
		_useAcc = useAcc;
	}
	
	private boolean _priseEnPassant = false;
	
	public boolean getPriseEnPassant(){
		return _priseEnPassant;
	}
	
	public void setPriseEnPassant(boolean prise){
		_priseEnPassant = prise;
	}
	

	public void positionChanged(Cell oldCell, Cell newCell){		
		if (Math.sqrt(Math.pow(newCell.getCellX() - oldCell.getCellX(),2)
				+ Math.pow(newCell.getCellY() - oldCell.getCellY(),2)) == 2)
		{
			this.setUseAcc(true);
		}
		if (newCell.getCellY() == 0 || newCell.getCellY() == 7 ){
			newCell.setPiece(new Queen(this.getOwner()));
		}
	}




}
