package moteurJeu;

/**
 * Permet de representer une commande de l'utilisateur
 */
public class Commande {

	/**
	 * Boolean representant la commande de l'utilisateur
	 */
	public boolean gauche;
	public boolean droite;
	public boolean haut;
	public boolean bas;
	public boolean attaque;
	
	public Commande() {
		
	}
	
	/**
	 * Constructeur par copie
	 * copie la commande pour en creer une nouvelle
	 * @param commandeACopier
	 */
	public Commande(Commande commandeACopier) {
		this.bas=commandeACopier.bas;
		this.haut=commandeACopier.haut;
		this.gauche=commandeACopier.gauche;
		this.droite=commandeACopier.droite;
		this.attaque=commandeACopier.attaque;		
	}
	
}
