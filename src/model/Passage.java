package model;

import java.awt.Graphics2D;
import java.awt.Image;

public class Passage extends Special {

	public Passage(int x, int y) {
		super(x, y);
		traversable = true;
	}

	@Override
	public void trigger(Entite entite) {
		if (!triggered) {
			triggered = true;
			int randX,randY;
			boolean end = false;
			do {
				randX = (int)(Math.random()*entite.labyrinthe.getMap().getWidth()-1)+1;
				randY = (int)(Math.random()*entite.labyrinthe.getMap().getHeight()-1)+1;
				if (entite.labyrinthe.getMap().getCase(randX, randY).traversable){
					entite.x = randX;
					entite.y = randY;
					entite.gauche();entite.droite(); //sert a trigger la case si je suis sur un piège
					end = true;
				}
			} while (!end);
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

			// On verifie que le passage n'est pas déjà déclanché
			if (!triggered) {
				// On recupere le sprite du passage 
				sprite = SpriteLoader.getTeleport2();
				// On le dessine
				this.drawSprite(g, entite, sprite);
			} else {
				// On recupere le sprite du passage 
				sprite = SpriteLoader.getTeleport();
				// On le dessine
				this.drawSprite(g, entite, sprite);
			}
		}
	}

}
