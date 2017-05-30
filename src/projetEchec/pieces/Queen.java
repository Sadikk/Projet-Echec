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
					for (DirectionsEnum dir : DirectionsEnum.values()){
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
	}

	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer())  
			return "/queen_black.png";
		else 
			return "/queen_white.png";
	}

}
