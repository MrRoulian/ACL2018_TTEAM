package model;

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
		assert(x<0 || x>=width):"le x de getCase est en dehors du domaine du tableau";
		assert(y<0 || y>=height):"le y de getCase est en dehors du domaine du tableau";
		return map[x][y];
	}
	
	
}
