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
	public void start_R() {
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void mouvementnull_B() throws Exception {
			jeu.evoluer(null);
	}
	
	@Test
	public void droite_R() {
		jeu.evoluer(droite);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 6);
		assertEquals(j.getY(), 5);
	}
	
	@Test
	public void droiteCollisionMur_B() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(droite);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 13);
		assertEquals(j.getY(), 5);
	}
	
	@Test
	public void gauche_R() {
		jeu.evoluer(gauche);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 4);
		assertEquals(j.getY(), 5);
	}
	
	@Test
	public void gaucheCollisionMur_B() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(gauche);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 1);
		assertEquals(j.getY(), 5);
	}
	
	@Test
	public void haut_R() {
		jeu.evoluer(haut);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 4);
	}
	
	@Test
	public void hautCollisionMur_B() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(haut);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 1);
	}
	
	@Test
	public void bas_R() {
		jeu.evoluer(bas);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 6);
	}
	
	@Test
	public void basCollisionMur_B() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(bas);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 13);
	}
	
	@Test
	public void hautbas_R() {
		jeu.evoluer(hautbas);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 5);
	}
	
	@Test
	public void gauchedroite_R() {
		jeu.evoluer(gauchedroite);
		Joueur j=jeu.getJoueur();
		Assert.assertEquals(j.getX(), 5);
		Assert.assertEquals(j.getY(), 5);
	}
	
	//idem pour le haut droite
	@Test
	public void hautgauche_R() {
		jeu.evoluer(hautgauche);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 4);
		assertEquals(j.getY(), 4);
	}
	
	@Test
	public void hautgaucheCollisionMur_B() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(hautgauche);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 1);
		assertEquals(j.getY(), 1);
	}
	
	//idem pour le bas droite
	@Test
	public void basgauche_R() {
		jeu.evoluer(basgauche);
		Joueur j=jeu.getJoueur();
		Assert.assertEquals(j.getX(), 4);
		Assert.assertEquals(j.getY(), 6);
	}
	
	@Test
	public void basgaucheCollisionMur_B() {
		for(int i=0;i<20;i++) {
			jeu.evoluer(basgauche);
		}
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 1);
		assertEquals(j.getY(), 13);
	}
	
	
	//idem pour le basgauchedroit gauchehautdroite basdroitehaut
	@Test
	public void basgauchehaut_R() {
		jeu.evoluer(basgauchehaut);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 4);
		assertEquals(j.getY(), 5);
	}

	@Test
	public void basgauchehautdroite_R() {
		jeu.evoluer(basgauchehautdroite);
		Joueur j=jeu.getJoueur();
		assertEquals(j.getX(), 5);
		assertEquals(j.getY(), 5);
	}
	
	//idem selon la direction
	@Test
	public void Deplacement_CrossC() {
		jeu.evoluer(basgauchehaut);
		Joueur j=jeu.getJoueur();
		
		jeuCrosCheck.evoluer(basgauchehaut);
		Joueur j2=jeuCrosCheck.getJoueur();
		
		assertEquals(j.getX(), j2.getX());
		assertEquals(j.getY(), j2.getY());
		
	}
	
	
	@Test
	public void Collision_CrossC() {
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
