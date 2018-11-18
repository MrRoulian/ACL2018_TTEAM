package model;

import java.awt.Graphics2D;

public class Fantome extends Monstre {

	public Fantome(Comportement c, int x , int y, Labyrinthe lab) {
		super(c,x,y,lab);
		avoidSolidCase = true;
	}

	@Override
	protected void dessiner(Graphics2D g) {
		//g.drawImage(SpriteLoader.getSol(),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
		if(!this.isdead()) {
			g.drawImage(SpriteLoader.getFantome(),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
		}else {
			g.drawImage(SpriteLoader.getFantomedead(),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
			
		}	
	}

}
