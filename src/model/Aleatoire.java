package model;

import moteurJeu.Commande;

public class Aleatoire implements Comportement {

	@Override
	public Commande bouger() {
		Commande c = new Commande();
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
