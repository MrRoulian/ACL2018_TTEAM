package model;

import java.awt.Graphics2D;
import java.awt.Image;

import moteurJeu.PanelDessin;

public abstract class Dessinable {
	/**
	 * Entiers representant la position de l'objet dessinable
	 */
	protected int x,y;
	
	/**
	 * Methode qui permet de dessiner l'objet sur l'image a construire
	 * @param g Graphics sur lequel on dessine l'image
	 * @param entite Entite par rapport a laquel on dessine le jeu 
	 */
	public abstract void dessiner(Graphics2D g, Entite entite);

	/**
	 * Methode qui indique si la case est en dehors de l'ecran par rapport a l'entite donnee
	 * @param entite Entite au centre de l'image
	 * @return True si la case est dans l'ecran False sinon 
	 */
	protected boolean inScreen(Entite entite) {
		// Calcul millieu de l'ecran 
		int xDessin = PanelDessin.getWindowsWidth() / 2;
		int yDessin = PanelDessin.getWindowsHeight() / 2;
		// Verification d'etre danbs l'ecran (en largeur)
		if (!( (int)(x * LabyrinthePainter.WIDTH - entite.getX() * LabyrinthePainter.WIDTH + xDessin) < - LabyrinthePainter.OFF_SCREEN 
				|| (int)(x * LabyrinthePainter.WIDTH - entite.getX() * LabyrinthePainter.WIDTH + xDessin) > xDessin*2 + LabyrinthePainter.OFF_SCREEN)) {
			// Verification d'etre danbs l'ecran (en hauteur)
			if (!( (int)(y * LabyrinthePainter.HEIGHT - entite.getY() * LabyrinthePainter.HEIGHT + yDessin) < - LabyrinthePainter.OFF_SCREEN 
					|| (int)(y * LabyrinthePainter.HEIGHT - entite.getY() * LabyrinthePainter.HEIGHT + yDessin) > yDessin*2 + LabyrinthePainter.OFF_SCREEN)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Dessine le sprite donné a la position de la case relative a la position de l'entite donnée 
	 * @param g Image sur laquel on dessine
	 * @param entite Entité sur laquel on centre la vue
	 * @param sprite Sprite a dessiner
	 */
	protected void drawSprite(Graphics2D g, Entite entite, Image sprite) {
		// Calcul millieu de l'ecran 
		int xDessin = PanelDessin.getWindowsWidth() / 2;
		int yDessin = PanelDessin.getWindowsHeight() / 2;
		// Dessine l'image
		g.drawImage(sprite,
				(int)(x * LabyrinthePainter.WIDTH - entite.getX() * LabyrinthePainter.WIDTH + xDessin), 
				(int)(y * LabyrinthePainter.HEIGHT - entite.getY() * LabyrinthePainter.HEIGHT + yDessin), 
				LabyrinthePainter.WIDTH, 
				LabyrinthePainter.HEIGHT,
				null);  
	}
}
