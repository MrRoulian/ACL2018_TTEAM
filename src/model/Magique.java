package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Magique extends Special {

	public Magique(int x, int y) {
		super(x, y);
		traversable = true;
	}

	@Override
	public void trigger(Entite entite) {
		switch ((int)(Math.random()*4)){
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
		if (triggered) {
			g.setColor(Color.WHITE);
			g.fillRect(x * PacmanPainter.WIDTH, y * PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x * PacmanPainter.WIDTH, y * PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT);
		}
	}

}
