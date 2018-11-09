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
		construire();
	}

	private static String fileChooser() {
		JFileChooser dialogue = new JFileChooser();
		dialogue.showOpenDialog(null);
		return dialogue.getSelectedFile().getPath(); 
	}

	private void construire(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileChooser()));
			String line = br.readLine();
			String[] valeurs = line.split(",");
			width = Integer.parseInt(valeurs[0]);
			height = Integer.parseInt(valeurs[1]);

			line = br.readLine();
			int i = 0;
			while (line != null) {
				valeurs = line.split(",");
				for (int j = 0; j < height; j++) {
					switch(Integer.parseInt(valeurs[j])) {
					case 0:
						map[i][j]=new Sol(i,j);
						break;
					case 1:
						map[i][j]=new Mur(i,j);
						break;
					}
				}
				line = br.readLine(); System.out.println(i);
				i++;
			}
		}
		catch(Throwable t) {
			t.printStackTrace(System.err) ;
			//Creation de l'arène
			for(int i=0;i<width;i++){
				for(int j=0;j<height;j++){
					map[i][j]=( i == 0 || i == width-1 || j == 0 || j == height-1)? new Mur(i,j) : new Sol(i,j);
				}
			}
			map[1][1] = new Tresor(1, 1);
			nbTreasureLeft = 1;
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
