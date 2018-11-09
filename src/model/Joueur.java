package model;

import java.awt.Color;
import java.awt.Graphics2D;

import moteurJeu.Commande;

public class Joueur extends Entite{

	public static int test=0;
	public Joueur(Labyrinthe lab) {
		this.x = 5;
		this.y = 5;
		this.labyrinthe=lab;
	}

	@Override
	protected void dessiner(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(x * PacmanPainter.WIDTH, y * PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT);
	}


	@Override
	protected void update(Commande commande) {
		if(commande.droite) {
			if(labyrinthe.getCase(++x, y).isSolid()) {
				this.x--;
			}
		}
		if(commande.gauche) {
			if(labyrinthe.getCase(--x, y).isSolid()) {
				this.x++;
			}
		}
		if(commande.haut) {
			if(labyrinthe.getCase(x, --y).isSolid()) {
				this.y++;
			}
		}
		if(commande.bas) {
			if(labyrinthe.getCase(x, ++y).isSolid()) {
				this.y--;
			}
		}
		labyrinthe.getCase(x, y).trigger(this);
	}
}
