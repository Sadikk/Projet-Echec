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
			try {
				DirectionsEnum [] directionsBishop = new DirectionsEnum[] {DirectionsEnum.DIRECTION_NORTH_EAST,
						DirectionsEnum.DIRECTION_NORTH_WEST,	
						DirectionsEnum.DIRECTION_SOUTH_WEST,
						DirectionsEnum.DIRECTION_SOUTH_EAST};
				
				for (DirectionsEnum dir : directionsBishop) {
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
			{
				e.printStackTrace();
			}
			return result;
		}
	

	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer())  
			return "/bishop_black.png";
		else 
			return "/bishop_white.png";
		
	}

}
