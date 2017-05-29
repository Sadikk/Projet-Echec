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
	
	@Override
	public ArrayList<Cell> getPossibleDestinations(Board board) {
		ArrayList<Cell> result = new ArrayList<Cell>();
		try {
			
		for (DirectionsEnum dir : DirectionsEnum.values()) {
			
				
			Cell cellDirection = board.getCellInDirection(this.getCell(),dir, 1);
			
				if(cellDirection != null && (cellDirection.getPiece() == null || 
						(cellDirection.getPiece() != null && cellDirection.getPiece().getOwner() != this.getOwner())))
					result.add(cellDirection);
				
			
		}
		// Roques
		IPlayer firstPlayer = MainWindow.getInstance().getModel().getFirstPlayer();
		
		if (getInitCell() == true && this.getOwner() == firstPlayer ) {
			
			Cell cellKnight = board.getCell(6,0);
			Cell cellBishop = board.getCell(5,0);
			Cell cellRook = board.getCell(7,0);
			Cell cellGKnight = board.getCell(1,0);
			Cell cellGBishop =board.getCell(2,0);
			Cell cellGRook = board.getCell(0,0);
			Cell cellQueen = board.getCell(3,0);
		
			if (cellRook.getPiece() != null && cellRook.getPiece().getInitCell() == true
					&& cellKnight.getPiece() == null && cellBishop.getPiece() == null)
				result.add (cellRook);
			
			if (cellGRook.getPiece() != null && cellGRook.getPiece().getInitCell() == true
					&& cellGKnight.getPiece() == null && cellGBishop.getPiece() == null && cellQueen.getPiece() == null)
				result.add (cellGRook);
		}
		else {
			
			Cell cellKnight = board.getCell(6,7);
			Cell cellBishop = board.getCell(5,7);
			Cell cellRook = board.getCell(7,7);
			Cell cellGKnight = board.getCell(1,7);
			Cell cellGBishop = board.getCell(2, 7);
			Cell cellGRook = board.getCell(0,7);
			Cell cellQueen = board.getCell(3, 7);
			
			if (getInitCell() == true && cellRook.getPiece() != null && cellRook.getPiece().getInitCell() == true &&
					cellKnight.getPiece() == null && cellBishop.getPiece() == null)
				result.add (cellRook);
				
			if (getInitCell() == true && cellGRook.getPiece() != null && cellGRook.getPiece().getInitCell() == true &&
					cellGKnight.getPiece() == null && cellGBishop.getPiece() == null && cellQueen.getPiece() == null)
				result.add (cellGRook);
		}
		
		
		
		return result;
	} catch (Exception e) {
		e.printStackTrace();
	}
		return result;
	}

	@Override
	public String getIconPath() {
		if (getOwner() == MainWindow.getInstance().getModel().getSecondPlayer()) 
			return "/king_black.png";
		else 
			return "/king_white.png";
		
	}
}
