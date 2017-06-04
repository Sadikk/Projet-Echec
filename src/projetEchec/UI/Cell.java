package projetEchec.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import projetEchec.pieces.King;
import projetEchec.pieces.Pawn;
import projetEchec.pieces.Piece;
import projetEchec.pieces.Rook;

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
			setBackground(new Color(240,217,181));
		else
			setBackground(new Color(181,136,99));
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
		if (_piece != piece)
		{
			setOpaque(true);
			setIcon(null);
			revalidate();
			_board.clearHighlights();
		}
		_piece = piece;
		if (_piece != null)
		{
			_piece.setCell(this);
			String path = _piece.getIconPath();
			
			setText(_piece.getClass().getSimpleName());
			if (path != null){
				URL imageUrl = this.getClass().getResource(path);
				setText(null);
				setIcon(new ImageIcon(imageUrl, "test"));
				revalidate();
			}
		}	
		
	}
	
	public void highlight() {
		_highlighted = !_highlighted;
		if (_highlighted)
			setBorder(_hightlightBorder);
		else
			setBorder(_emptyBorder);
		revalidate();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked on " + this.toString());
		
		Piece movingPiece = _board.getHighlightedPiece(MainWindow.getInstance().getModel().getCurrentPlayer());
		
		//todo castling management is quite chaotic, we could improve it
		if (_piece != null && _piece instanceof Rook && _highlighted && movingPiece != null
				&& _piece.getOwner() == MainWindow.getInstance().getModel().getCurrentPlayer()
				&& movingPiece != null && movingPiece instanceof King
				&& movingPiece.getOwner() == MainWindow.getInstance().getModel().getCurrentPlayer())
		{
			int rookOffset = _x == 0 ? 3 : -2; //large castling/small castling
			int kingOffset = _x == 0 ? -2 : 2;
			movingPiece.moveTo(_board.getCell(movingPiece.getCell().getCellX() + kingOffset, movingPiece.getCell().getCellY()));
			_piece.moveTo(_board.getCell(_piece.getCell().getCellX() + rookOffset, _piece.getCell().getCellY()));
			MainWindow.getInstance().getModel().switchTurn();
		}
		else if (_piece != null && _piece.getOwner().isPlaying())
		{
			_board.clearHighlights();
			for (Cell cell: _piece.getPossibleDestinations(_board)) {
				 cell.highlight();
			}
			highlight();
		}
		
				
		if (_highlighted && (_piece == null || _piece.getOwner() != MainWindow.getInstance().getModel().getCurrentPlayer()))
		{
			
			if (movingPiece != null)
				movingPiece.moveTo(this);
			if (movingPiece instanceof Pawn && ((Pawn)movingPiece).getPriseEnPassant()){
				try {
					_board.getCellInDirection(movingPiece.getCell(), 
							movingPiece.getOwner() == MainWindow.getInstance().getModel().getFirstPlayer() ? DirectionsEnum.DIRECTION_NORTH : DirectionsEnum.DIRECTION_SOUTH
									, 1).setPiece(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		if (_piece == null && !_highlighted)
			_board.clearHighlights();		
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
