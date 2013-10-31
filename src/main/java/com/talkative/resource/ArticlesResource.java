package com.talkative.resource;

import javax.ejb.EJB;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.talkative.repository.ArticleRepository;

public class ArticlesResource {

	@EJB
	private ArticleRepository articleRepository;
		
	@GET
	@Path("{article: .*}/comments")
	public Response getComments(@PathParam("article") @Encoded String article) {
		if(articleRepository.contains(article))
			return Response.noContent().header("Link", "http://" + article + "; rel=\"article\"").build();
		return Response.status(404).build(); 
	}
}