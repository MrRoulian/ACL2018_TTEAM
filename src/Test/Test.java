package Test;

import org.junit.Before;
import org.junit.Assert;

import model.Joueur;
import model.PacmanGame;
import moteurJeu.Commande;

public class Test {

	private PacmanGame laby;
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
		laby=new PacmanGame("helpFilePacman.txt");
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
	
	@org.junit.Test
	public void start() {
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 5);
		Assert.assertEquals(j.getY(), 5);
	}
	
	@org.junit.Test(expected = NullPointerException.class)
	public void mouvementnull() throws Exception {
			laby.evoluer(null);
			Joueur j=laby.getJoueur();
			Assert.assertEquals(j.getX(), 6);
			Assert.assertEquals(j.getY(), 5);
	}
	
	@org.junit.Test
	public void droite() {
		laby.evoluer(droite);
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 6);
		Assert.assertEquals(j.getY(), 5);
	}
	
	@org.junit.Test
	public void droiteCollisionMur() {
		for(int i=0;i<20;i++) {
		laby.evoluer(droite);
		}
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 13);
		Assert.assertEquals(j.getY(), 5);
	}
	
	@org.junit.Test
	public void gauche() {
		laby.evoluer(gauche);
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 4);
		Assert.assertEquals(j.getY(), 5);
	}
	
	@org.junit.Test
	public void gaucheCollisionMur() {
		for(int i=0;i<20;i++) {
		laby.evoluer(gauche);
		}
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 1);
		Assert.assertEquals(j.getY(), 5);
	}
	
	@org.junit.Test
	public void haut() {
		laby.evoluer(haut);
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 5);
		Assert.assertEquals(j.getY(), 4);
	}
	
	@org.junit.Test
	public void hautCollisionMur() {
		for(int i=0;i<20;i++) {
		laby.evoluer(haut);
		}
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 5);
		Assert.assertEquals(j.getY(), 1);
	}
	
	@org.junit.Test
	public void bas() {
		laby.evoluer(bas);
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 5);
		Assert.assertEquals(j.getY(), 6);
	}
	
	@org.junit.Test
	public void basCollisionMur() {
		for(int i=0;i<20;i++) {
		laby.evoluer(bas);
		}
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 5);
		Assert.assertEquals(j.getY(), 13);
	}
	
	@org.junit.Test
	public void hautbas() {
		laby.evoluer(hautbas);
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 5);
		Assert.assertEquals(j.getY(), 5);
	}
	
	@org.junit.Test
	public void gauchedroite() {
		laby.evoluer(gauchedroite);
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 5);
		Assert.assertEquals(j.getY(), 5);
	}
	
	//idem pour le haut droite
	@org.junit.Test
	public void hautgauche() {
		laby.evoluer(hautgauche);
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 4);
		Assert.assertEquals(j.getY(), 4);
	}
	
	@org.junit.Test
	public void hautgaucheCollisionMur() {
		for(int i=0;i<20;i++) {
		laby.evoluer(hautgauche);
		}
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 1);
		Assert.assertEquals(j.getY(), 1);
	}
	
	//idem pour le bas droite
	@org.junit.Test
	public void basgauche() {
		laby.evoluer(basgauche);
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 4);
		Assert.assertEquals(j.getY(), 6);
	}
	
	@org.junit.Test
	public void basgaucheCollisionMur() {
		for(int i=0;i<20;i++) {
		laby.evoluer(basgauche);
		}
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 1);
		Assert.assertEquals(j.getY(), 13);
	}
	
	
	//idem pour le basgauchedroit gauchehautdroite basdroitehaut
	@org.junit.Test
	public void basgauchehaut() {
		laby.evoluer(basgauchehaut);
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 4);
		Assert.assertEquals(j.getY(), 5);
	}

	@org.junit.Test
	public void basgauchehautdroite() {
		laby.evoluer(basgauchehautdroite);
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 5);
		Assert.assertEquals(j.getY(), 5);
	}


}
