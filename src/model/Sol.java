package model;

import java.awt.image.BufferedImage;

public class Sol extends Case {

	public Sol(int x, int y) {
		super(x, y);
		this.traversable = true;
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
