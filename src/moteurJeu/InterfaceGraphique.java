package moteurJeu;

import javax.swing.JFrame;


/**
 * Cree une interface graphique avec son controleur et son afficheur
 */
public class InterfaceGraphique  {

	/**
	 * Le Panel lie a la JFrame
	 */
	private PanelDessin panel;
	
	/**
	 * Le controleur lie a la JFrame
	 */
	private Controleur controleur;
	/**
	 * son du jeu
	 */
	private music son;
	
	
	
	/**
	 * La construction de l'interface grpahique
	 * - construit la JFrame
	 * - construit les Attributs
	 * 
	 * @param afficheurUtil l'afficheur a utiliser dans le moteur
	 */
	public InterfaceGraphique(DessinJeu afficheurUtil,int x,int y) {
		// Creation JFrame
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creation panel
		this.panel=new PanelDessin(x, y,afficheurUtil);
		f.setContentPane(this.panel);
		
		// Ajout du controleur
		Controleur controlleurGraph=new Controleur();
		this.controleur=controlleurGraph;
		this.panel.addKeyListener(controlleurGraph);	
		
		// Recuperation du focus
		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
		this.son = new music();
		son.start();
	}
	
	
	/**
	 * Retourne le controleur de l'affichage construit
	 * @return
	 */
	public Controleur getControleur() {
		return controleur;
	}

	/**
	 * Demande la mise a jour du dessin
	 */
	public void dessiner() {
		this.panel.dessinerJeu();	
	}


	public PanelDessin getPanel() {
		return panel;
	}
	

	
}
