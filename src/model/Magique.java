package model;

import java.awt.Graphics2D;
import java.awt.Image;

public class Magique extends Special {

	/**
	 * 
	 */
	private int orientation;
	public Magique(int x, int y) {
		super(x, y);
		traversable = true;
		orientation = (int)(Math.random()*4);
	}

	@Override
	public void trigger(Entite entite) {
		if (!triggered) {
			triggered=true;
			boolean bump =false;
			LabyrintheGame lab =entite.labyrinthe;
			while(!bump) {
				switch (orientation){
				case 0:
					if(lab.map.getCase(x, y-1).traversable) {
						bump=true;
						entite.haut();
					}
					break;
				case 1:
					if(lab.map.getCase(x, y+1).traversable) {
						bump=true;
						entite.bas();
					}
					break;
				case 2:
					if(lab.map.getCase(x-1, y).traversable) {
						bump=true;
						entite.gauche();
					}
					break;
				case 3:
					if(lab.map.getCase(x+1, y).traversable) {
						bump=true;
						entite.droite();
					}
					break;
				}
				orientation = (int)(Math.random()*4);
			}
			this.traversable=false;
		}
		
	}

	@Override
	public void dessiner(Graphics2D g, Entite entite) {
		// On test si la case est dans l'ecran 
		if (this.inScreen(entite)) {
			// On recupere le sprite du sol 
			Image sprite = SpriteLoader.getSol(idSprite);
			// On le dessine 
			this.drawSprite(g, entite, sprite);

			// On verifie que le piege magique est déjà déclanché
			if (triggered) {
				// On recupere le sprite du passage 
				sprite = SpriteLoader.getBump();
				// On le dessine
				this.drawSprite(g, entite, sprite);
			}
		}
	}

}
