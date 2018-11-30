package model;

import java.awt.Graphics2D;
import java.awt.Image;

public class Potion extends Special {

	/**
	 * 
	 */
	public Potion(int x, int y) {
		super(x, y);
		traversable = true;
		
	}

	@Override
	public void trigger(Entite entite) {
		if (!triggered) {
			entite.vie+=50;
			if(entite.vie>100) {
				entite.vie=100;
			}
			triggered=true;
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
			if (!triggered) {
				// On recupere le sprite du passage 
				sprite = SpriteLoader.getPotion();
				// On le dessine
				this.drawSprite(g, entite, sprite);
			}
		}
	}

}
