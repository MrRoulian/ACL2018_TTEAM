package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mur extends Case {

	public Mur(int x, int y) {
		super(x, y);
		this.traversable = false;
	}

	@Override
	public void trigger(Entite entite) {
		// Ne fait rien
	}

	@Override
	public void dessiner(Graphics2D g) {
		g.drawImage(SpriteLoader.getWall(),x* PacmanPainter.WIDTH, y* PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT,null);
	}

}
