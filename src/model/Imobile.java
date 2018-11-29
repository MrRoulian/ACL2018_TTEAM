package model;

import moteurJeu.Commande;

public class Imobile implements Comportement {

	@Override
	public Commande bouger(int posX, int posY, LabyrintheGame labyrinthe) {
		Commande c = new Commande();
		return c;
	}
}