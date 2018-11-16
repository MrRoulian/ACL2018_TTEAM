package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Fantome extends Monstre {

	public Fantome(Comportement c, int x , int y, Labyrinthe lab) {
		super(c,x,y,lab);
		avoidSolidCase = true;
	}

	@Override
	protected void dessiner(Graphics2D g) {
		g.setColor(new Color(165, 219, 223));
		g.fillOval(x * PacmanPainter.WIDTH, y * PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT);
	}

}
