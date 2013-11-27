package com.talkative.repository;

import com.talkative.model.Article;

public interface ArticleRepository {

	public boolean contains(String url);
	public Article get(String url);
	public void addArticle(Article a);
	
}
