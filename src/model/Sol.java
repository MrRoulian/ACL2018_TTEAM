package model;

import java.awt.Graphics2D;

import java.util.Random;


public class Sol extends Case {

	
	public Sol(int x, int y) {
		super(x, y);
		this.traversable = true;
		idSprite=0;
		int rand = (int) (Math.random() * 100);
		if (rand < 15) {
			idSprite = 4;
		} else if (rand < 16) {
			idSprite = 3;
		} else if (rand < 18) {
			idSprite = 2;
		} else if (rand < 20) {
			idSprite = 1;
		} 
	}

	@Override
	public void trigger(Entite entite) {
		// Ne fait rien
	}

	@Override
	public void dessiner(Graphics2D g) {
		g.drawImage(SpriteLoader.getSol(idSprite),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);

	}
}
