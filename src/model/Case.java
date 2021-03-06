package model;

public abstract class Case extends Dessinable{

	/**
	 * Boolean indicant si la case peut etre traversee normalement 
	 */
	protected boolean traversable;

	/*
	 * entier definissant le sprite encour
	 */
	protected int idSpriteBack;
	/*
	 * entier definissant le sprite encour
	 */
	protected int idSprite;

	/**
	 * Constructeur initialisant la position de la case
	 * @param x Abscisse de la case 
	 * @param y Ordonee de la case 
	 */
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Methode qui declanche l'evenement de la case 
	 * @param entite Entite qui declanche la case 
	 */
	public abstract void trigger(Entite entite);

	/**
	 * Methode qui indique si une case est normalement traversable
	 * @return
	 */
	public boolean isSolid() {
		return !traversable;
	}

	public void setSprite(int s) {
		idSprite=s;
	}

	public void idSpriteBack(int s) {
		idSpriteBack=s;
	}
}