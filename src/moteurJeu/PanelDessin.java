package moteurJeu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelDessin extends JPanel {

	/**
	 * La clase chargee de Dessiner
	 */
	private DessinJeu dessin;

	/**
	 * Image suivante est l'image cachee sur laquelle dessiner
	 */
	private BufferedImage imageSuivante;

	/**
	 * Image en cours est l'image entrain d'etre affichee
	 */
	private BufferedImage imageEnCours;

	/**
	 * la taille des images
	 */
	private static int width, height;

	/**
	 * Constructeur Il construit les images pour doublebuffering ainsi que le Panel associe. 
	 * Les images stockent le dessin et on demande au panel la mise a jour quand le dessin est fini
	 * 
	 * @param width
	 *            largeur de l'image
	 * @param height
	 *            hauteur de l'image
	 */
	public PanelDessin(int x, int y, DessinJeu affiche) {
		super();
		this.setPreferredSize(new Dimension(x, y));
		width = x;
		height = y;
		this.dessin=affiche;

		// Cree l'image buffer et son graphics
		this.imageSuivante = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		this.imageEnCours = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
	}

	/**
	 * Demande de mettre a jour le rendu de l'image sur le Panel. 
	 * Creer une nouvelle image vide sur laquelle dessiner
	 */
	public void dessinerJeu() {
		// Generer la nouvelle image
		this.dessin.dessiner(this.imageSuivante);

		// Inverses les images doublebuffereing
		BufferedImage temp = this.imageEnCours;
		// L'image a dessiner est celle qu'on a construite
		this.imageEnCours = this.imageSuivante;
		// L'ancienne image est videe
		this.imageSuivante = temp;
		this.imageSuivante.getGraphics()
				.fillRect(0, 0, width, height);
		// Met a jour l'image a afficher sur le panel
		this.repaint();
	}

	/**
	 * Redefinit la methode paint consiste a dessiner l'image en cours
	 * 
	 * @param g
	 *            graphics pour dessiner
	 */
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(this.imageEnCours, 0, 0, getWidth(), getHeight(), 0, 0,
				getWidth(), getHeight(), null);
		height = this.getHeight();
		width = this.getWidth();
	}
	
	/**
	 * Getteur de la largeur de la fenetre 
	 * @return width Largeur de la fenetre
	 */
	public static int getWindowsWidth() {
		return width;
	}


	/**
	 * Getteur de la hauteur de la fenetre 
	 * @return width Hauteur de la fenetre
	 */
	public static int getWindowsHeight() {
		return height;
	}
}
