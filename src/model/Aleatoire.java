package model;

import moteurJeu.Commande;

public class Aleatoire implements Comportement {
	
	private int slow = 0;

	@Override
	public Commande bouger(int posX, int posY, LabyrintheGame labyrinthe) {
		Commande c = new Commande();
		slow++;
		if (slow%TEMPS_ENTRE_ACTION!=0){
			return c;
		}
		slow%=TEMPS_ENTRE_ACTION;
		switch((int)(Math.random()*4)){
			case 0:
				c.haut = true;
				break;
			case 1:
				c.droite = true;
				break;
			case 2:
				c.gauche = true;
				break;
			case 3:
				c.bas = true;
				break;
		}
		return c;
	}

}
