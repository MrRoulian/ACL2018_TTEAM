package model;

import java.awt.Graphics2D;

import moteurJeu.Commande;

public abstract class Entite {

	protected int x, y;
	
	protected Labyrinthe labyrinthe;
	
	//protectd Sprite sprite;
	
	protected abstract void update(Commande commande);
	
	protected abstract void dessiner(Graphics2D g);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
