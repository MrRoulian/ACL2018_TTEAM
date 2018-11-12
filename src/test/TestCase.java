package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Case;
import model.Joueur;
import model.Labyrinthe;
import model.PacmanGame;
import model.Tresor;
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
	

	public void marcheSurPiege() {
		
	}
	//piege activable une fois
	

	public void marcheSurEffet() {
		
	}
	

	public void prendreTeleporte() {
		
	}
	

	public void prendreEtReprendreTeleporte() {
		
	}
	
	public void prendreTeleporte_crossC() {
		
	}
	
	
	@Test
	public void nextCaseIsntTresor() {
		jeu.getJoueur().setPosition(2, 1);
		Joueur j=jeu.getJoueur();
		Case c=jeu.getMap().getCase(j.getX()-1, j.getY());
		assertTrue(c instanceof Tresor);
	}
	
	@Test
	public void ramasserTresor() {
		assertEquals(Labyrinthe.nbTreasureLeft, 4);
		jeu.getJoueur().setPosition(2, 1);
		jeu.evoluer(gauche);
		assertEquals(Labyrinthe.nbTreasureLeft, 3);
	}
	
	@Test
	public void ramasserAllTresor() {
		assertEquals(Labyrinthe.nbTreasureLeft, 4);
		jeu.getJoueur().setPosition(2, 1);
		jeu.evoluer(gauche);
		assertEquals(Labyrinthe.nbTreasureLeft, 3);
		jeu.getJoueur().setPosition(7, 1);
		jeu.evoluer(droite);
		assertEquals(Labyrinthe.nbTreasureLeft, 2);
		jeu.getJoueur().setPosition(2, 8);
		jeu.evoluer(gauche);
		assertEquals(Labyrinthe.nbTreasureLeft, 1);
		jeu.getJoueur().setPosition(7, 8);
		jeu.evoluer(droite);
		assertEquals(Labyrinthe.nbTreasureLeft, 0);
	}
	
	@Test
	public void isntFini() {
		jeu.getJoueur().setPosition(6, 7);
		jeu.evoluer(droite);
		assertFalse(jeu.etreFini());
	}
	

	
	
	
	

}
