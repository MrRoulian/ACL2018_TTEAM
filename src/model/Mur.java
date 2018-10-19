package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Mur extends Case {

	public Mur(int x, int y) {
		super(x, y);
		this.traversable = false;
	}

	@Override
	public void trigger() {
		// Ne fait rien
	}

	@Override
	public void dessiner(Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x* PacmanPainter.WIDTH, y* PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT);
	}

}
