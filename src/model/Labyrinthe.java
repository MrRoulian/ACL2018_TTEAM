package model;

import java.awt.Graphics2D;

public class Labyrinthe implements Cloneable{

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
		assert(x<0 || x>=width):"le x de getCase est en dehors du domaine du tableau";
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

	@Override
	protected Labyrinthe clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Labyrinthe lab= (Labyrinthe) super.clone();
		return lab;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	
}
