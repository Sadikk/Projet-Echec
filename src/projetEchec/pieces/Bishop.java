package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;
import projetEchec.UI.MainWindow;

public class Bishop extends Piece {

	public Bishop(IPlayer owner) {
		super(owner);
	}

	@Override
	public ArrayList<Cell> getPossibleDestinations(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer())  
			return "/bishop_black.png";
		else 
			return "/bishop_white.png";
		
	}

}
