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
		for (int i = 1; i <= BOARD_SIZE; i++) {
        	for (int j = 1; j <= BOARD_SIZE; j++) {
        		Cell cell = new Cell(j, i);
        		_cells[j -1][i -1] = cell;
                add(cell);
        	}  
        }
		
		//pieces set up
		for (int i = 0; i < BOARD_SIZE; i++)
		{
			getCell(i, 1).setPiece(new Pawn(MainWindow.getInstance().getModel().getFirstPlayer()));
			getCell(i, 7).setPiece(new Pawn(MainWindow.getInstance().getModel().getSecondPlayer()));
		}
		
		getCell(0, 0).setPiece(new Rook(MainWindow.getInstance().getModel().getFirstPlayer()));
		//todo finish pieces set up
	}
	
	public Cell getCell(int x, int y){
		if (isInBoard(x, y))
			return _cells[y][x];
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
