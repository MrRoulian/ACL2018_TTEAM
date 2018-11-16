package model;

public abstract class Special extends Case{

	/**
	 * Indique si la case a déjà ete activée
	 */
	protected boolean triggered; 
	
	public Special(int x, int y) {
		super(x, y);
	}
}
