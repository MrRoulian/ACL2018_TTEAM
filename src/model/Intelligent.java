package model;

import moteurJeu.Commande;

public class Intelligent implements Comportement {
	/**
	 * Entiers representant la position de la cible 
	 */
	private int targetX = -1 , targetY = -1;
	/**
	 * Entier representant la position actuelle dans la table du chemin 
	 */
	private int position = -1;
	/**
	 * Tableau representant le chemin vers la cible 
	 */
	private int[] chemin;

	/**
	 * variable de ralentissement d'action
	 */
	private int slow = 0;
	
	@Override
	public Commande bouger(int posX, int posY, LabyrintheGame labyrinthe) {
		// Creation de la commande 
		Commande commande = new Commande();
		// On incremente la variable de ralentissement d'action 
		slow++;
		// Si on a pas fini le temporisateur on ne fait rien
		if (slow%TEMPS_ENTRE_ACTION!=0){
			return commande;
		}
		// On minimise notre temporisateur pour eviter de depasser la limite des int 
		slow%=TEMPS_ENTRE_ACTION;


		// Si la cible a bouger on recherche le nouveau chemin 
		if (targetX != labyrinthe.getJoueur().getX() || targetY != labyrinthe.getJoueur().getY()) {
			this.targetX = labyrinthe.getJoueur().getX();
			this.targetY = labyrinthe.getJoueur().getY();

			// Mise a jour du chemin 
			this.updatePath(posX, posY, labyrinthe);
		}

		// On met a jour la position 
		this.position = posX + posY * labyrinthe.getMap().getWidth();
		// Cible dans le tableau du chemin 
		int target = targetX + targetY * labyrinthe.getMap().getWidth();

		if (position != target) {
			// Tant qu'on a pas trouver la prochaine position on recule dans le chemin
			while (chemin[target] != position) {
				target = chemin[target];
			}

			// Recuperation de la commande pour le monstre 
			if (position == target - 1) {
				commande.droite = true;
			}
			if (position == target + 1) {
				commande.gauche = true;
			}
			if (position == target + labyrinthe.getMap().getWidth()) {
				commande.haut = true;
			}
			if (position == target - labyrinthe.getMap().getWidth()) {
				commande.bas = true;
			}
		}
		return commande;
	}

	/**
	 * Met a jour la table de chemin 
	 * @param labyrinthe
	 */
	private void updatePath(int posX, int posY, LabyrintheGame labyrinthe) {
		// On initialise le tableau de distance 
		int[][] distance = new int[labyrinthe.getMap().getWidth()][labyrinthe.getMap().getHeight()];
		// On initialise le tableau du chemin
		chemin = new int[distance.length * distance[0].length];

		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance.length; j++) {
				// La distance de base est +00
				distance[i][j] = Integer.MAX_VALUE - 1;
			}
		}
		// La distace pour aller a l'entree est 0
		distance[posX][posY] = 0;
		// On initialise la plus petite valeur actuelle
		while (distance[targetX][targetY] == Integer.MAX_VALUE - 1) {
			for (int i = 0; i < distance.length; i++) {
				for (int j = 0; j < distance.length; j++) {
					// La distance est le min entre la val actuelle et voisin +1
					int min = distance[i][j];
					if (i + 1 < labyrinthe.getMap().getWidth() && !labyrinthe.getMap().getCase(i + 1, j).isSolid()) {
						if (min > distance[i+1][j] + 1) {
							min = distance[i+1][j] + 1;
							chemin[i + j * labyrinthe.getMap().getWidth()] = i + 1 + j * labyrinthe.getMap().getWidth();
						}
					}
					if (i - 1 > -1 && !labyrinthe.getMap().getCase(i - 1, j).isSolid()) {
						if (min > distance[i-1][j] + 1) {
							min = distance[i-1][j] + 1;
							chemin[i + j * labyrinthe.getMap().getWidth()] = i - 1 + j * labyrinthe.getMap().getWidth();
						}
					}
					if (j + 1 < labyrinthe.getMap().getHeight() && !labyrinthe.getMap().getCase(i, j + 1).isSolid()) {
						if (min > distance[i][j+1] + 1) {
							min = distance[i][j+1] + 1;
							chemin[i + j * labyrinthe.getMap().getWidth()] = i + (j + 1) * labyrinthe.getMap().getWidth();
						}
					}
					if (j - 1 > -1 && !labyrinthe.getMap().getCase(i, j - 1).isSolid()) {
						if (min > distance[i][j-1] + 1) {
							min = distance[i][j-1] + 1;
							chemin[i + j * labyrinthe.getMap().getWidth()] = i + (j - 1) * labyrinthe.getMap().getWidth();
						}
					}
					distance[i][j] = min;
				}
			}
		}

	}
}
