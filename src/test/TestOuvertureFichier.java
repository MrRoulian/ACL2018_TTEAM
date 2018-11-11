package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.PacmanGame;
import moteurJeu.Commande;

public class TestOuvertureFichier {


	/*
	 * map TEST
	 *  #,#,#,#,#,#,#,#,#,#
	 *  #, , , , , , , , ,#
	 *  #, , , , , , ,T, ,#
	 *  #, , , , , ,#, , ,#
	 *  #, , , , , , , , ,#
	 *  #, , ,#, , , , , ,#
	 *  #, , , , , , , , ,#
	 *  #, , , , , , ,#, ,#
	 *  #, , , , , , , , ,#
	 *  #,#,#,#,#,#,#,#,#,#
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
		
	}

}
