package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sol extends Case {

	public Sol(int x, int y) {
		super(x, y);
		this.traversable = true;
	}

	@Override
	public void trigger(Entite entite) {
		// Ne fait rien
	}

	@Override
	public void dessiner(Graphics2D g) {
		g.drawImage(SpriteLoader.getSol(),x* LabyrinthePainter.WIDTH, y* LabyrinthePainter.HEIGHT, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);
	}

}
