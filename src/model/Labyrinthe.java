package model;

import java.awt.Graphics2D;

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
			reDrawMap();
		}
		catch(GenerationException ex) { 
			try {
				map = ConstructeurMapBase.getInstance().newMap(level);
				reDrawMap();
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
	/*
	North West = 20 = 1
			North = 21 = 2
			North East = 22 = 4
			West = 23 = 8
			East = 24 = 16
			South West = 25 = 32
			South= 26 = 64
			South East = 27 = 128
	*/
	public void reDrawMap() {
		int res=0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				
				if(map[i][j].isSolid()) {
					if(j!=0 ) {
						if(i!=0) {
							if(map[i-1][j-1].isSolid() && (map[i-1][j].isSolid()) && (map[i][j-1].isSolid())) {
								res+=1*1;
							}
						}
						if(map[i][j-1].isSolid()) {
								res+=1*2;
						}
						//
						if(i!=map.length-1) {
							if(map[i+1][j-1].isSolid() && (map[i][j-1].isSolid()) && (map[i+1][j].isSolid())) {
								res+=1*4;
							}
						}
					}
					if(i!=0) {
						if(map[i-1][j].isSolid()) {
							res+=1*8;
						}
					}
					if(i!=map.length-1) {
						if(map[i+1][j].isSolid()) {
							res+=16*1;
						}
					}
					if(j!= map[0].length-1) {
						if(i!=0) {
							if(map[i-1][j+1].isSolid() && map[i-1][j].isSolid() && map[i][j+1].isSolid() ) {
								res+=32*1;
							}
						}
						if(map[i][j+1].isSolid()) {
								res+=64*1;
						}
						if(i!=map.length-1) {
							if(map[i+1][j+1].isSolid() && map[i][j+1].isSolid() && map[i+1][j].isSolid() ) {
								res+=1*128;
							}
						}
					}
					//System.out.println(res);
					Bitmasking(map[i][j],res);
					
				}
				res=0;
			}
		}
	}
	
	public void Bitmasking(Case c,int val) {
		switch(val) {
			case 2:
				c.idSpriteBack(1);
				break;
			case 8:
				c.idSpriteBack(2);
				break;
			case 10:
				c.idSpriteBack(3);
				break;
			case 11:
				c.idSpriteBack(4);
				break;
			case 16:
				c.idSpriteBack(5);
				break;
			case 18:
				c.idSpriteBack(6);
				break;
			case 22:
				c.idSpriteBack(7);
				break;
			case 24:
				c.idSpriteBack(8);
				break;
			case 26:
				c.idSpriteBack(9);
				break;
			case 27:
				c.idSpriteBack(10);
				break;
			case 30:
				c.idSpriteBack(11);
				break;
			case 31:
				c.idSpriteBack(12);
				break;
			case 64:
				c.idSpriteBack(13);
				break;
			case 66:
				c.idSpriteBack(14);
				break;
			case 72:
				c.idSpriteBack(15);
				break;
			case 74:
				c.idSpriteBack(16);
				break;
			case 75:
				c.idSpriteBack(17);
				break;
			case 80:
				c.idSpriteBack(18);
				break;
			case 82:
				c.idSpriteBack(19);
				break;
			case 86:
				c.idSpriteBack(20);
				break;
			case 88:
				c.idSpriteBack(21);
				break;
			case 90:
				c.idSpriteBack(22);
				break;
			case 91:
				c.idSpriteBack(23);
				break;
			case 94:
				c.idSpriteBack(24);
				break;
			case 95:
				c.idSpriteBack(25);
				break;
			case 104:
				c.idSpriteBack(26);
				break;
			case 106:
				c.idSpriteBack(27);
				break;
			case 107:
				c.idSpriteBack(28);
				break;
			case 120:
				c.idSpriteBack(29);
				break;
			case 122:
				c.idSpriteBack(30);
				break;
			case 123:
				c.idSpriteBack(31);
				break;
			case 126:
				c.idSpriteBack(32);
				break;
			case 127:
				c.idSpriteBack(33);
				break;
			case 208:
				c.idSpriteBack(34);
				break;
			case 210:
				c.idSpriteBack(35);
				break;
			case 214:
				c.idSpriteBack(36);
				break;
			case 216:
				c.idSpriteBack(37);
				break;
			case 218:
				c.idSpriteBack(38);
				break;
			case 219:
				c.idSpriteBack(39);
				break;
			case 222:
				c.idSpriteBack(40);
				break;
			case 223:
				c.idSpriteBack(41);
				break;
			case 248:
				c.idSpriteBack(42);
				break;
			case 250:
				c.idSpriteBack(43);
			break;
			case 251:
				c.idSpriteBack(44);
				break;
			case 254:
				c.idSpriteBack(45);
				break;
			case 255:
				c.idSpriteBack(46);
				break;
				default:
					c.idSpriteBack(0);
					break;
					
		}
	}
}
