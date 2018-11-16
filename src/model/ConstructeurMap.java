package model;

public interface ConstructeurMap {
	
	/**
	 * Methode qui donne une matrice representant la map d'un niveau du jeu en fontion du niveau demand�
	 * @param level Niveau de la map attendu 
	 * @return Matrice correspondant a la map 
	 * @throws GenerationException Impossibilite de generer la map demand�e 
	 */
	public Case[][] newMap(int level) throws GenerationException;

}
