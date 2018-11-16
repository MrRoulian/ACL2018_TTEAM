package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Squelette extends Monstre {

	public Squelette(Comportement c, int x, int y, Labyrinthe lab) {
		super(c,x,y,lab);
	}
	
	@Override
	protected void dessiner(Graphics2D g) {
		g.setColor(new Color(243, 219, 160));
		g.fillOval(x * LabyrinthePainter.WIDTH, y * LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT);		
	}

}
