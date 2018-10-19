package start;

import model.PacmanPainter;
import moteurJeu.MoteurGraphique;

import java.awt.Dimension;

import model.PacmanGame;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {

		
		
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width = (int)dimension.getWidth();
		
		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("helpFilePacman.txt");
		PacmanPainter painter = new PacmanPainter(game);

		// classe qui lance le moteur de jeu generique
		MoteurGraphique moteur = new MoteurGraphique(game, painter);
		moteur.lancerJeu(width,height);
	}

}
