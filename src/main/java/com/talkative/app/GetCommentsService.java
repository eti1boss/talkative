package com.talkative.app;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/getComments")
public class GetCommentsService {
	
	@GET
    public String getComments() {
        return "Aucun commentaire pour cet article";
    }
	
	@POST
	public String getParam(String name){
		return name;
	}

}
