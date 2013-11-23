package com.talkative.resource;

import javax.naming.NamingException;
import javax.ws.rs.Path;

import com.talkative.repository.ArticleRepository;


public class EditorResource {
	
	private ArticleRepository articleRepository;
	
	
	public EditorResource(ArticleRepository articleRepository) {
		super();
		this.articleRepository = articleRepository;
	}

	@Path("articles")
	public ArticlesResource getArticlesResource() throws NamingException {
		return new ArticlesResource(articleRepository);
	}
}