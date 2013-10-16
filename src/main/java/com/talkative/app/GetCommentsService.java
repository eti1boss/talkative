package com.talkative.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/getComments")
public class GetCommentsService {
	
	@GET
    public String getComments() {
        return "Aucun commentaire pour cet article";
    }

}
