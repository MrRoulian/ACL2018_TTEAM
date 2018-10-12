package controller;

import java.awt.event.KeyEvent;

import engine.Cmd;
import engine.GameController;
import model.Joueur;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * controleur de type KeyListener
 * 
 */
public class PacmanController implements GameController {
	
	private Joueur j;
	
	/**
	 * commande en cours
	 */
	//private Cmd commandeEnCours;
	
	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public PacmanController(Joueur joueur) {
		//this.commandeEnCours = Cmd.IDLE;
		
		j = joueur;
	}
	
	
	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public PacmanController() {
		j.setCommandeEnCours(Cmd.IDLE);
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Cmd getCommand() {
		return j.getCommandeEnCours();
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyChar()) {
		// si on appuie sur 'q',commande joueur est gauche
		case 'q':
		case 'Q':
			j.setCommandeEnCours(Cmd.LEFT);
			break;
		// si on appuie sur 'd',commande joueur est droite
		case 'd':
		case 'D':
			j.setCommandeEnCours(Cmd.RIGHT);
			break;
		// si on appuie sur 'z',commande joueur est haut
		case 'z':
		case 'Z':
			j.setCommandeEnCours(Cmd.UP);
			break;
		// si on appuie sur 's',commande joueur est bas
		case 's':
		case 'S':
			j.setCommandeEnCours(Cmd.DOWN);
			break;
		}

	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		j.setCommandeEnCours(Cmd.IDLE);
	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}

}
