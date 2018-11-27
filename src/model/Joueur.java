package model;

import java.awt.Graphics2D;
import java.awt.Image;

import moteurJeu.Commande;
import moteurJeu.PanelDessin;

public class Joueur extends Entite{

	public static int test=0;
	
	public Joueur(LabyrintheGame lab) {
		this.x = 5;
		this.y = 5;
		this.labyrinthe=lab;
		this.triggerCase = true;
		this.vie=100;
	}

	@Override
	public void dessiner(Graphics2D g, Entite entite) {
		if (entite == this) {
			int xDessin = PanelDessin.getWindowsWidth() / 2;
			int yDessin = PanelDessin.getWindowsHeight() / 2;
			g.drawImage(SpriteLoader.getknight(0), xDessin, yDessin, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);			
		} else {
			if (inScreen(entite)) {
				Image sprite = SpriteLoader.getknight(0);
				this.drawSprite(g, entite, sprite);
			}
		}
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
