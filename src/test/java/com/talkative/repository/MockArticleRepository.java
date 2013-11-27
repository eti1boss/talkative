package com.talkative.repository;

import java.util.ArrayList;

import javax.ejb.Singleton;

import com.talkative.model.Article;

@Singleton
public class MockArticleRepository implements ArticleRepository {
	
	private ArrayList<Article> listArticles = new ArrayList<Article>();
	

	@Override
	public boolean contains(String url){
		for(Article a : listArticles)
			if(a.getUrl().equals(url))
				return true;
		return false;
	}
	
	@Override
	public void addArticle(Article a){
		listArticles.add(a);
	}

	@Override
	public Article get(String url) {
		for(Article a : listArticles)
			if(a.getUrl().equals(url))
				return a;
		return null;
	}

}
