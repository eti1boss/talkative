package com.talkative.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.talkative.model.Article;
import com.talkative.model.CommentaireGuest;
import com.talkative.repository.ArticleRepository;
public class ArticlesResource {
	

	private ArticleRepository articleRepository;
	public ArticlesResource(ArticleRepository articleRepository) {
		super();
		this.articleRepository = articleRepository;
	}
		
	@GET
	@Path("{article: .*}/comments")
	@Produces({"application/xml", "application/json"})
	public Response comments(@PathParam("article") @Encoded String article) {
		Article a = articleRepository.get(article);
		if(a == null)
			return Response.status(404).build();
		else if (a.getCommentaires().size() == 0)
			return Response.noContent().header("Link", "http://" + article + "; rel=\"article\"").build();
		else
			return Response.ok().entity(a).build();
	}
	
	@POST
	@Path("{article: .*}/comments")
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/xml", "application/json"})
	public Response newComments(@PathParam("article") @Encoded String article, CommentaireGuest comment) {
		Article a = articleRepository.get(article);
		System.out.println(comment.getContenu());
		if(a == null)
			return Response.status(404).build();
		else{
			a.ajouterCommentaire(comment);
			return Response.ok().entity(a).build();
		}
	}
}