package projetEchec;

import projetEchec.UI.Board;
import projetEchec.pieces.Pawn;
import projetEchec.pieces.Piece;

public class Model {
	private IPlayer _firstPlayer;
	private IPlayer _secondPlayer;
	private Board _board;
	
	public Model() {
		_firstPlayer = new HumanPlayer();
		_secondPlayer = new HumanPlayer();
		_firstPlayer.play();
		_board = new Board();
	}
	
	public IPlayer getFirstPlayer(){
		return _firstPlayer;
	}
	
	public IPlayer getSecondPlayer(){
		return _secondPlayer;
	}
	
	public Board getBoard(){
		return _board;
	}
	
	/**
	 * Recupere le joueur en train de joueur
	 * @return le joueur dont c'est le tour actuellement
	 */
	public IPlayer getCurrentPlayer(){
		if (_firstPlayer.isPlaying())
			return _firstPlayer;
		else
			return _secondPlayer;
	}
	
	/**
	 * Effectue le changement de tour entre le joueur 1 et le joueur 2
	 */
	public void switchTurn(){
		for (Piece p : _board.getPieces(Pawn.class, null))
			((Pawn)p).setPriseEnPassant(false);
		
		if (_firstPlayer.isPlaying()){
			System.out.println("Player one ended playing, switching to player two");
			_firstPlayer.endTurn();
			_secondPlayer.play();
		}
		else{
			System.out.println("Player two ended playing, switching to player one");
			_secondPlayer.endTurn();
			_firstPlayer.play();
		}
	}
}
