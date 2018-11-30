package model;

import java.awt.Graphics2D;
import java.awt.Image;

import moteurJeu.PanelDessin;

public class Beer extends Special {


	public Beer(int x, int y) {
		super(x, y);
		traversable = true;
	}

	@Override
	public void trigger(Entite entite) {
		if (!triggered) {
			triggered = true;
			entite.boire();
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

			// On verifie que le piege n'est pas déjà déclanché
			if (!triggered) {
				// On recupere le sprite du piege 
				sprite = SpriteLoader.getBeer();
				// On le dessine
				this.drawSprite(g, entite, sprite);
			}
		}		
	}

}
