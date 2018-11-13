package test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import model.Case;
import model.Entite;
import model.Joueur;
import model.Labyrinthe;
import model.Magique;
import model.PacmanGame;
import model.Special;
import model.Tresor;
import moteurJeu.Commande;

public class TestCase {

	
	/*
	 * map TEST
	 *  #,#,#,#,#,#,#,#,#,#
	 *  #,T, ,P, , , , ,T,#			T:tresor
	 *  #, , , , , , , , ,#			#:mur
	 *  #, , , , , ,#, , ,#			 :sol
	 *  #, , , , , , , , ,#			M:magique
	 *  #, , ,#, , , , , ,#			O:ours
	 *  #, , , , , , , , ,#			P:passage
	 *  #, , ,M, , , ,#, ,#
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
		jeu=new PacmanGame("helpFilePacmanCase.txt",true);
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
		jeu.getJoueur().setPosition(4,8);
		assertEquals(100, jeu.getJoueur().getVie());
		jeu.evoluer(droite);
		assertEquals(90, jeu.getJoueur().getVie());
		
	}
	
	@Test
	public void reMarcheSurPiege() {
		jeu.getJoueur().setPosition(4,8);
		assertEquals(100, jeu.getJoueur().getVie());
		jeu.evoluer(droite);
		assertEquals(90, jeu.getJoueur().getVie());
		jeu.evoluer(droite);
		jeu.evoluer(gauche);
		assertEquals(90, jeu.getJoueur().getVie());
	}
	

	@Test
	//test sur les aleatoire donc on test juste que ca donne pas le meme resultat
	public void prendreTeleporte_CrossCheck() {
		jeu.getJoueur().setPosition(2, 1);
		jeu.evoluer(droite);
		jeuCrosCheck.getJoueur().setPosition(2, 1);
		jeuCrosCheck.evoluer(droite);
		assertNotEquals(new Point(jeu.getJoueur().getX(),jeu.getJoueur().getY())
				, new Point(jeuCrosCheck.getJoueur().getX(),jeuCrosCheck.getJoueur().getY()));
	}
	
	@Test
	public void prendreEtReprendreTeleporte() {
		jeu.getJoueur().setPosition(2, 1);
		jeu.evoluer(droite);
		assertNotEquals(new Point(3,1)
				, new Point(jeu.getJoueur().getX(),jeu.getJoueur().getY()));
		jeu.getJoueur().setPosition(2, 1);
		jeu.evoluer(droite);
		assertEquals(new Point(3,1)
		, new Point(jeu.getJoueur().getX(),jeu.getJoueur().getY()));
		
		
	}	
	@Test
	public void prendreBump_CrossCheck() {
		jeu.getJoueur().setPosition(2, 7);
		jeu.evoluer(droite);
		jeuCrosCheck.getJoueur().setPosition(2, 7);
		jeuCrosCheck.evoluer(droite);
		assertNotEquals(new Point(3,7)
				, new Point(jeu.getJoueur().getX(),jeu.getJoueur().getY()));
		assertNotEquals(new Point(3,7)
				, new Point(jeuCrosCheck.getJoueur().getX(),jeuCrosCheck.getJoueur().getY()));
	}
	
	@Test
	public void reprendreBump() {
		jeu.getJoueur().setPosition(2, 7);
		jeu.evoluer(droite);
		assertNotEquals(new Point(3,7)
				, new Point(jeu.getJoueur().getX(),jeu.getJoueur().getY()));
		jeu.getJoueur().setPosition(2, 7);
		jeu.evoluer(droite);
		assertNotEquals(new Point(3,7)
		, new Point(jeu.getJoueur().getX(),jeu.getJoueur().getY()));
		
		
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
