package projetEchec.UI;

import javax.swing.*;

import projetEchec.Model;

public class MainWindow extends JFrame {
	private MainWindow()
	{
		super();
		_model = new Model();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Projet Echec");
	}
	
	private Model _model;
	public Model getModel(){
		return _model;
	}
	
	
	private static MainWindow INSTANCE = new MainWindow();
 
	public static MainWindow getInstance()
	{	
		return INSTANCE;
	}
}
