package com.talkative.model;

import java.net.URL;
import java.util.ArrayList;
//import java.util.Date;


/**
 * Cette classe represente l'article commente sur Talkative
 * @author ttr
 *
 */
public class Article {
	protected Integer id;
	protected String titre;
	protected URL url;
	protected ArrayList<Commentaire> commentaires;
	
	/*
	 * Constructeurs
	 * *************/
	
	/**
	 * Tous les parametres sauf id
	 * @param titre
	 * @param url
	 * @param categories
	 * @param dateCreation A voir si on conserve cette date
	 * @param commentaires
	 */
	public Article(String titre, URL url,
			ArrayList<Commentaire> commentaires) {
		super();
		this.titre = titre;
		this.url = url;
		this.commentaires = commentaires;
	}
	
	/**
	 * A utiliser seulement pour creer des objets depuis la DAO (parametre id)
	 * @param id 
	 * @param titre
	 * @param url
	 * @param categories
	 * @param dateCreation IDEM
	 * @param commentaires
	 */
	public Article(Integer id, String titre, URL url,
			ArrayList<Commentaire> commentaires) {
		super();
		this.id = id;
		this.titre = titre;
		this.url = url;
		this.commentaires = commentaires;
	}


	/**
	 * Pour forcer la creation a partir d'un commentaire
	 * @param titre
	 * @param url
	 * @param categories
	 * @param dateCreation IDEM
	 * @param commentaire
	 */
	public Article(String titre, URL url,
			Commentaire commentaire) {
		super();
		this.titre = titre;
		this.url = url;
		commentaires = new ArrayList<Commentaire>();
		this.ajouterCommentaire(commentaire);
	}

	
	
	/*
	 * Methodes
	 **********/
	
	/**
	 * Ajoute un commentaire a la liste.
	 * Prerequis : la liste de commentaires a ete initialisee. 
	 * @param commentaire
	 */
	public void ajouterCommentaire(Commentaire commentaire) {
		commentaires.add(commentaire);		
	}
	
	/*
	 * A definir
	 */
	public void supprimerCommentaire(){
		throw new RuntimeException("Ecrire la methode avant de l'utiliser!!!");
	}
	
	/*
	 * A definir
	 */
	public void modifierCommentaire(){
		throw new RuntimeException("Ecrire la methode avant de l'utiliser!!!");
	}
	
	/*
	 * Accesseurs
	 * **********/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	public ArrayList<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(ArrayList<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(
			this.titre+"\n"+  //titre
			this.url.toString()+"\n");  //url
	 	//ajout de chaque commentaire
	 	for(Commentaire com : commentaires)  
	 		builder.append(com.toString()+"\t");
	 	return builder.toString();			
	}
	
}