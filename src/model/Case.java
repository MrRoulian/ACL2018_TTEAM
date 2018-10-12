package model;

import java.awt.image.BufferedImage;

public abstract class Case {
	
	protected int x,y;
	
	protected boolean traversable;
	
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void trigger();
	
	public abstract void dessiner(BufferedImage img);
	
	public boolean isSolid() {
		return !traversable;
	}
}
