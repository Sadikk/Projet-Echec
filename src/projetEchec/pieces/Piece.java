package projetEchec.pieces;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.EventListenerList;

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
		boolean ended = cell.getPiece() != null && cell.getPiece() instanceof King;
		Cell oldCell = _cell;
		_cell.setPiece(null);
		setCell(cell);
		_cell.setPiece(this);
		MainWindow.getInstance().getModel().switchTurn();
		firePositionChanged(oldCell, cell);
		_initCell = false;
		if (ended)
			JOptionPane.showMessageDialog(MainWindow.getInstance(), "Le roi a été mangé, fin de la partie !");
		
	}
		
	private boolean _initCell = true;
	
	public boolean getInitCell() {
		return _initCell;
	}
	
	private boolean _useAcc = false;
	
	public boolean getUseAcc () {
		return _useAcc ;
	}
	
	public void setUseAcc() {
		_useAcc = true;
	}
	
	//observer pattern
	private final EventListenerList _listeners = new EventListenerList();
	
	public void addMovementListener(IMovementListener listener){
		_listeners.add(IMovementListener.class, listener);
	}
	
	public void removeMovementListener(IMovementListener listener){
		_listeners.remove(IMovementListener.class, listener);
	}
	
	public IMovementListener[] getMovementListeners() {
		return _listeners.getListeners(IMovementListener.class);
	}
	
	protected void firePositionChanged(Cell oldCell, Cell newCell){
		for (IMovementListener listener : getMovementListeners())
			listener.positionChanged(oldCell, newCell);
	}
	
}
