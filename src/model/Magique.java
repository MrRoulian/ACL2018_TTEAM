package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Magique extends Special {

	/**
	 * 
	 */
	private int orientation;
	public Magique(int x, int y) {
		super(x, y);
		traversable = true;
		orientation = (int)(Math.random()*4);
	}

	@Override
	public void trigger(Entite entite) {
		switch (orientation){
		case 0:
			entite.haut();
			entite.haut();
			break;
		case 1:
			entite.bas();
			entite.bas();
			break;
		case 2:
			entite.gauche();
			entite.gauche();
			break;
		case 3:
			entite.droite();
			entite.droite();
			break;
		}
	}

	@Override
	public void dessiner(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.fillRect(x * LabyrinthePainter.WIDTH, y * LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT);
	}

}
