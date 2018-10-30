package model;

import java.awt.Graphics2D;

public class Labyrinthe {

	private int height, width;
	private Case[][] map;

	public Labyrinthe(int width, int height){
		this.height = height;
		this.width = width;
		this.map = new Case[width][height];
		construire();
	}

	private void construire(){
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				map[i][j]=new Sol(i,j);
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (i==0 || i==width-1 || j==0 || j==height-1){
					map[i][j]=new Mur(i,j);
				}
			}
		}
	}
	
	public Case getCase(int x, int y){
		assert(x<0 || x>=width):"le x :"+x+" de getCase est en dehors du domaine du tableau width :"+width;
		assert(y<0 || y>=height):"le y de getCase est en dehors du domaine du tableau";
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
