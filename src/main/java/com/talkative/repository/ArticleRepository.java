package com.talkative.repository;

import com.talkative.model.Article;

public interface ArticleRepository {

	public boolean contains(String articleId);
	public void addArticle(Article a);
	
}
