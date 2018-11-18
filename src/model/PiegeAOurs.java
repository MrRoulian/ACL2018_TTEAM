package model;

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
		g.drawImage(SpriteLoader.getSol(0),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
			
		if (!triggered) {
			g.drawImage(SpriteLoader.getPiegeOurs(),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
		
		}
	}

}
