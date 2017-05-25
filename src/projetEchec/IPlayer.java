package projetEchec;

/**
 * @author Wind
 *
 */
public interface IPlayer {
	/**
	 * Debute le tour du joueur
	 */
	void play();
	/**
	 * Termine le tour du joueur
	 */
	void endTurn();
	/**
	 * Verifie si c'est au tour du joueur ou non
	 * @return true si c'est le tour du joueur, false sinon
	 */
	boolean isPlaying();
}
