package model;

import java.awt.Graphics2D;
import java.awt.Image;

import moteurJeu.PanelDessin;

public class Mur extends Case {



	public Mur(int x, int y) {
		super(x, y);
		this.traversable = false;
	}

	@Override
	public void trigger(Entite entite) {
		// Ne fait rien
	}

	@Override
	public void dessiner(Graphics2D g, Entite entite) {
		// On test si la case est dans l'ecran 
		if (this.inScreen(entite)) {
			// On recupere le sprite du mur 
			Image sprite = SpriteLoader.getWall(idSpriteBack);
			// On le dessine 
			this.drawSprite(g, entite, sprite);
		}

	}

}
