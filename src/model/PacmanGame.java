package model;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import moteurJeu.Commande;
import moteurJeu.Game;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class PacmanGame implements Game {
	
	/**
	 * Map du jeu
	 */
	protected Labyrinthe map;
	
	/**
	 * Joueur du jeu
	 */
	protected Joueur joueur;
	
	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	public PacmanGame(String source) {
		BufferedReader helpReader;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
				System.out.println(ligne);
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
		
		// Initialisation de la map
		map = new Labyrinthe(15, 15);
		
		// Initialisation du joueur 
		joueur = new Joueur();
	}

	@Override
	public void evoluer(Commande commandeUser) {
		// TODO Faire evoluer tout les objet qui ont besoin 
		joueur.update(commandeUser);
	}

	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}

	@Override
	public void dessiner(Graphics2D g) {
		// Demande a tout les elements du jeu de se dessiner 
		
		// Dabord la map 
		this.map.dessiner(g);
		
		// EN FIN le joueur (il est dessiné au dessus de tout autre elements
		this.joueur.dessiner(g);
	}

}
