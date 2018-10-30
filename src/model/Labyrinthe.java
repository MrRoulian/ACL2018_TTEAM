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
