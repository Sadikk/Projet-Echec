package projetEchec.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import projetEchec.pieces.Piece;

public class Cell extends JLabel implements MouseListener {
	final static Border _hightlightBorder = BorderFactory.createLineBorder(Color.BLUE, 5);
	final static Border _emptyBorder = new EmptyBorder(5, 5, 5, 5);
	
	private int _x;
	private int _y;
	private boolean _highlighted = false;
	private Piece _piece;
	private Board _board;
	
	
	public Cell(int x, int y, Board board) {
		super("x = " + x + " y = " + y);
		_x = x;
		_y = y;
		_board = board;
		if ((x+y) % 2 == 0)
			setBackground(Color.white);
		else
			setBackground(Color.black);
		setPreferredSize(new Dimension(68,68));
        addMouseListener(this);
        setOpaque(true);
	}
	
	
	public int getCellX(){
		return _x;
	}
	
	public int getCellY(){
		return _y;
	}
	
	public Piece getPiece(){
		return _piece;
	}
	
	public boolean getHighlighted(){
		return _highlighted;
	}
	
	public void setPiece(Piece piece){
		if (_piece != null)
		{
			_piece.setCell(null);
		}
		_piece = piece;
		if (_piece != null)
		{
			_piece.setCell(this);
			String path = _piece.getIconPath();
			setText(_piece.getClass().getSimpleName());
			if (path != null){
				setOpaque(false);
				setIcon(new ImageIcon());
			}
		}	
		else if (_piece != piece)
		{
			setOpaque(false);
			setIcon(null);
			revalidate();
		}
	}
	
	public void highlight() {
		_highlighted = !_highlighted;
		if (_highlighted)
			setBorder(_hightlightBorder);
		else
			setBorder(_emptyBorder);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked on " + this.toString());
		highlight();
		if (_piece != null)
		{
			for (Cell cell: _piece.getPossibleDestinations(_board)) {
				 cell.highlight();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public String toString(){
		return "Cell " + _x + "/" + _y;
	}
}
