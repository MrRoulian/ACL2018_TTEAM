package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Case;
import model.Labyrinthe;
import model.PacmanGame;
import model.Tresor;
import moteurJeu.Commande;

public class TestOuvertureFichier {


	/*
	 * map TEST
	 *  #,#,#,#,#,#,#,#,#,#
	 *  #,T, , , , , , ,T,#
	 *  #, , , , , , , , ,#
	 *  #, , , , , ,#, , ,#
	 *  #, , , , , , , , ,#
	 *  #, , ,#, , , , , ,#
	 *  #, , , , , , , , ,#
	 *  #, , , , , , ,#, ,#
	 *  #,T, , , , , , ,T,#
	 *  #,#,#,#,#,#,#,#,#,#
	 *  
	 *  T;tresor
	 *  #:mur
	 *   :sol
	 */
	
	private PacmanGame jeu;
	private PacmanGame jeuCrosCheck;
	private Commande gauche;
	private Commande droite;
	private Commande haut;
	private Commande bas;
	
	@Before
	public void initialise() throws CloneNotSupportedException {
		jeu=new PacmanGame("helpFilePacmanFile.txt",true);
		jeuCrosCheck=new PacmanGame("helpFilePacmanFile.txt",true);
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
	public void ajoutMur() {
		Labyrinthe map=jeu.getMap();
		Case c =map.getCase(6, 3);
		assertTrue(c.isSolid());
		c =map.getCase(3, 5);
		assertTrue(c.isSolid());
		
	}
	
	@Test
	public void nonMur() {
		Labyrinthe map=jeu.getMap();
		Case c =map.getCase(1, 1);
		assertFalse(c.isSolid());
		c =map.getCase(3, 3);
		assertFalse(c.isSolid());
		
	}
	
	
	@Test
	public void ajoutSol() {
		Labyrinthe map=jeu.getMap();
		Case c =map.getCase(2, 2);
		assertFalse(c.isSolid());
		c =map.getCase(2, 8);
		assertFalse(c.isSolid());
		
	}
	
	@Test
	public void nonSol() {
		Labyrinthe map=jeu.getMap();
		Case c =map.getCase(6, 3);
		assertTrue(c.isSolid());
		c =map.getCase(7, 7);
		assertTrue(c.isSolid());
		
	}
	
	
	@Test
	public void ajoutAllTrésor() {
		assertEquals(Labyrinthe.nbTreasureLeft, 4);
	}
	
	@Test
	public void isTresor() {
		Labyrinthe map=jeu.getMap();
		Case c =map.getCase(1, 1);
		assertTrue(c instanceof Tresor);
		
	}
	
	@Test
	public void isntTresor() {
		Labyrinthe map=jeu.getMap();
		Case c =map.getCase(7, 7);
		assertFalse(c instanceof Tresor);
		c =map.getCase(5, 5);
		assertFalse(c instanceof Tresor);
		
	}

}
