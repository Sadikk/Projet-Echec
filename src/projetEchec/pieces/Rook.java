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
				DirectionsEnum [] directionsRook = new DirectionsEnum[] {
						DirectionsEnum.DIRECTION_NORTH,	
						DirectionsEnum.DIRECTION_WEST,
						DirectionsEnum.DIRECTION_SOUTH,
						DirectionsEnum.DIRECTION_EAST};
				
				for (DirectionsEnum dir : directionsRook) {
					int i = 1;
					Cell cell = board.getCellInDirection(this.getCell(), dir, i);
					while (cell != null && cell.getPiece() == null)
					{
						result.add(cell);
						i++;
						cell = board.getCellInDirection(this.getCell(), dir, i);
					}
				
					//pour manger
					if (cell != null && cell.getPiece() != null && cell.getPiece().getOwner() != this.getOwner()) {
						result.add(cell);
					}
				}
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
