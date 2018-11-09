package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class ConstructeurMapFichier implements ConstructeurMap{
	
	private static final int CODE_CASE_SOL = 0;
	private static final int CODE_CASE_MUR = 1;
	private static final int CODE_CASE_TRESOR = 2;

	private static ConstructeurMapFichier instance;
	
	private ConstructeurMapFichier() {}
	
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
			String file = fileChooser();
			if (file == null) {
				throw new FileNotFoundException();
			}
			br = new BufferedReader(new FileReader(file));
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
	
	private static String fileChooser() throws FileNotFoundException{
		JFileChooser dialogue = new JFileChooser();
		dialogue.showOpenDialog(null);
		if (dialogue.getSelectedFile() == null) {
			throw new FileNotFoundException();
		}
		return dialogue.getSelectedFile().getPath(); 
	}
}
