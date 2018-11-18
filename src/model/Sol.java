package model;

import java.awt.Graphics2D;

import java.util.Random;


public class Sol extends Case {

	
	public Sol(int x, int y) {
		super(x, y);
		this.traversable = true;
	}

	@Override
	public void trigger(Entite entite) {
		// Ne fait rien
	}

	@Override
	public void dessiner(Graphics2D g) {
		g.drawImage(SpriteLoader.getSol(idSpriteBack),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
		
	}
}
