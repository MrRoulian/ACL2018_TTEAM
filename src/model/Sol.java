package model;

import java.awt.Graphics2D;

import java.util.Random;


public class Sol extends Case {

	protected int idSprite;
	
	public Sol(int x, int y) {
		super(x, y);
		this.traversable = true;
		Random r=new Random();
		int res=  0 + r.nextInt(100 - 0);
		if(res<2) {
			idSprite=4;
		}else {
			if(res<3) {
				idSprite=3;
			}else {
				if(res<8) {
					idSprite=2;
				}else {
					if(res<10) {
						idSprite=1;
					}else {
						idSprite=0;
					}
				}
			}
		}
	}

	@Override
	public void trigger(Entite entite) {
		// Ne fait rien
	}

	@Override
	public void dessiner(Graphics2D g) {
		g.drawImage(SpriteLoader.getSol(idSprite),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
	}

}
