package model;

import java.awt.Point;

import moteurJeu.Commande;
/**
 * Classe abstraite representant le comportement d'une entite vivate dans le jeu
 */
public abstract class Entite extends Dessinable{
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
	 * Jeu dans laquel notre entite evolue
	 */
	protected LabyrintheGame labyrinthe;


	private boolean drunk;
	/**
	 * Permet au moteur de mettre a jour l'entite a chaque iteration du jeu 
	 * @param commande Commande representant l'input clavier a l'iteration du jeu 
	 */
	protected abstract void update(Commande commande);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	/**
	 * Methode permettant d'attaquer les entités autour de celle ci
	 */
	public abstract void attaquer();

	/**
	 * Methode qui deplace l'entite sur la droite
	 */
	public void droite() {
		if (!isdead()){
			// Si l'entite ne peut traverser les cases on teste la collision sinon on deplace vers la droite
			if (!avoidSolidCase) {
				if(labyrinthe.getMap().getCase(++x, y).isSolid()) {
					this.x--;
				}
			} else {
				if (x + 1 < labyrinthe.getMap().getWidth()) {
					++x;				
				}
			}
			// Si l'entite declanche les cases on declanche la case sur lequel il passe 
			if (triggerCase) {
				labyrinthe.getMap().getCase(x, y).trigger(this);
			}		
		}
	}

	/**
	 * Methode qui deplace l'entite sur la gauche
	 */
	public void gauche() {
		if (!isdead()){
			// Si l'entite ne peut traverser les cases on teste la collision sinon on deplace vers la gauche
			if (!avoidSolidCase) {
				if(labyrinthe.getMap().getCase(--x, y).isSolid()) {
					this.x++;
				}
			} else {
				if (x - 1 >= 0) {
					--x;
				}
			}
			// Si l'entite declanche les cases on declanche la case sur lequel il passe 
			if (triggerCase) {
				labyrinthe.getMap().getCase(x, y).trigger(this);
			}
		}
	}

	/**
	 * Methode qui deplace l'entite vers le haut
	 */
	public void haut() {
		if (!isdead()){
			// Si l'entite ne peut traverser les cases on teste la collision sinon on deplace vers le haut
			if (!avoidSolidCase) {
				if(labyrinthe.getMap().getCase(x, --y).isSolid()) {
					this.y++;
				}
			} else {
				if (y - 1 >= 0){
					--y;				
				}
			}
			// Si l'entite declanche les cases on declanche la case sur lequel il passe 
			if (triggerCase) {
				labyrinthe.getMap().getCase(x, y).trigger(this);
			}
		}
	}

	/**
	 * Methode qui deplace l'entite vers le bas
	 */
	public void bas() {
		if (!isdead()){
			// Si l'entite ne peut traverser les cases on teste la collision sinon on deplace vers le bas
			if (!avoidSolidCase) {
				if(labyrinthe.getMap().getCase(x, ++y).isSolid()) {
					this.y--;
				}
			} else {
				if (y + 1 < labyrinthe.getMap().getHeight()){
					++y;			
				}
			}
			// Si l'entite declanche les cases on declanche la case sur lequel il passe 
			if (triggerCase) {
				labyrinthe.getMap().getCase(x, y).trigger(this);
			}
		}
	}

	public void takeDamage(int damage){
		vie -= damage;
	}
	public void boire(){
		drunk= true;
	}
	
	public void nonboire(){
		drunk= false;
	}
	
	public boolean isdrunk() {
		return drunk;
	}

	public boolean isdead(){
		return vie <= 0;
	}

	protected int calculerDistance(Point p1 , Point p2){
		int res = Math.abs((Math.abs(p1.x)-Math.abs(p2.x)));
		res += Math.abs((Math.abs(p1.y)-Math.abs(p2.y)));
		return res;
	}
}
