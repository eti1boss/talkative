package com.talkative.app;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/getComments")
public class GetCommentsService {
	
//	@GET
//    public String getComments() {
//        return "Aucun commentaire pour cet article";
//    }
	
	@GET
	public String getParam(
			@FormParam("test") String test,
			@FormParam("test2") String test2
			){
		return test+":"+test2;
	}

}
