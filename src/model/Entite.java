package model;

import java.awt.Graphics2D;

import moteurJeu.Commande;
/**
 * Classe abstraite representant le comportement d'une entite vivate dans le jeu
 */
public abstract class Entite {

	/**
	 * Entier correspondant a la position de l'entite 
	 */
	protected int x, y;
	/**
	 * Booleen indicant si l'entite a la capacite de traverser les cases normalement pas traversable
	 */
	protected boolean avoidSolidCase;
	/**
	 * Booleen indicant si l'entite active les cases lorsqu'elle marche dessus
	 */
	protected boolean triggerCase;
	/**
	 * Entier correspondant a la vie de l'entite
	 */
	protected int vie;

	/**
	 * Map dans laquel notre entite evolue
	 */
	protected Labyrinthe labyrinthe;
	
	/**
	 * Permet au moteur de mettre a jour l'entite a chaque iteration du jeu 
	 * @param commande Commande representant l'input clavier a l'iteration du jeu 
	 */
	protected abstract void update(Commande commande);

	/**
	 * Methode qui permet de dessiner l'entite sur l'image a construire
	 * @param g Graphics sur lequel on dessine l'image
	 */
	protected abstract void dessiner(Graphics2D g);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * Methode qui deplace l'entite sur la droite
	 */
	public void droite() {
		// Si l'entite ne peut traverser les cases on teste la collision sinon on deplace vers la droite
		if (!avoidSolidCase) {
			if(labyrinthe.getCase(++x, y).isSolid()) {
				this.x--;
			}
		} else {
			if (x + 1 < labyrinthe.getWidth()) {
				++x;				
			}
		}
		// Si l'entite declanche les cases on declanche la case sur lequel il passe 
		if (triggerCase) {
			labyrinthe.getCase(x, y).trigger(this);
		}
	}

	/**
	 * Methode qui deplace l'entite sur la gauche
	 */
	public void gauche() {
		// Si l'entite ne peut traverser les cases on teste la collision sinon on deplace vers la gauche
		if (!avoidSolidCase) {
			if(labyrinthe.getCase(--x, y).isSolid()) {
				this.x++;
			}
		} else {
			if (x - 1 >= 0) {
				--x;
			}
		}
		// Si l'entite declanche les cases on declanche la case sur lequel il passe 
		if (triggerCase) {
			labyrinthe.getCase(x, y).trigger(this);
		}
	}

	/**
	 * Methode qui deplace l'entite vers le haut
	 */
	public void haut() {
		// Si l'entite ne peut traverser les cases on teste la collision sinon on deplace vers le haut
		if (!avoidSolidCase) {
			if(labyrinthe.getCase(x, --y).isSolid()) {
				this.y++;
			}
		} else {
			if (y - 1 >= 0){
				--y;				
			}
		}
		// Si l'entite declanche les cases on declanche la case sur lequel il passe 
		if (triggerCase) {
			labyrinthe.getCase(x, y).trigger(this);
		}
	}

	/**
	 * Methode qui deplace l'entite vers le bas
	 */
	public void bas() {
		// Si l'entite ne peut traverser les cases on teste la collision sinon on deplace vers le bas
		if (!avoidSolidCase) {
			if(labyrinthe.getCase(x, ++y).isSolid()) {
				this.y--;
			}
		} else {
			if (y + 1 < labyrinthe.getHeight()){
				++y;			
			}
		}
		// Si l'entite declanche les cases on declanche la case sur lequel il passe 
		if (triggerCase) {
			labyrinthe.getCase(x, y).trigger(this);
		}
	}

	public void takeDamage(int damage){
		vie -= damage;
	}
	
	public boolean isdead(){
		return vie <= 0;
	}

}
