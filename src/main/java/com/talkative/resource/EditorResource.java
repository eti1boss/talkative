package com.talkative.resource;

import javax.ws.rs.Path;


public class EditorResource {
	@Path("articles")
	public String getArticlesResource() {
		return "coucou";
	}
}