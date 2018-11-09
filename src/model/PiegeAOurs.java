package model;

import java.awt.Graphics2D;

public class PiegeAOurs extends Special {
	
	public final static int DEGATSPIEGEOURS = 5;

	public PiegeAOurs(int x, int y) {
		super(x, y);
	}

	@Override
	public void trigger(Entite entite) {
		
		triggered = true;
	}

	@Override
	public void dessiner(Graphics2D g) {
		
	}

}
