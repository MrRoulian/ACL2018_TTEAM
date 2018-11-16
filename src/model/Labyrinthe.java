package model;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFileChooser;

public class Labyrinthe {
	/**
	 * Represente le nombre de tresor dans la map avant la fin 
	 */
	public static int nbTreasureLeft;

	/**
	 * Attributs representant la taille de la map 
	 */
	private int height, width;
	/**
	 * Matrice representant la map 
	 */
	private Case[][] map;

	/**
	 * Constructeur de base qui cree une map de niveau 1
	 */
	public Labyrinthe(){
		construire(1);
	}
	
	/**
	 * Contructeur qui cree une map de niveau donne
	 * @param niveau Niveau donne pour creer la map 
	 */
	public Labyrinthe(int niveau){
		construire(niveau);
	}

	/**
	 * Methode qui construit la map de niveau donne
	 * @param level Niveau donne pour construire la map 
	 */
	public void construire(int level){
		// On tente d'uiliser le ConstructeurMapFichier sinon on prend le constructeur de base 
		try {
			map = ConstructeurMapFichier.getInstance().newMap(level);
		}
		catch(GenerationException ex) { 
			try {
				map = ConstructeurMapBase.getInstance().newMap(level);
			} catch (GenerationException e) {
				e.printStackTrace();
			}
		}
		// Mise a jour de la taille de la map
		this.width = map.length;
		this.height = map[0].length;
	}

	public Case getCase(int x, int y){
		return map[x][y];
	}

	/**
	 * Methode qui permet de dessiner la map sur l'image a construire
	 * @param g Graphics sur lequel on dessine l'image
	 */
	public void dessiner(Graphics2D g) {
		// Pour chaque case on la dessine 
		for (Case[] cases : map) {
			for (Case case1 : cases) {
				case1.dessiner(g);
			}
		}
	}

	public void affiche(int x,int y) {
		System.out.println("map ");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length-1; j++) {
				if(i==x && j==y) {
					System.out.print("8");
				}else {
					if(map[i][j].isSolid()) {
						System.out.print("#");
					}else {
						System.out.print("'");
					}
				}
			}
			System.out.println("#");
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}	
}
