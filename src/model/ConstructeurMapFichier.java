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
	
	private static final int CODE_CASE_SOL = 0;
	private static final int CODE_CASE_MUR = 1;
	private static final int CODE_CASE_TRESOR = 2;
	
	private HashMap<Integer, ArrayList<String>> mapFichierMapParLevel;

	private static ConstructeurMapFichier instance;
	
	private ConstructeurMapFichier() {
		mapFichierMapParLevel = new HashMap<Integer, ArrayList<String>>();
		// ----- Map de level 1 ----- //
		ArrayList<String> level1 = new ArrayList<String>();
		level1.add("map/level1map1.csv");
		mapFichierMapParLevel.put(1, level1);
		// ----- Map de level 2 ----- //
		ArrayList<String> level2 = new ArrayList<String>();
		level2.add("map/level2map1.csv");
		mapFichierMapParLevel.put(2, level2);
		// ----- Map de level 3 ----- //
		ArrayList<String> level3 = new ArrayList<String>();
		level3.add("map/level3map1.csv");
		mapFichierMapParLevel.put(3, level3);
	}
	
	public static ConstructeurMapFichier getInstance() {
		if (instance == null) {
			instance = new ConstructeurMapFichier();
		}
		return instance;
	}
	
	public Case[][] newMap(int level) throws GenerationException {
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
					case CODE_CASE_SOL:
						map[i][j]=new Sol(i,j);
						break;
					case CODE_CASE_MUR:
						map[i][j]=new Mur(i,j);
						break;
					case CODE_CASE_TRESOR:
						map[i][j] = new Tresor(i, j);
						Labyrinthe.nbTreasureLeft++;
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
