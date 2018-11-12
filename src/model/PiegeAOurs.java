package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class PiegeAOurs extends Special {
	
	public final static int DEGATSPIEGEOURS = 10;

	public PiegeAOurs(int x, int y) {
		super(x, y);
		traversable = true;
	}

	@Override
	public void trigger(Entite entite) {
		if (!triggered) {
			triggered = true;
			entite.takeDamage(DEGATSPIEGEOURS);
		}
	}

	@Override
	public void dessiner(Graphics2D g) {
		if (triggered) {
			g.setColor(Color.GRAY);
			g.fillRect(x * PacmanPainter.WIDTH, y * PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT);
		} else {
			g.setColor(Color.RED);
			g.fillRect(x * PacmanPainter.WIDTH, y * PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT);
			g.setColor(Color.GRAY);
			g.fillRect(x * PacmanPainter.WIDTH + (int)(PacmanPainter.WIDTH*0.05), y * PacmanPainter.HEIGHT + (int)(PacmanPainter.HEIGHT*0.05), (int)(PacmanPainter.WIDTH*0.9), (int)(PacmanPainter.HEIGHT*0.9));
		}
	}

}
