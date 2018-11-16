package model;

import java.awt.Graphics2D;

import moteurJeu.Commande;

public abstract class Entite {

	protected int x, y;
	protected boolean avoidSolidCase, triggerCase;
	protected int vie;

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

	public void droite() {
		if (!avoidSolidCase) {
			if(labyrinthe.getCase(++x, y).isSolid()) {
				this.x--;
			}
		} else {
			if (x + 1 < labyrinthe.getWidth()) {
				++x;				
			}
		}
		if (triggerCase) {
			labyrinthe.getCase(x, y).trigger(this);
		}
	}

	public void gauche() {
		if (!avoidSolidCase) {
			if(labyrinthe.getCase(--x, y).isSolid()) {
				this.x++;
			}
		} else {
			if (x - 1 >= 0) {
				--x;
			}
		}
		if (triggerCase) {
			labyrinthe.getCase(x, y).trigger(this);
		}
	}

	public void haut() {
		if (!avoidSolidCase) {
			if(labyrinthe.getCase(x, --y).isSolid()) {
				this.y++;
			}
		} else {
			if (y - 1 >= 0){
				--y;				
			}
		}
		if (triggerCase) {
			labyrinthe.getCase(x, y).trigger(this);
		}
	}

	public void bas() {
		if (!avoidSolidCase) {
			if(labyrinthe.getCase(x, ++y).isSolid()) {
				this.y--;
			}
		} else {
			if (y + 1 < labyrinthe.getHeight()){
				++y;			
			}
		}
		if (triggerCase) {
			labyrinthe.getCase(x, y).trigger(this);
		}
	}

	public void takeDamage(int damage){
		vie -= damage;
	}
	
	public boolean isAlive(){
		return vie <= 0;
	}

}
