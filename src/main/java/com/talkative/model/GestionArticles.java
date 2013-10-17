package com.talkative.model;

import java.net.URL;
import java.util.ArrayList;

public class GestionArticles {
	
	protected ArrayList<Article> listArticles = new ArrayList<Article>();
	
	/**
	 * Recuperation de la liste de commentaire d'un article
	 * @param url
	 * @return null si l'article n'existe pas
	 */
	public ArrayList<Commentaire> getComments(String url){
		for(Article a : listArticles){
			if(a.getUrl().equals(url))
				return a.getCommentaires();
		}
		return null;
	}
	
	public void load(){
		Article article1 = new Article("article1", "url1", new ArrayList<Commentaire>());
		Article article2 = new Article("article2", "url2", new ArrayList<Commentaire>());
		listArticles.add(article1);
		listArticles.add(article2);
	}
}
