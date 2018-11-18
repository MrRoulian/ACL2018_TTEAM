package model;

import java.awt.Graphics2D;

public class Squelette extends Monstre {

	public Squelette(Comportement c, int x, int y, Labyrinthe lab) {
		super(c,x,y,lab);
	}
	
	@Override
	protected void dessiner(Graphics2D g) {
		if(!this.isdead()) {
			g.drawImage(SpriteLoader.getSquelette(),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
		}else {
			g.drawImage(SpriteLoader.getSquelettedead(),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
			
		}
	}

}
