package test;

import static org.junit.Assert.*;

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
		jeu=new PacmanGame("helpFilePacmanCase.txt",true);
		System.out.println();
		//jeuCrosCheck=new PacmanGame("helpFilePacman.txt",true);
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
		
	}
	@Test
	public void ramasserTresor() {
		System.out.println(Labyrinthe.nbTreasureLeft+"");
		jeu.evoluer(bas);
		jeu.evoluer(bas);
		jeu.evoluer(gauche);
		jeu.evoluer(gauche);
		jeu.evoluer(gauche);
		Labyrinthe laby=jeu.getMap();
		assertEquals(Labyrinthe.nbTreasureLeft, 0);
	}
	
	public void ramasserAllTresor() {
		
	}
	
	@Test
	public void isFini() {
		
	}
	
	
	
	

}
