package model;

public class Sol extends Case {

	public Sol(int x, int y) {
		super(x, y);
		this.traversable = true;
	}

	@Override
	public void trigger() {
		// Ne fait rien
	}

}
