package projetEchec;

public class HumanPlayer implements IPlayer {

	boolean playing;
	
	@Override
	public void play() {
		playing = true;
	}

	@Override
	public boolean isPlaying() {
		return playing;
	}
	
	public void endTurn(){
		playing = false;
	}

}
