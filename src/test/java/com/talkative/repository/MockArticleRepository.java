package com.talkative.repository;

import java.util.ArrayList;

import javax.ejb.Singleton;

import com.talkative.model.Article;

@Singleton
public class MockArticleRepository implements ArticleRepository {
	
	private ArrayList<Article> listArticles = new ArrayList<Article>();
	
	/**
	 * Recuperation de la liste des articles
	 * @param id
	 * @return
	 */
	@Override
	public boolean contains(String id){
		for(Article a : listArticles)
			if(a.getUrl().equals(id))
				return true;
		return false;
	}
	
	@Override
	public void addArticle(Article a){
		listArticles.add(a);
	}

}
