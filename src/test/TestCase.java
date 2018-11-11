package test;

import org.junit.Before;
import org.junit.Test;

import model.Case;
import model.Joueur;
import model.Labyrinthe;
import model.PacmanGame;
import moteurJeu.Commande;

public class TestCase {

	private PacmanGame jeu;
	private PacmanGame jeuCrosCheck;
	private Commande gauche;
	private Commande droite;
	private Commande haut;
	private Commande bas;
	
	@Before
	public void initialise() throws CloneNotSupportedException {
		jeu=new PacmanGame("helpFilePacman.txt",true);
		jeuCrosCheck=new PacmanGame("helpFilePacman.txt",true);
		gauche=new Commande();
		gauche.gauche=true;
		droite=new Commande();
		droite.droite=true;
		haut=new Commande();
		haut.haut=true;
		bas=new Commande();
		bas.bas=true;
	}
	
	@Test
	public void marcheSurPiege() {
		
	}
	//piege activable une fois
	
	@Test
	public void marcheSurEffet() {
		
	}
	
	@Test
	public void prendreTeleporte() {
		
	}
	
	@Test
	public void prendreEtReprendreTeleporte() {
		
	}
	
	@Test
	public void prendreTeleporte_crossC() {
		
	}
	
	@Test
	public void istresor() {
		
	}
	
	@Test
	public void nextCaseIsntTresor() {
		Joueur j=jeu.getJoueur();
		Labyrinthe laby=jeu.getMap();
		Case c=laby.getCase(j.getX()+1, j.getY());
		
	}
	
	public void ramasserTresor() {
		
	}
	
	public void ramasserAllTresor() {
		
	}
	
	@Test
	public void isFini() {
		
	}
	
	
	
	

}
