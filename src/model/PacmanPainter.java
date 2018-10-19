package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.DessinJeu;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class PacmanPainter implements DessinJeu {

	/**
	 * la taille des cases
	 */
	protected static final int WIDTH = 35;
	protected static final int HEIGHT = 35;

	/**
	 * Le jeu a dessiner sur l'image
	 */
	private PacmanGame jeu;

	/**
	 * Constructeur recuperant le jeu a dessiner 
	 * @param j
	 */
	public PacmanPainter(PacmanGame j) {
		this.jeu = j;
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g2d = (Graphics2D) image.getGraphics();
		jeu.dessiner(g2d);
	}

}
