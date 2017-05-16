package projetEchec.UI;

import java.awt.GridLayout;
import javax.swing.JPanel;

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
		getCell(1, 7).setPiece(new Knight(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(2, 7).setPiece(new Bishop(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(3, 7).setPiece(new King(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(4, 7).setPiece(new Queen(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(5, 7).setPiece(new Bishop(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(6, 7).setPiece(new Knight(MainWindow.getInstance().getModel().getSecondPlayer()));
		getCell(7, 7).setPiece(new Rook(MainWindow.getInstance().getModel().getSecondPlayer()));
		
		getCell(0, 0).setPiece(new Rook(MainWindow.getInstance().getModel().getFirstPlayer()));
		getCell(1, 0).setPiece(new Knight(MainWindow.getInstance().getModel().getFirstPlayer()));
		getCell(2, 0).setPiece(new Bishop(MainWindow.getInstance().getModel().getFirstPlayer()));
		getCell(3, 0).setPiece(new Queen(MainWindow.getInstance().getModel().getFirstPlayer()));
		getCell(4, 0).setPiece(new King(MainWindow.getInstance().getModel().getFirstPlayer()));
		getCell(5, 0).setPiece(new Bishop(MainWindow.getInstance().getModel().getFirstPlayer()));
		getCell(6, 0).setPiece(new Knight(MainWindow.getInstance().getModel().getFirstPlayer()));
		getCell(7, 0).setPiece(new Rook(MainWindow.getInstance().getModel().getFirstPlayer()));
	}
	
	public Cell getCell(int x, int y){
		if (isInBoard(x, y))
			return _cells[x][y];
		else
			return null;
	}
	
	public boolean isInBoard(int x, int y){
		return x < BOARD_SIZE && x >= 0
				&& y < BOARD_SIZE && y >= 0;
	}
	
	public Cell GetCellInDirection(Cell from, DirectionsEnum direction, short step) throws Exception
    {
        Cell cell;
        int X = from.getCellX();
        int Y = from.getCellY();
        switch (direction)
        {
            case DIRECTION_EAST:
                {
                	cell = new Cell(X + step, Y + step);
                    break;
                }
            case DIRECTION_SOUTH_EAST:
                {
                	cell = new Cell(X + step, Y);
                    break;
                }
            case DIRECTION_SOUTH:
                {
                	cell = new Cell(X + step, Y - step);
                    break;
                }
            case DIRECTION_SOUTH_WEST:
                {
                	cell = new Cell(X, Y - step);
                    break;
                }
            case DIRECTION_WEST:
                {
                	cell = new Cell(X - step, Y - step);
                    break;
                }
            case DIRECTION_NORTH_WEST:
                {
                	cell = new Cell(X - step, Y);
                    break;
                }
            case DIRECTION_NORTH:
                {
                	cell = new Cell(X - step, Y + step);
                    break;
                }
            case DIRECTION_NORTH_EAST:
                {
                	cell = new Cell(X, Y + step);
                    break;
                }
            default:
                throw new Exception("Unknown direction : " + direction);
        }

        return cell;
    }
}
