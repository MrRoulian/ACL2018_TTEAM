package model;

import moteurJeu.Commande;

public interface Comportement {

	/**
	 * Duree du temporisateur d'action 
	 */
	static final int TEMPS_ENTRE_ACTION = 5;
	
	/**
	 * Methode qui permet de recuperer une action a faire pour une entite non joueur 
	 * @param labyrinthe
	 * @return
	 */
	public Commande bouger(int posX,int posY, LabyrintheGame labyrinthe);

}
