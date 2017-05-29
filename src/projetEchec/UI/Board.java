package projetEchec.UI;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import projetEchec.IPlayer;
import projetEchec.Model;
import projetEchec.pieces.*;

public class Board extends JPanel{

	public final static int BOARD_SIZE = 8;
	
	private Cell[][] _cells = new Cell[BOARD_SIZE][BOARD_SIZE];
	
	public Board() {
		super();
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        initBoard();
	}
	
	/**
	 * Genere le plateau de jeu avec le placement initial des pieces
	 */
	private void initBoard(){
		//generating grid
		for (int i = 0; i < BOARD_SIZE; i++) {
        	for (int j = 0; j < BOARD_SIZE; j++) {
        		Cell cell = new Cell(j, i, this);
        		_cells[j][i] = cell;
                add(cell);
        	}  
        }
		
		//pieces set up
		for (int i = 0; i < BOARD_SIZE; i++)
		{
			getCell(i, 1).setPiece(new Pawn(MainWindow.getInstance().getModel().getFirstPlayer()));
			getCell(i, 6).setPiece(new Pawn(MainWindow.getInstance().getModel().getSecondPlayer()));
		}
		
		
		// piece J2 rank 8 
		getCell(0, 7).setPiece(new Rook(MainWindow.getInstance().getModel().getSecondPlayer()));
<<<<<<< HEAD
		//getCell(1, 7).setPiece(new Knight(MainWindow.getInstance().getModel().getSecondPlayer()));
		//getCell(2, 7).setPiece(new Bishop(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(3, 7).setPiece(new King(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(4, 7).setPiece(new Queen(MainWindow.getInstance().getModel().getSecondPlayer()));
		//getCell(5, 7).setPiece(new Bishop(MainWindow.getInstance().getModel().getSecondPlayer()));
		//getCell(6, 7).setPiece(new Knight(MainWindow.getInstance().getModel().getSecondPlayer()));
=======
		getCell(1, 7).setPiece(new Knight(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(2, 7).setPiece(new Bishop(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(3, 7).setPiece(new Queen(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(4, 7).setPiece(new King(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(5, 7).setPiece(new Bishop(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(6, 7).setPiece(new Knight(MainWindow.getInstance().getModel().getSecondPlayer()));
>>>>>>> 1a9ba0e0fd344b3be2877b2f3ed76c6abeb54458
		getCell(7, 7).setPiece(new Rook(MainWindow.getInstance().getModel().getSecondPlayer()));
		
		getCell(0, 0).setPiece(new Rook(MainWindow.getInstance().getModel().getFirstPlayer()));
		//getCell(1, 0).setPiece(new Knight(MainWindow.getInstance().getModel().getFirstPlayer()));
		//getCell(2, 0).setPiece(new Bishop(MainWindow.getInstance().getModel().getFirstPlayer()));
		getCell(3, 0).setPiece(new Queen(MainWindow.getInstance().getModel().getFirstPlayer()));
		getCell(4, 0).setPiece(new King(MainWindow.getInstance().getModel().getFirstPlayer()));
		//getCell(5, 0).setPiece(new Bishop(MainWindow.getInstance().getModel().getFirstPlayer()));
		//getCell(6, 0).setPiece(new Knight(MainWindow.getInstance().getModel().getFirstPlayer()));
		getCell(7, 0).setPiece(new Rook(MainWindow.getInstance().getModel().getFirstPlayer()));
	}
	
	/**
	 * Recupere une cellule du plateau de jeu depuis ses coordonnees
	 * @param x abscisse
	 * @param y ordonnee 
	 * @return La cellule du plateau de jeu aux coordonnees (x,y)
	 * @author Valentin
	 */
	public Cell getCell(int x, int y){
		if (isInBoard(x, y))
			return _cells[x][y];
		else
			return null;
	}
	
	/**
	 * Verifie qu'une cellule est à l'intérieur du plateau de jeu
	 * @param x abscisse de la cellule
	 * @param y ordonnee de la cellule
	 * @return true si à l'intérieur du plateau, faux sinon
	 * @author Valentin
	 */
	public boolean isInBoard(int x, int y){
		return x < BOARD_SIZE && x >= 0
				&& y < BOARD_SIZE && y >= 0;
	}
	
	/**
	 * Déselectionne toutes les cellules du plateau
	 * @author Valentin
	 */
	public void clearHighlights(){
		for (int i = 0; i < BOARD_SIZE; i++) {
        	for (int j = 0; j < BOARD_SIZE; j++) {
        		if (_cells[j][i].getHighlighted())
        			_cells[j][i].highlight();
        	}
		}
	}
	
	/**
	 * Récupère la pièce selectionnée actuellement par un joueur
	 * @param owner Proprietaire de la pièce
	 * @return la pièce selectionnée
	 * @author Valentin
	 */
	public ArrayList<Piece> getHighlightedPieces(IPlayer owner){
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		for (int i = 0; i < BOARD_SIZE; i++) {
        	for (int j = 0; j < BOARD_SIZE; j++) {
        		if (_cells[j][i].getPiece() != null && _cells[j][i].getPiece().getOwner() == owner &&_cells[j][i].getHighlighted())
        			pieces.add(_cells[j][i].getPiece());
        	}
		}
		return pieces;
	}
	
	/**
	 * Retourne le nombre de mouvements legaux possibles pour un joueur
	 * @param player Le joueur a considerer
	 * @return le nombre de mouvements possibles
	 * @author Valentin
	 * @deprecated 
	 */
	public int getLegalMoveCount(IPlayer player){
		ArrayList<Cell> result = new ArrayList<Cell>();
		for (int i = 0; i < BOARD_SIZE; i++) {
        	for (int j = 0; j < BOARD_SIZE; j++) {
        		if (_cells[j][i].getPiece() != null && _cells[j][i].getPiece().getOwner() == player)
        			result.addAll(_cells[j][i].getPiece().getPossibleDestinations(this));
        	}
		}
		return result.size();
	}
	
	/**
	 * Recupere une cellule dans une direction donnee, à une distance donnee
	 * @param from cellule de depart
	 * @param direction direction dans lequelle chercher la cellule
	 * @param step distance a parcourir
	 * @return La cellule cherchee si elle est dans le plateau, null sinon
	 * @throws Exception si direction inconnue
	 * @author Valentin
	 */
	public Cell getCellInDirection(Cell from, DirectionsEnum direction, int step) throws Exception
    {
        Cell cell;
        int X = from.getCellX();
        int Y = from.getCellY();
        switch (direction)
        {
            case DIRECTION_EAST:
                {
                	cell = getCell(X + step, Y);
                    break;
                }
            case DIRECTION_SOUTH_EAST:
                {
                	cell = getCell(X + step, Y + step);
                    break;
                }
            case DIRECTION_SOUTH:
                {
                	cell = getCell(X, Y + step);
                    break;
                }
            case DIRECTION_SOUTH_WEST:
                {
                	cell = getCell(X - step, Y + step);
                    break;
                }
            case DIRECTION_WEST:
                {
                	cell = getCell(X - step, Y);
                    break;
                }
            case DIRECTION_NORTH_WEST:
                {
                	cell = getCell(X - step, Y - step);
                    break;
                }
            case DIRECTION_NORTH:
                {
                	cell = getCell(X, Y - step);
                    break;
                }
            case DIRECTION_NORTH_EAST:
                {
                	cell = getCell(X + step, Y - step);
                    break;
                }
            default:
                throw new Exception("Unknown direction : " + direction);
        }
        return cell;
    }
}
