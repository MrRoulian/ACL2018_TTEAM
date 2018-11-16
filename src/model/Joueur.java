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
		this.triggerCase = true;
		this.vie=100;
		this.avoidSolidCase=true;
	}

	@Override
	protected void dessiner(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillOval(x * PacmanPainter.WIDTH, y * PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT);
	}


	@Override
	protected void update(Commande commande) {
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
	
	public void setPosition(int x1,int y1) {
		this.x=x1;
		this.y=y1;
	}
	
	public int getVie() {
		return vie;
	}
}
