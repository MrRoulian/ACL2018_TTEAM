package model;

import java.awt.Graphics2D;
import java.awt.Image;

import moteurJeu.Commande;
import moteurJeu.PanelDessin;

public class Joueur extends Entite{

	public static int test=0;
	public int attaque;
	
	public Joueur(LabyrintheGame lab) {
		this.x = 5;
		this.y = 5;
		this.labyrinthe=lab;
		this.triggerCase = true;
		this.vie=100;
		attaque=-1;
	}

	@Override
	public void dessiner(Graphics2D g, Entite entite) {
		if (entite == this) {
			int xDessin = PanelDessin.getWindowsWidth() / 2;
			int yDessin = PanelDessin.getWindowsHeight() / 2;
			if(attaque>=0) {
				
				g.drawImage(SpriteLoader.getfire(attaque), xDessin-100, yDessin-100, LabyrinthePainter.WIDTH*3, LabyrinthePainter.HEIGHT*3,null);			
				attaque+=1;
				if(attaque>7) {
					attaque=-1;
				}
			}
			if(attaque==1) {
				g.drawImage(SpriteLoader.getknight(1), xDessin, yDessin, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);				
			}else {
			g.drawImage(SpriteLoader.getknight(0), xDessin, yDessin, LabyrinthePainter.WIDTH, LabyrinthePainter.HEIGHT,null);			
			}
		} else {
			if (inScreen(entite)) {
				Image sprite = SpriteLoader.getknight(0);
				this.drawSprite(g, entite, sprite);
			}
		}
	}

	private int slow = 0;
	private static final int TEMPS_ENTRE_ACTION = 2;
	
	@Override
	protected void update(Commande commande) {
		slow++;
		if (slow%TEMPS_ENTRE_ACTION!=0){
			commande = new Commande();
		}
		slow%=TEMPS_ENTRE_ACTION;
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
		if(commande.attaque) {
			attaque=0;
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
