package model;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFileChooser;

public class Labyrinthe {
	
	public static int nbTreasureLeft;

	private int height, width;
	private Case[][] map;

	public Labyrinthe(int width, int height){
		this.height = height;
		this.width = width;
		this.map = new Case[width][height];
		construire(1);
	}

	public void construire(int level){
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
	}

	public Case getCase(int x, int y){
		return map[x][y];
	}

	public void dessiner(Graphics2D g) {
		// Dessine le labyrinthe
		for (Case[] cases : map) {
			for (Case case1 : cases) {
				case1.dessiner(g);
			}
		}
	}


	public void affiche(int x,int y) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
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
			System.out.println(" ");
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}	
}
