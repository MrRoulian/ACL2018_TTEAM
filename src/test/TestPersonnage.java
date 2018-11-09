package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Joueur;
import model.PacmanGame;
import moteurJeu.Commande;

public class TestPersonnage {

	private PacmanGame jeu;
	private PacmanGame jeuCrosCheck;
	private Commande gauche;
	private Commande droite;
	private Commande haut;
	private Commande bas;
	private Commande hautbas;
	private Commande gauchedroite;
	private Commande hautgauche;
	private Commande basgauche;
	private Commande basgauchehaut;
	private Commande basgauchehautdroite;
	
	@Before
	public void initialise() throws CloneNotSupportedException {
		jeu=new PacmanGame("helpFilePacman.txt");
		jeuCrosCheck=new PacmanGame("helpFilePacman.txt");
		gauche=new Commande();
		gauche.gauche=true;
		droite=new Commande();
		droite.droite=true;
		haut=new Commande();
		haut.haut=true;
		bas=new Commande();
		bas.bas=true;
		hautbas=new Commande();
		hautbas.bas=true;
		hautbas.haut=true;
		gauchedroite=new Commande();
		gauchedroite.droite=true;
		gauchedroite.gauche=true;
		hautgauche=new Commande();
		hautgauche.haut=true;
		hautgauche.gauche=true;
		basgauche=new Commande();
		basgauche.bas=true;
		basgauche.gauche=true;
		basgauchehaut=new Commande();
		basgauchehaut.bas=true;
		basgauchehaut.haut=true;
		basgauchehaut.gauche=true;
		basgauchehautdroite=new Commande();
		basgauchehautdroite.droite=true;
		basgauchehautdroite.gauche=true;
		basgauchehautdroite.haut=true;
		basgauchehautdroite.bas=true;
		
	}
	
	@Test
	public void start() {
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void mouvementnull() throws Exception {
			jeu.evoluer(null);
	}
	
	@Test
	public void droite() {
		jeu.evoluer(droite);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 6);
		assertEquals(j.getY(), 5);
	}
	
	@Test
	public void droiteCollisionMur() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(droite);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 13);
		assertEquals(j.getY(), 5);
	}
	
	@Test
	public void gauche() {
		jeu.evoluer(gauche);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 4);
		assertEquals(j.getY(), 5);
	}
	
	@Test
	public void gaucheCollisionMur() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(gauche);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 1);
		assertEquals(j.getY(), 5);
	}
	
	@Test
	public void haut() {
		jeu.evoluer(haut);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 4);
	}
	
	@Test
	public void hautCollisionMur() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(haut);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 1);
	}
	
	@Test
	public void bas() {
		jeu.evoluer(bas);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 6);
	}
	
	@Test
	public void basCollisionMur() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(bas);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 13);
	}
	
	@Test
	public void hautbas() {
		jeu.evoluer(hautbas);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 5);
	}
	
	@Test
	public void gauchedroite() {
		jeu.evoluer(gauchedroite);
		Joueur j=jeu.getJoueur();
		Assert.assertEquals(j.getX(), 5);
		Assert.assertEquals(j.getY(), 5);
	}
	
	//idem pour le haut droite
	@Test
	public void hautgauche() {
		jeu.evoluer(hautgauche);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 4);
		assertEquals(j.getY(), 4);
	}
	
	@Test
	public void hautgaucheCollisionMur() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(hautgauche);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 1);
		assertEquals(j.getY(), 1);
	}
	
	//idem pour le bas droite
	@Test
	public void basgauche() {
		jeu.evoluer(basgauche);
		Joueur j=jeu.getJoueur();
		Assert.assertEquals(j.getX(), 4);
		Assert.assertEquals(j.getY(), 6);
	}
	
	@Test
	public void basgaucheCollisionMur() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(basgauche);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 1);
		assertEquals(j.getY(), 13);
	}
	
	
	//idem pour le basgauchedroit gauchehautdroite basdroitehaut
	@Test
	public void basgauchehaut() {
		jeu.evoluer(basgauchehaut);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 4);
		assertEquals(j.getY(), 5);
	}

	@Test
	public void basgauchehautdroite() {
		jeu.evoluer(basgauchehautdroite);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 5);
	}
	
	//idem selon la direction
	@Test
	public void crossCheckDeplacement() {
		jeu.evoluer(basgauchehaut);
		Joueur j=jeu.getJoueur();
		
		jeuCrosCheck.evoluer(basgauchehaut);
		Joueur j2=jeuCrosCheck.getJoueur();
		
		assertEquals(j.getX(), j2.getX());
		assertEquals(j.getY(), j2.getY());
		
		
	}
	
	
	@Test
	public void crossCheckCollision() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(bas);
			jeuCrosCheck.evoluer(bas);
		}
		Joueur j=jeu.getJoueur();
		Joueur j2=jeuCrosCheck.getJoueur();
		assertEquals(j.getX(), j2.getX());
		assertEquals(j.getY(), j2.getY());
	}



}
