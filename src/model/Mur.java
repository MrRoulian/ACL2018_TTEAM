package model;

import java.awt.Graphics2D;

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
	public void dessiner(Graphics2D g) {
		g.drawImage(SpriteLoader.getWall(idSpriteBack),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);	
	}

}
