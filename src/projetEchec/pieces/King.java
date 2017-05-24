package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;
import projetEchec.UI.DirectionsEnum;
import projetEchec.UI.MainWindow;

public class King extends Piece {

	public King(IPlayer owner) {
		super(owner);
	}
	
	// TODO Auto-generated method stub
	// Rock's problem, implement it or not ? 
	// Limit board?
	@Override
	public ArrayList<Cell> getPossibleDestinations(Board board) {
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		for (DirectionsEnum dir : DirectionsEnum.values()) {
			try {
				if(board.getCellInDirection(this.getCell(),dir, 1).getPiece() == null || board.getCellInDirection(this.getCell(),dir, 1).getPiece().getOwner() != this.getOwner() )
					
					result.add(board.getCellInDirection(this.getCell(),dir, 1));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}


	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer()) 
			return "chess_resources" + "king_black.png";
		else 
			return "chess_resources" + "king_white.png";
		
	}

}
