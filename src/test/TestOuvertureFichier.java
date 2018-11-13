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
	 *  #,T, ,M, , , , ,T,#			T:tresor
	 *  #, , , , , , , , ,#			#:mur
	 *  #, , , , , ,#, , ,#			 :sol
	 *  #, , , , , , , , ,#			M:magique
	 *  #, , ,#, , , , , ,#			O:ours
	 *  #, , , , , , , , ,#			P:passage
	 *  #, , ,P, , , ,#, ,#
	 *  #,T, , , ,O, , ,T,#
	 *  #,#,#,#,#,#,#,#,#,#
	 *  
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
	public void ajoutEnceinte() {
		Labyrinthe map=jeu.getMap();
		for(int i=0;i<map.getHeight();i++) {
			Case c =map.getCase(0,i);
			assertTrue(c.isSolid());
			c =map.getCase(map.getHeight()-1,i);
			assertTrue(c.isSolid());
		}
		for(int j=0;j<map.getWidth();j++) {
			Case c =map.getCase(j,0);
			assertTrue(c.isSolid());
			c =map.getCase(j,map.getWidth()-1);
			assertTrue(c.isSolid());
		}
		
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
		assertEquals(4,Labyrinthe.nbTreasureLeft);
		c.trigger(jeu.getJoueur());
		assertEquals(3,Labyrinthe.nbTreasureLeft);
		
	}
	
	@Test
	public void isntTresor() {
		Labyrinthe map=jeu.getMap();
		Case c =map.getCase(7, 7);
		assertEquals(4,Labyrinthe.nbTreasureLeft);
		c.trigger(jeu.getJoueur());
		assertEquals(4,Labyrinthe.nbTreasureLeft);
		
	}
	
	@Test
	public void isPiege() {
		Labyrinthe map=jeu.getMap();
		Case c =map.getCase(5, 8);
		assertEquals(100,jeu.getJoueur().getVie());
		c.trigger(jeu.getJoueur());
		assertEquals(90,jeu.getJoueur().getVie());
		
	}
	@Test
	public void isntPiege() {
		Labyrinthe map=jeu.getMap();
		Case c =map.getCase(5, 7);
		assertEquals(100,jeu.getJoueur().getVie());
		c.trigger(jeu.getJoueur());
		assertEquals(100,jeu.getJoueur().getVie());
		
	}

}
