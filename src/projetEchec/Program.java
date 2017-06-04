package projetEchec;

import javax.swing.JOptionPane;

import projetEchec.UI.Board;
import projetEchec.UI.MainWindow;

public class Program {
	
	public static void main(String[] args) {
		MainWindow window = MainWindow.getInstance();		
		window.getModel().getBoard().initBoard();
		window.setContentPane(window.getModel().getBoard());
		window.pack();
		window.setMinimumSize(window.getSize());
		window.setVisible(true);
		JOptionPane.showMessageDialog(window, "Bienvenue dans Projet Echec. Pour commencer la partie, cliquez sur une pièce du camp blanc");
	}

}
