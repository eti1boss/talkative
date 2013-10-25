package com.talkative.model;

import java.util.ArrayList;

public class GestionArticles {
	
	public static ArrayList<Article> listArticles = new ArrayList<Article>();
	
	/**
	 * Recuperation de la liste de commentaire d'un article
	 * @param url
	 * @return null si l'article n'existe pas
	 */
	public ArrayList<Commentaire> getComments(String url, int idInscrit){
		for(Article a : listArticles){
			if(a.getUrl().equals(url) && a.getAuteur().getId() == idInscrit)
				return a.getCommentaires();
		}
		return null;
	}
}
