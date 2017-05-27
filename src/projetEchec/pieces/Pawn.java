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
	/**
	 *Liste les possibilités de déplacement en fonction de la situation du pion
	 * @param board Plateau 
	 * @return la liste de solutions
	 * @author Mathieu
	 */
	public ArrayList<Cell> getPossibleDestinations(Board board) {
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		try {
			if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer()){
				
				if (board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1).getPiece() == null) 
					result.add(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 1));
			
				if (this.getInitCell() == true && (board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_NORTH, 2).getPiece() == null))
					result.add(board.getCellInDirection(this.getCell(),  DirectionsEnum.DIRECTION_NORTH, 2)); 
					
				if (board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_WEST, 1).getPiece().getOwner() != this.getOwner() )
					result.add(board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_WEST, 1));
			
				if (board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_EAST, 1).getPiece().getOwner() != this.getOwner() )
					result.add(board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_EAST, 1));
			}
			else {
				if (board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1).getPiece() == null ) 
					result.add(board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 1));
				
				if (this.getInitCell()== true && (board.getCellInDirection(this.getCell(), DirectionsEnum.DIRECTION_SOUTH, 2).getPiece() == null))
					result.add(board.getCellInDirection(this.getCell(),  DirectionsEnum.DIRECTION_SOUTH, 2));
				
				if (board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_SOUTH_WEST, 1).getPiece().getOwner() != this.getOwner() )
					result.add(board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_SOUTH_WEST, 1));
			
				if (board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_NORTH_EAST, 1).getPiece().getOwner() != this.getOwner() )
					result.add(board.getCellInDirection(getCell(),DirectionsEnum.DIRECTION_SOUTH_EAST, 1));
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
