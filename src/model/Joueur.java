package model;

import java.awt.Color;
import java.awt.Graphics2D;

import moteurJeu.Commande;

public class Joueur extends Entite{
	
	public static int test=0;
	public Joueur(Labyrinthe lab) {
		this.x = 1;
		this.y = 1;
		this.labyrinthe=lab;
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
            if(x+1< labyrinthe.getWidth()-1) {//-1 car le tableau commence a 0
                if(labyrinthe.getCase(x++, y).isSolid()) {//on incremente lors du test
                    this.x--;//donc si c'est un mur on decremente
                }
            }else {
                x= labyrinthe.getWidth()-2;//-2 car -1 represente le mur d'enceinte
            }
        }
		if(commande.gauche) {
			if(x-1>0) {
				if(labyrinthe.getCase(x--, y).isSolid()) {
					this.x++;
				}
			}else {
				x=1;
			}
		}
		if(commande.haut) {
			if(y-1>0) {
				if(labyrinthe.getCase(x, y--).isSolid()) {
					this.y++;
				}
			}else {
				y=1;
			}
		}
		if(commande.bas) {
			if(y+1<labyrinthe.getHeight()-1) {
				if(labyrinthe.getCase(x, y++).isSolid()) {
					this.y--;
				}
			}else {
				y=labyrinthe.getHeight()-2;
			}
		}	
	}

	
}
