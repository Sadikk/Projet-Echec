package projetEchec;

public class Model {
	private IPlayer _firstPlayer;
	private IPlayer _secondPlayer;
	
	public Model() {
		_firstPlayer = new HumanPlayer();
		_secondPlayer = new HumanPlayer();
	}
	
	public IPlayer getFirstPlayer(){
		return _firstPlayer;
	}
	
	public IPlayer getSecondPlayer(){
		return _secondPlayer;
	}
}
