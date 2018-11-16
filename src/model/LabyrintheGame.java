package model;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import moteurJeu.Commande;
import moteurJeu.Game;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class LabyrintheGame implements Game {
	
	/**
	 * Map du jeu
	 */
	protected Labyrinthe map;
	
	/**
	 * Joueur du jeu
	 */
	protected Joueur joueur;
	
	/**
	 * Represente si le jeu est fini
	 */
	protected boolean fini;
	
	/*
	 * boolean pour lancer le jeu en version test
	 */
	public static boolean test=false;
	
	/**
	 * Represente le niveau actuel
	 */
	protected int levelActuel;
	private static int MAX_LEVEL = 3;
	
	/**
	 * constructeur avec fichier source pour le help
	 * @throws CloneNotSupportedException 
	 * 
	 */
	public LabyrintheGame(String source) throws CloneNotSupportedException {
		BufferedReader helpReader;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
				System.out.println(ligne);
			}
			helpReader.close();
		} catch (IOException e) {
			//System.out.println("Help not available");
		}
		
		// Initialisation de la map
		map = new Labyrinthe();
		
		// Initialisation du joueur 
		joueur = new Joueur(map);
		
		// Initialisation du level a 1
		levelActuel = 1;
	}
	
	/**
	 * constructeur pour le test avec fichier source pour le help
	 * @throws CloneNotSupportedException 
	 * 
	 */
	public LabyrintheGame(String source,boolean t) throws CloneNotSupportedException {
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
		
		if(t==true) {
			// Initialisation de la map
			map = new Labyrinthe(-1);
			
			// Initialisation du joueur 
			joueur = new Joueur(map);
		// Initialisation du level a 1
			levelActuel = -1;
			//MAX_LEVEL = 1;
			test=t;
		}else {
			// Initialisation de la map
			map = new Labyrinthe();
			
			// Initialisation du joueur 
			joueur = new Joueur(map);
			levelActuel=1;
		}
		
	}

	@Override
	public void evoluer(Commande commandeUser) {
		joueur.update(commandeUser);
		if(!test) {
			testerFin();
		}
	}

	private void testerFin() {
		if (Labyrinthe.nbTreasureLeft <= 0 && levelActuel == MAX_LEVEL) {
			fini = true;
			System.out.println("Le jeu est fini GG");
		} else {
			if (Labyrinthe.nbTreasureLeft <= 0) {
				map.construire(++levelActuel);
			}
		}
	}

	@Override
	public boolean etreFini() {
		return fini;
	}

	@Override
	public void dessiner(Graphics2D g) {
		// Demande a tout les elements du jeu de se dessiner 
		
		// Dabord la map 
		this.map.dessiner(g);
		
		// EN FIN le joueur (il est dessiné au dessus de tout autre elements
		this.joueur.dessiner(g);
	}

	public Labyrinthe getMap() {
		return map;
	}

	public Joueur getJoueur() {
		return joueur;
	}
	
	public void affcihe() {
		System.out.println(joueur.x+" "+joueur.y);
		System.out.println(map.getHeight());
		System.out.println(map.getWidth());
		map.affiche(joueur.x,joueur.y);

	}

}
