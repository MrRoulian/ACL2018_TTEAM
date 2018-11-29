package moteurJeu;

import java.awt.Graphics2D;

/**
 * Represente un jeu un jeu est caracterise par la methode evoluer
 *
 */
public interface Game {

	/**
	 * Methode qui contient l'evolution du jeu en fonction de la commande
	 * 
	 * @param commandeUser
	 *            commande utilisateur
	 */
	public void evoluer(Commande commandeUser);

	/**
	 * @return true si et seulement si le jeu est fini
	 */
	public boolean etreFini();
	
	/**
	 * Methode qui permet au jeu de se dessiner sur l'image fornie
	 * 
	 * @param g
	 *            image sur laquelle dessiner
	 */
	public void dessiner(Graphics2D g);
	
	public void testfin();
}
