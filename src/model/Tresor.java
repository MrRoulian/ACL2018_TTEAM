package model;

import java.awt.Color;
import java.awt.Graphics2D;

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
	public void dessiner(Graphics2D g) {
		g.drawImage(SpriteLoader.getSol(),x* PacmanPainter.WIDTH, y* PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT,null);
		if (!triggered) {
			g.drawImage(SpriteLoader.getPieces(idSprite),x* PacmanPainter.WIDTH, y* PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT,null);
			if(idSprite==5) {
				idSprite=0;
			}else {
				idSprite++;
			}
		} 
	}

}
