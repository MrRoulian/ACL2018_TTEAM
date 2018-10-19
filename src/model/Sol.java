package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Sol extends Case {

	public Sol(int x, int y) {
		super(x, y);
		this.traversable = true;
	}

	@Override
	public void trigger() {
		// Ne fait rien
	}

	@Override
	public void dessiner(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(x * PacmanPainter.WIDTH, y* PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT);
	}

}
