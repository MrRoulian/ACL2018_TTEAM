package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.DessinJeu;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class LabyrinthePainter implements DessinJeu {

	/**
	 * la taille des cases
	 */
	protected static final int WIDTH = 35;
	protected static final int HEIGHT = 35;

	/**
	 * Le jeu a dessiner sur l'image
	 */
	private LabyrintheGame jeu;

	/**
	 * Constructeur recuperant le jeu a dessiner 
	 * @param j
	 */
	public LabyrinthePainter(LabyrintheGame j) {
		this.jeu = j;
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g2d = (Graphics2D) image.getGraphics();
		g2d.setColor(new Color(83, 73, 63));
		g2d.fillRect(0, 0, WIDTH*100, HEIGHT*100);
		jeu.dessiner(g2d);
	}

}
