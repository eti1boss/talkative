package com.talkative.resource;

import javax.ejb.EJB;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.talkative.repository.ArticleRepository;
import com.talkative.repository.EditorRepository;

@Path("editors")
public class EditorsResource {

	@EJB
	private EditorRepository editorRepository;
	@EJB
	private ArticleRepository articleRepository;
	
	@Path("{editor}")
	public EditorResource getEditor(@PathParam("editor") String editorId) {
		if (!editorRepository.contains(editorId)) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
		return new EditorResource(articleRepository);
	}
	
	@PUT
	@Path("{editor}")
	public EditorResource addEditor(@PathParam("editor") String editorId) {
		if (!editorRepository.contains(editorId)) {
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		return new EditorResource(articleRepository);
	}
}
