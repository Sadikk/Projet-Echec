package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;

public class Pawn extends Piece {

	public Pawn(IPlayer owner) {
		super(owner);
	}

	@Override
	public ArrayList<Cell> getPossibleDestinations(Board board) {
		ArrayList<Cell> result = new ArrayList<Cell>();
		//result.add()
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public String getIconPath() {
		
		return null;
	}

}
