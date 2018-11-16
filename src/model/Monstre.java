package model;

import java.awt.Graphics2D;

import moteurJeu.Commande;

public abstract class Monstre extends Entite {
	
	protected Comportement comportement;

	public Monstre(Comportement c, int x , int y, Labyrinthe lab) {
		this.comportement = c;
		this.x=x;
		this.y=y;
		this.labyrinthe=lab;
		this.triggerCase = false;
		this.vie=100;
	}
	
	@Override
	protected void update(Commande com) {
		Commande commande = comportement.bouger();
		if(commande.droite) {
			droite();
		}
		if(commande.gauche) {
			gauche();
		}
		if(commande.haut) {
			haut();
		}
		if(commande.bas) {
			bas();
		}
	}

	@Override
	protected abstract void dessiner(Graphics2D g);

}
