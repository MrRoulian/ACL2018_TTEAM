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
	
	@Before
	public void initialise() throws CloneNotSupportedException {
		laby=new PacmanGame("helpFilePacman.txt");
		gauche=new Commande();
		gauche.gauche=true;
		droite=new Commande();
		droite.droite=true;
	}
	
	@org.junit.Test
	public void start() {
		Joueur j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 5);
		Assert.assertEquals(j.getY(), 5);
	}
	@org.junit.Test
	public void right() {
		laby.affcihe();
		laby.evoluer(droite);
		laby.affcihe();
		/*j=laby.getJoueur();
		Assert.assertEquals(j.getX(), 6);
		Assert.assertEquals(j.getY(), 5);*/
	}
	

	
	

}
