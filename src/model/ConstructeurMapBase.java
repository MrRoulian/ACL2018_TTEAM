package model;

public class ConstructeurMapBase implements ConstructeurMap{

	private static ConstructeurMapBase instance;
	
	private ConstructeurMapBase() {}
	
	public static ConstructeurMap getInstance() {
		if (instance == null) {
			instance = new ConstructeurMapBase();
		}
		return instance;
	}
	
	public Case[][] newMap(int level) throws GenerationException {
		Case[][] map = new Case[level*5][level*5];
		int width = map.length;
		int height = map[0].length;
		//Creation de l'arène
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				map[i][j]=( i == 0 || i == width-1 || j == 0 || j == height-1)? new Mur(i,j) : new Sol(i,j);
			}
		}		
		
		placerTresor(map, level);
		return map;
	}
	
	private void placerTresor(Case[][] map, int level) {
		for (int i = 0; i < level; i++) {
			map[1+i*2][1+i*2] = new Tresor(1+i*2, 1+i*2);
		}
		Labyrinthe.nbTreasureLeft = level;
	}
}
