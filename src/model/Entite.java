package model;

import java.awt.Graphics2D;

import moteurJeu.Commande;

public abstract class Entite {

	protected int x, y;
	
	//protectd Sprite sprite;
	
	protected abstract void update(Commande commande);
	
	protected abstract void dessiner(Graphics2D g);

}
