package model;

import java.awt.Graphics2D;
import java.awt.Image;

public class Fantome extends Monstre {

	public Fantome(Comportement c, int x , int y, Labyrinthe lab) {
		super(c,x,y,lab);
		avoidSolidCase = true;
	}

	@Override
	public void dessiner(Graphics2D g, Entite entite) {
		if (inScreen(entite)) {
			Image sprite;
			if(!this.isdead()) {
				sprite = SpriteLoader.getFantome();
			}else {
				sprite = SpriteLoader.getFantomedead();
			}
			drawSprite(g, entite, sprite);
		}
	}

}
