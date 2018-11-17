package model;

public class ConstructeurMapBase implements ConstructeurMap{

	/**
	 * Instance du generateur pour eviter la multiplication d'instance
	 */
	private static ConstructeurMapBase instance;
	
	/**
	 * Constructeur prive pour eviter la creation de noveaux objet en dehors de notre instance
	 */
	private ConstructeurMapBase() {}
	
	/**
	 * Methode permetant de recuperer l'instance du ConstructeurMapBAse
	 * @return Instance de ConstructeurMapBase
	 */
	public static ConstructeurMap getInstance() {
		// Si l'instance n'est pas instanciee on l'instancie
		if (instance == null) {
			instance = new ConstructeurMapBase();
		}
		return instance;
	}

	@Override
	public Case[][] newMap(int level) throws GenerationException {
		// Initialisation de la matrice 
		Case[][] map = new Case[level*5][level*5];
		// Recuperation de la taille de la matrice
		int width = map.length;
		int height = map[0].length;
		//Creation de l'arène (tout les bord de la matrice sont des murs eet le centre est du sol)
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				map[i][j]=( i == 0 || i == width-1 || j == 0 || j == height-1)? new Mur(i,j,0) : new Sol(i,j,1);
			}
		}		
		
		// Placement des tresor 
		placerTresor(map, level);
		
		return map;
	}
	
	/**
	 * Methode qui place un tresor dans la map 
	 * @param map Map auquel on ajoute le tresor 
	 * @param level Niveau pour change le nombre de tresor a mettre dans la map
	 */
	private void placerTresor(Case[][] map, int level) {
		// On place des tresor en diagonale
		for (int i = 0; i < level; i++) {
			map[1+i*2][1+i*2] = new Tresor(1+i*2, 1+i*2);
		}
		// On augmente le nombre de tresor dans le labyrinthe
		Labyrinthe.nbTreasureLeft = level;
	}
}
