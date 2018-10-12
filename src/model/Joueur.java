package model;

import engine.Cmd;

public class Joueur extends Entite{
	
	
	protected Cmd commandeEnCours;
	
	protected void update() {
		
		
	}

	public Cmd getCommandeEnCours() {
		return commandeEnCours;
	}

	public void setCommandeEnCours(Cmd c) {
		this.commandeEnCours = c;
	}
	
	
	
}
