package model;

import java.awt.Graphics2D;

import java.util.Random;


public class Sol extends Case {

	protected int idSprite;
	
	public Sol(int x, int y,int sprite) {
		super(x, y);
		this.traversable = true;
		idSprite=sprite;
	}

	@Override
	public void trigger(Entite entite) {
		// Ne fait rien
	}

	@Override
	public void dessiner(Graphics2D g) {
		if(idSprite!=-1) {
		g.drawImage(SpriteLoader.getSol(idSprite),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
	
		}
	}
}
