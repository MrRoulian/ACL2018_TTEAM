package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import moteurJeu.Commande;
import moteurJeu.Game;
import moteurJeu.PanelDessin;

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
	 * Liste de monstres
	 */
	protected ArrayList<Monstre> monstres;
	
	/**
	 * constructeur avec fichier source pour le help
	 * @throws CloneNotSupportedException 
	 * 
	 */
	public LabyrintheGame(String source) throws CloneNotSupportedException {
		BufferedReader helpReader;
		monstres = new ArrayList<>();
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
		joueur = new Joueur(this);
		
		//Initialisation des monstres
		int randX=0,randY=0;
		boolean end = false;
		do {
			randX = (int)(Math.random()*joueur.labyrinthe.getMap().getWidth()-1)+1;
			randY = (int)(Math.random()*joueur.labyrinthe.getMap().getHeight()-1)+1;
			if (joueur.labyrinthe.getMap().getCase(randX, randY).traversable){
				monstres.add(new Squelette(new Intelligent(), randX, randY, this));
				monstres.add(new Fantome(new Aleatoire(), randX, randY, this));
				end = true;
			}
		} while (!end);
		
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
		monstres = new ArrayList<>();
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
			joueur = new Joueur(this);
		// Initialisation du level a 1
			levelActuel = -1;
			//MAX_LEVEL = 1;
			test=t;
		}else {
			// Initialisation de la map
			map = new Labyrinthe();
			
			// Initialisation du joueur 
			joueur = new Joueur(this);
			levelActuel=1;
		}
		monstres.add(new Squelette(new Intelligent(), 2, 3, this));
		monstres.add(new Fantome(new Aleatoire(), 4, 4, this));
		
	}

	@Override
	public void evoluer(Commande commandeUser) {
		joueur.update(commandeUser);
		for (Monstre monstre : monstres) {
			monstre.update(null);
		}
		if(!test) {
			testerFin();
		}
	}

	private void testerFin() {
		if(joueur.isdead()) {
			fini=true;
		}
		if (Labyrinthe.nbTreasureLeft <= 0 && levelActuel == MAX_LEVEL) {
			fini = true;
		} else {
			//Si le iveau est fini on lance le suivant
			if (Labyrinthe.nbTreasureLeft <= 0) {
				// On construit le niveau suivant
				map.construire(++levelActuel);

				// On place le joueur sur une case non solide aléatoire 
				int randX,randY;
				boolean end = false;
				do {
					randX = (int)(Math.random() * map.getWidth());
					randY = (int)(Math.random() * map.getHeight());
					if (!map.getCase(randX, randY).isSolid()){
						joueur.x = randX;
						joueur.y = randY;
						end = true;
					}
				} while (!end);
				// On supprime les ancien monstres 
				monstres.clear();

				// On creer de nouveaux monstres 
				for (int i = 0; i < levelActuel + (int)(Math.random() * (levelActuel * levelActuel)); i++) {
					end = false;
					do {
						randX = (int)(Math.random() * map.getWidth());
						randY = (int)(Math.random() * map.getHeight());
						if (!map.getCase(randX, randY).isSolid()){
							joueur.x = randX;
							joueur.y = randY;
							end = true;
						}
					} while (!end);
					switch ((int)(Math.random()*2)) {
					case 0:
						monstres.add(new Squelette(new Intelligent(), randX, randY, this));
						break;
					case 1:
						monstres.add(new Fantome(new Aleatoire(), randX, randY, this));						
						break;
					default:
						break;
					}
				}
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
		this.map.dessiner(g, joueur);
		
		//Dessine les monstres
		for (Monstre monstre : monstres) {
			monstre.dessiner(g, joueur);
		}
		
		// EN FIN le joueur (il est dessiné au dessus de tout autre elements
		this.joueur.dessiner(g, joueur);
		
		if(fini) {
			if(joueur.isdead()) {
				g.drawImage(SpriteLoader.getGameOver(), 0, 0, PanelDessin.getWindowsWidth(),
						PanelDessin.getWindowsHeight(),null);	
			}else {
				
				g.drawImage(SpriteLoader.getWin(), 0, 0, PanelDessin.getWindowsWidth(),
						PanelDessin.getWindowsHeight(),null);
			}
		}
		
	}
	
	public void testfin() {
		if(fini) {
			if(joueur.isdead()) {

				JOptionPane jo = new JOptionPane();
				int option = JOptionPane.showConfirmDialog(null, "veux tu recommencer ?", "TU ES NUL", JOptionPane.YES_NO_OPTION,
						JOptionPane.NO_OPTION);
				if (option == JOptionPane.YES_NO_OPTION) {
					fini=false;

					this.regame();
					
				}
				if (option == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
				if (option == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				}
			}else {
				
				System.out.println("Le jeu est fini GG");
				JOptionPane jo = new JOptionPane();
				int option = JOptionPane.showConfirmDialog(null, "veux tu recommencer ?", "TU ES VICTORIEUX", JOptionPane.YES_NO_OPTION,
						JOptionPane.NO_OPTION);
				if (option == JOptionPane.YES_NO_OPTION) {
					fini=false;
					this.regame();
					
				}
				if (option == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
				if (option == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				}
			}
		}
	}
	
	public void regame() {
		// Initialisation du joueur 

		map.construire(1);
		joueur = new Joueur(this);
		monstres.clear();
		//Initialisation des monstres
		int randX=0,randY=0;
		boolean end = false;
		do {
			randX = (int)(Math.random()*joueur.labyrinthe.getMap().getWidth()-1)+1;
			randY = (int)(Math.random()*joueur.labyrinthe.getMap().getHeight()-1)+1;
			if (joueur.labyrinthe.getMap().getCase(randX, randY).traversable){
				monstres.add(new Squelette(new Intelligent(), randX, randY, this));
				monstres.add(new Fantome(new Aleatoire(), randX, randY, this));
				end = true;
			}
		} while (!end);
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

	public ArrayList<Monstre> getMonstres() {
		return monstres;
	}

}
