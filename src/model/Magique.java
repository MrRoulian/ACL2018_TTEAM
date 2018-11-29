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
		triggered=true;
		traversable = false;
		if (!triggered) {
			switch (orientation){
			case 0:
				entite.haut();
				entite.haut();
				break;
			case 1:
				entite.bas();
				entite.bas();
				break;
			case 2:
				entite.gauche();
				entite.gauche();
				break;
			case 3:
				entite.droite();
				entite.droite();
				break;
			}
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
