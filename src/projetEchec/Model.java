package projetEchec;

public class Model {
	private IPlayer _firstPlayer;
	private IPlayer _secondPlayer;
	
	public Model() {
		_firstPlayer = new HumanPlayer();
		_secondPlayer = new HumanPlayer();
		_secondPlayer.play();
	}
	
	public IPlayer getFirstPlayer(){
		return _firstPlayer;
	}
	
	public IPlayer getSecondPlayer(){
		return _secondPlayer;
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
