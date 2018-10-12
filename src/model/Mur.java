package model;

public class Mur extends Case {

	public Mur(int x, int y) {
		super(x, y);
		this.traversable = false;
	}

	@Override
	public void trigger() {
		// Ne fait rien
	}

}
