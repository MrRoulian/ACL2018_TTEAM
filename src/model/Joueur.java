package model;

import java.awt.Color;
import java.awt.Graphics2D;

import moteurJeu.Commande;

public class Joueur extends Entite{
	
	public Joueur() {
		this.x = 1;
		this.y = 1;
	}

	@Override
	protected void dessiner(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(x * PacmanPainter.WIDTH, y * PacmanPainter.HEIGHT, PacmanPainter.WIDTH, PacmanPainter.HEIGHT);
	}
	

	@Override
	protected void update(Commande commande) {
		// TODO Gerer le deplacement en fonction de la commande
		
		if(commande.droite) {
			this.x++;
		}
		if(commande.gauche) {
			this.x--;
		}
		if(commande.haut) {
			this.y--;
		}
		if(commande.bas) {
			this.y++;
		}
		
		
	}

	
}
