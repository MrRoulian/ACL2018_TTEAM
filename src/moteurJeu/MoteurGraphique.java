package moteurJeu;

/**
 * Classe MoteurGraphique represente un moteur de jeu generique.
 * 
 * On lui passe un jeu et un afficheur et il permet d'executer un jeu.
 */
public class MoteurGraphique {

	/**
	 * Le jeu a executer
	 */
	private Game jeu;

	/**
	 * L'interface graphique
	 */
	private InterfaceGraphique gui;

	/**
	 * L'afficheur a utiliser pour le rendu
	 */
	private DessinJeu dessin;

	/**
	 * Construit un moteur
	 * 
	 * @param pJeu
	 *            jeu a lancer
	 * @param pAffiche
	 *            afficheur a utiliser
	 */
	public MoteurGraphique(Game pJeu, DessinJeu pAffiche) {
		// Creation du jeu
		this.jeu = pJeu;
		this.dessin = pAffiche;
	}

	/**
	 * Permet de lancer le jeu
	 */
	public void lancerJeu(int width, int height) throws InterruptedException {

		// Creation de l'interface graphique
		this.gui = new InterfaceGraphique(this.dessin,width,height);
		Controleur controle = this.gui.getControleur();

		// Boucle de jeu
		while (!this.jeu.etreFini()) {
			// Demande controle utilisateur
			Commande c = controle.getCommande();
			// Fait evoluer le jeu
			this.jeu.evoluer(c);
			// Affiche le jeu
			this.gui.dessiner();
			// Met en attente
			Thread.sleep(100);
		}
	}

}
