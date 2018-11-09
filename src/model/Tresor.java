package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Tresor extends Special {

	public Tresor(int x, int y) {
		super(x, y);
	}

	@Override
	public void trigger(Entite entite) {
		triggered = true;
	}

	@Override
	public void dessiner(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x * PacmanPainter.WIDTH, y* PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT);
	}

}
