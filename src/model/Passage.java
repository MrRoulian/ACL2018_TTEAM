package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Passage extends Special {

	public Passage(int x, int y) {
		super(x, y);
		traversable = true;
	}

	@Override
	public void trigger(Entite entite) {
		if (!triggered) {
			triggered = true;
			int randX,randY;
			boolean end = false;
			do {
				randX = (int)(Math.random()*entite.labyrinthe.getWidth()-1)+1;
				randY = (int)(Math.random()*entite.labyrinthe.getHeight()-1)+1;
				if (entite.labyrinthe.getCase(randX, randY).traversable){
					entite.x = randX;
					entite.y = randY;
					entite.gauche();entite.droite(); //sert a trigger la case si je suis sur un piège
					end = true;
				}
			} while (!end);
		}
	}

	@Override
	public void dessiner(Graphics2D g) {
		g.drawImage(SpriteLoader.getSol(),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
		if(!triggered) {
			g.drawImage(SpriteLoader.getTeleport2(),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
		}else {	
			g.drawImage(SpriteLoader.getTeleport(),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);

		}
	}

}
