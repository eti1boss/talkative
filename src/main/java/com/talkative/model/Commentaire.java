package com.talkative.model;

import java.util.Date;

/**
 * Cette classe represente les commentaires laisses par les inscrits
 * @author ttr
 *
 */
public class Commentaire {
	
	protected Integer id;
	protected String contenu;
	protected Inscrit auteur;
	protected Date dateCreation;
	
	
	/*
	 * Constructeur
	 * ************/
	
	/**
	 * Constructeur complet (sauf id). 
	 * @param contenu
	 * @param auteur
	 * @param dateCreation
	 */
	public Commentaire(String contenu, Inscrit auteur, Date dateCreation) {
		super();
		this.contenu = contenu;
		this.auteur = auteur;
		this.dateCreation = dateCreation;
	}
	
	/**
	 * Constructeur complet. 
	 * @param id
	 * @param contenu
	 * @param auteur
	 * @param dateCreation
	 */
	public Commentaire(Integer id, String contenu, Inscrit auteur, Date dateCreation) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.auteur = auteur;
		this.dateCreation = dateCreation;
	}

	/*
	 * Accesseurs
	 ************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Inscrit getAuteur() {
		return auteur;
	}
	public void setAuteur(Inscrit auteur) {
		this.auteur = auteur;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(
			this.auteur.getLogin()+"\n"+  
			this.contenu+"\n"+  
			this.dateCreation.getTime());
	 	return builder.toString();			
	}
	
}