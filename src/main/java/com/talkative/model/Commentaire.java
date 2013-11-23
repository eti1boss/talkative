package com.talkative.model;

public class Commentaire {
	
	protected String contenu;
	protected Editeur auteur;
	
	
	/*
	 * Constructeurs
	 * ************/
	public Commentaire(){
		
	}

	public Commentaire(String contenu, Editeur auteur) {
		super();
		this.contenu = contenu;
		this.auteur = auteur;
	}

	/*
	 * Accesseurs
	 ************/
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Editeur getAuteur() {
		return auteur;
	}
	public void setAuteur(Editeur auteur) {
		this.auteur = auteur;
	}

	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(
			this.auteur.getLogin()+"\n"+  
			this.contenu+"\n");
	 	return builder.toString();			
	}
	
}