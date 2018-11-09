package model;

import java.awt.Graphics2D;

import moteurJeu.Commande;

public abstract class Entite {

	protected int x, y;
	protected boolean avoidSolidCase, triggerCase;

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
			++x;
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
			--x;
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
			--y;
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
			++y;
		}
		if (triggerCase) {
			labyrinthe.getCase(x, y).trigger(this);
		}
	}

}
