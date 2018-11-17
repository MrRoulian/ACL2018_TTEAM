package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFileChooser;

public class ConstructeurMapFichier implements ConstructeurMap{
	
	//Codes representant les type de case dans le fichier csv de la map a recuperer
	
	/**
	 * Code de la case de type back
	 */
	private static final int CODE_BACK = -1;
	/**
	 * Code de la case de type Sol
	 */
	private static final int CODE_CASE_SOL = 0;
	/**
	 * Code de la case de type Mur
	 */
	private static final int CODE_CASE_MUR = 1;
	/**
	 * Code de la case de type vertical right
	 */
	private static final int CODE_CASE_MUR_VERTICALR = 2;
	/**
	 * Code de la case de type vertical left
	 */
	private static final int CODE_CASE_MUR_VERTICALL = 3;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_MUR_HORIZON = 4;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_MUR_ANGLED = 5;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_MUR_ANGLEG = 6;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_MUR_ANGLEHD = 7;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_MUR_ANGLEHG = 8;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_MUR_PILIER = 9;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_2MUR_VERTICAL = 10;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_2MUR_HORIZONTAL = 11;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_2MUR_VERTICAL_ENDTOP = 12;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_2MUR_VERTICAL_ENDBOTTOM = 13;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_2MUR_HORIZONTAL_ENDR = 14;
	/**
	 * Code de la case de type horizon
	 */
	private static final int CODE_CASE_2MUR_HORIZONTAL_ENDL = 15;
	/**
	 * Code de la case de type Tresor
	 */
	private static final int CODE_CASE_TRESOR = 16;
	/**
	 * Code de la case de type Passage
	 */
	private static final int CODE_CASE_PASSAGE = 17;
	/**
	 * Code de la case de type PiegeAOurs
	 */
	private static final int CODE_CASE_PIEGE_A_OURS = 18;
	/**
	 * Code de la case de type Magique
	 */
	private static final int CODE_CASE_MAGIQUE = 19;
	/**
	 * Code de la case de type Tresor
	 */
	private static final int CODE_CASE_SKULL = 20;
	/**
	 * Code de la case de type Passage
	 */
	private static final int CODE_CASE_TOILE = 21;
	/**
	 * Code de la case de type PiegeAOurs
	 */
	private static final int CODE_CASE_FIRE = 22;
	/**
	 * Code de la case de type Magique
	 */
	private static final int CODE_CASE_STONR = 23;
	
	/**
	 * Map contenant pour chaque niveaux une liste de chaine correspondant a une map 
	 */
	private HashMap<Integer, ArrayList<String>> mapFichierMapParLevel;
	/**
	 * Instance du generateur pour eviter la multiplication d'instance
	 */
	private static ConstructeurMapFichier instance;
	
	/**
	 * Constructeur prive pour eviter la creation de noveaux objet en dehors de notre instance
	 */
	private ConstructeurMapFichier() {
		// Initialisation de la map 
		mapFichierMapParLevel = new HashMap<Integer, ArrayList<String>>();
		// ----- Map de Test ----- //
		// Creation de la liste de map de test 
		ArrayList<String> levelT = new ArrayList<String>();
		// Ajout des fichier de map a la liste 
		levelT.add("map/levelTmap1.csv");
		// Ajout de la liste a la map 
		mapFichierMapParLevel.put(-1, levelT);
		// ----- Map de level 1 ----- //
		// Creation de la liste de map de niveau 1
		ArrayList<String> level1 = new ArrayList<String>();
		// Ajout des fichier de map a la liste 
		level1.add("map/level1map1.csv");
		level1.add("map/level1map2.csv");
		level1.add("map/level1map3.csv");
		// Ajout de la liste a la map 
		mapFichierMapParLevel.put(1, level1);
		// ----- Map de level 2 ----- //
		// Creation de la liste de map de niveau 2
		ArrayList<String> level2 = new ArrayList<String>();
		// Ajout des fichier de map a la liste 
		level2.add("map/level2map1.csv");
		level2.add("map/level2map2.csv");
		// Ajout de la liste a la map 
		mapFichierMapParLevel.put(2, level2);
		// ----- Map de level 3 ----- //
		// Creation de la liste de map de niveau 3
		ArrayList<String> level3 = new ArrayList<String>();
		// Ajout des fichier de map a la liste 
		level3.add("map/level3map1.csv");
		level3.add("map/level3map2.csv");
		level3.add("map/level3map3.csv");
		level3.add("map/level3map4.csv");
		// Ajout de la liste a la map 
		mapFichierMapParLevel.put(3, level3);
	}
	
