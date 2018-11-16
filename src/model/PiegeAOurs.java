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
			g.fillRect(x * LabyrinthePainter.WIDTH, y * LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT);
		} else {
			g.setColor(Color.RED);
			g.fillRect(x * LabyrinthePainter.WIDTH, y * LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT);
			g.setColor(Color.GRAY);
			g.fillRect(	x * LabyrinthePainter.WIDTH + (int)(LabyrinthePainter.WIDTH*0.1),
						y * LabyrinthePainter.HEIGHT + (int)(LabyrinthePainter.HEIGHT*0.1),
						(int)(LabyrinthePainter.WIDTH*0.8),
						(int)(LabyrinthePainter.HEIGHT*0.8));
		}
	}

}
