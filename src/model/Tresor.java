package model;

import java.awt.Graphics2D;
import java.awt.Image;

import moteurJeu.PanelDessin;

public class Tresor extends Special {

	public Tresor(int x, int y) {
		super(x, y);
		traversable = true;
		idSprite=0;
	}

	@Override
	public void trigger(Entite entite) {
		if (!triggered) {
			triggered = true;
			Labyrinthe.nbTreasureLeft--;
		}
	}

	@Override
	public void dessiner(Graphics2D g, Entite entite) {
		// On test si la case est dans l'ecran 
		if (this.inScreen(entite)) {
			// On recupere le sprite du sol 
			Image sprite = SpriteLoader.getSol(idSpriteBack);
			// On le dessine 
			this.drawSprite(g, entite, sprite);
			
			// On verifie que la piece n'est pas déjà récuperée 
			if (!triggered) {
				// On recupere le sprite de la piece 
				sprite = SpriteLoader.getPieces(idSprite);
				// On le dessine
				this.drawSprite(g, entite, sprite);  
				if(idSprite==5) {
					idSprite=0;
				}else {
					idSprite++;
				}
			} 
		}
	}

}
