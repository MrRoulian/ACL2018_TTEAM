package model;

public abstract class Special extends Case{

	/**
	 * Indique si la case a d�j� ete activ�e
	 */
	protected boolean triggered; 
	
	public Special(int x, int y) {
		super(x, y);
	}
}
