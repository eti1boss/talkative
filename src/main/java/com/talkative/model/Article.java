package com.talkative.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="article")
public class Article {
	protected String titre;
	protected String url;

	protected ArrayList<AbstractCommentaire> commentaires;
	protected Editeur auteur;
	
	/*
	 * Constructeurs
	 * *************/
	public Article(String titre, String url, Editeur auteur) {
		super();
		this.titre = titre;
		this.url = url;
		this.auteur = auteur;
		commentaires = new ArrayList<AbstractCommentaire>();
	}
	
	public Article(){
	}
	/*
	 * Methodes
	 **********/
	
	/**
	 * Ajoute un commentaire a la liste.
	 * Prerequis : la liste de commentaires a ete initialisee. 
	 * @param commentaire
	 */
	public void ajouterCommentaire(AbstractCommentaire commentaire) {
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
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ArrayList<AbstractCommentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(ArrayList<AbstractCommentaire> commentaires) {
		this.commentaires = commentaires;
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
			this.titre+"\n"+  //titre
			this.url.toString()+"\n");  //url
	 	//ajout de chaque commentaire
	 	for(AbstractCommentaire com : commentaires)  
	 		builder.append(com.toString()+"\t");
	 	return builder.toString();			
	}


	
}