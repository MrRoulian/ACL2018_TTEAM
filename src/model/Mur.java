package model;

import java.awt.image.BufferedImage;

public class Mur extends Case {

	public Mur(int x, int y) {
		super(x, y);
		this.traversable = false;
	}

	@Override
	public void trigger() {
		// Ne fait rien
	}

	@Override
	public void dessiner(BufferedImage img) {
		// TODO Auto-generated method stub
		
	}

}