	/**
	 * Methode permetant de recuperer l'instance du ConstructeurMapFichier
	 * @return Instance de ConstructeurMapFichier
	 */
	public static ConstructeurMapFichier getInstance() {
		// Si l'instance n'est pas instanciee on l'instancie
		if (instance == null) {
			instance = new ConstructeurMapFichier();
		}
		return instance;
	}
	
	@Override
	public Case[][] newMap(int level) throws GenerationException {
		Labyrinthe.nbTreasureLeft = 0;
		Case[][] map;
		BufferedReader br;
		try {
			ArrayList<String> listeFichier = mapFichierMapParLevel.get(level);
			int numFile = (int)(listeFichier.size() * Math.random());
			String file = listeFichier.get(numFile);
			br = new BufferedReader(new FileReader(new File(file)));
			String line = br.readLine();
			String[] valeurs = line.split(",");
			int width = Integer.parseInt(valeurs[0]);
			int height = Integer.parseInt(valeurs[1]);

			map = new Case[width][height];
			
			line = br.readLine();
			int i = 0;
			while (line != null) {
				valeurs = line.split(",");
				for (int j = 0; j < height; j++) {
					switch(Integer.parseInt(valeurs[j])) {
					case CODE_BACK:
						map[j][i]=new Sol(j,i,-1);
						break;
					case CODE_CASE_SOL:
						map[j][i]=new Sol(j,i,0);
						break;
					case CODE_CASE_MUR:
						map[j][i]=new Mur(j,i,0);
						break;
					case CODE_CASE_MUR_VERTICALL:
						map[j][i]=new Mur(j,i,1);
						break;
					case CODE_CASE_MUR_VERTICALR:
						map[j][i]=new Mur(j,i,2);
						break;
					case CODE_CASE_MUR_HORIZON:
						map[j][i]=new Mur(j,i,3);
						break;
					case CODE_CASE_MUR_ANGLED:
						map[j][i]=new Mur(j,i,4);
						break;
					case CODE_CASE_MUR_ANGLEG:
						map[j][i]=new Mur(j,i,5);
						break;
					case CODE_CASE_MUR_ANGLEHD:
						map[j][i]=new Mur(j,i,6);
						break;
					case CODE_CASE_MUR_ANGLEHG:
						map[j][i]=new Mur(j,i,7);
						break;
					case CODE_CASE_MUR_PILIER:
						map[j][i]=new Mur(j,i,8);
						break;
					case CODE_CASE_2MUR_VERTICAL:
						map[j][i]=new Mur(j,i,9);
						break;
					case CODE_CASE_2MUR_HORIZONTAL:
						map[j][i]=new Mur(j,i,10);
						break;
					case CODE_CASE_2MUR_VERTICAL_ENDTOP:
						map[j][i]=new Mur(j,i,11);
						break;
					case CODE_CASE_2MUR_VERTICAL_ENDBOTTOM:
						map[j][i]=new Mur(j,i,12);
						break;
					case CODE_CASE_2MUR_HORIZONTAL_ENDR:
						map[j][i]=new Mur(j,i,13);
						break;
					case CODE_CASE_2MUR_HORIZONTAL_ENDL:
						map[j][i]=new Mur(j,i,14);
						break;
					case CODE_CASE_TRESOR:
						map[j][i] = new Tresor(j, i);
						Labyrinthe.nbTreasureLeft++;
						break;
					case CODE_CASE_PASSAGE:
						map[j][i]=new Passage(j,i);
						break;
					case CODE_CASE_PIEGE_A_OURS:
						map[j][i]=new PiegeAOurs(j,i);
						break;
					case CODE_CASE_MAGIQUE:
						map[j][i]=new Magique(j,i);
						break;
					case CODE_CASE_SKULL:
						map[j][i]=new Sol(j,i,1);
						break;
					case CODE_CASE_TOILE:
						map[j][i]=new Sol(j,i,2);
						break;
					case CODE_CASE_FIRE:
						map[j][i]=new Sol(j,i,3);
						break;
					case CODE_CASE_STONR:
						map[j][i]=new Sol(j,i,5);
						break;
					}
				}
				line = br.readLine();
				i++;
			}
			br.close();
			return map;
		} catch (FileNotFoundException e) {
			GenerationException ex = new GenerationException("Le fichier de la map n'existe pas");
			throw ex;
		} catch (IOException e) {
			GenerationException ex = new GenerationException("Le fichier de la map n'est pas valide");
			throw ex;
		}
	}
}
