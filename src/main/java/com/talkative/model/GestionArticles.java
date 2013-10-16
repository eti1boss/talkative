package com.talkative.model;

import java.util.ArrayList;

public class GestionArticles {
	
	protected ArrayList<Article> listArticles;
	
	/**
	 * Recuperation de la liste de commentaire d'un article
	 * @param titre
	 * @return null si l'article n'existe pas
	 */
	public Commentaire[] getComments(String url){
		for(Article a : listArticles){
			if(a.getUrl().equals(url))
				return (Commentaire[]) a.getCommentaires().toArray();
		}
		return null;
	}
}
