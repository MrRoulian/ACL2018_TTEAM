package model;

import java.awt.Graphics2D;
import java.awt.Image;

public class Squelette extends Monstre {

	public Squelette(Comportement c, int x, int y, LabyrintheGame lab) {
		super(c,x,y,lab);
	}
	
	@Override
	public void dessiner(Graphics2D g, Entite entite) {
		if (inScreen(entite)) {
			Image sprite;
			if(!this.isdead()) {
				sprite = SpriteLoader.getSquelette();
			}else {
				sprite = SpriteLoader.getSquelettedead();
			}
			drawSprite(g, entite, sprite);
		}
	}

	@Override
	public void attaquer() {
		// TODO Auto-generated method stub
		
	}

}
