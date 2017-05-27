package projetEchec.pieces;

import java.util.ArrayList;

import projetEchec.IPlayer;
import projetEchec.UI.Board;
import projetEchec.UI.Cell;
import projetEchec.UI.MainWindow;

public abstract class Piece {
	private IPlayer _owner;
	private Cell _cell;
	
	/**
	 * Recupere tous les coups legaux disponibles de la piece
	 * @param board Plateau de jeu
	 * @return Collection des cellules possibles
	 */
	public abstract ArrayList<Cell> getPossibleDestinations(Board board);
	/**
	 * Recupere le chemin vers l'icone associee à la piece
	 * @return le chemin
	 */
	public abstract String getIconPath();
	
	public IPlayer getOwner(){
		return _owner;
	}
	
	public Piece(IPlayer owner) {
		_owner = owner;
	}
	
	public Cell getCell() {
		return _cell; 
	}
	
	public void setCell (Cell cell) {
		_cell = cell; 
	}
	
	/**
	 * Effectue le mouvement de la pièce et passe au tour suivant
	 * @param cell cellule de destination de la pièce
	 * signale que la piece a quitté sa position initiale
	 */
	public void moveTo(Cell cell){
		_cell.setPiece(null);
		setCell(cell);
		_cell.setPiece(this);
		MainWindow.getInstance().getModel().switchTurn();
		_initCell = false;
	}
		
	private boolean _initCell = true;
	
	public boolean getInitCell() {
		return _initCell;
	}
	
}
