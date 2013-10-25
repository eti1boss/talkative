package com.talkative.app;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.talkative.model.Commentaire;
import com.talkative.model.GestionArticles;
import com.talkative.model.GestionInscrits;

@Path("/getComments/{idInscrit}/{idArticle}")
public class GetCommentsService {
	
	@GET
	public String getComments(
			@PathParam("idInscrit") String idInscrit,
			@PathParam("idArticle") String idArticle){
		int testedIdInscrit = Integer.MIN_VALUE;
		try{
			testedIdInscrit = Integer.parseInt(idInscrit);
		}catch(NumberFormatException e){
			return "Parametres invalides";
		}
		if(!new GestionInscrits().exists(testedIdInscrit))
			return "Editeur inconnu";
		ArrayList<Commentaire> commentaires = new GestionArticles().getComments(idArticle, testedIdInscrit);
		if(commentaires == null)
			return "Article inconnu";
		if(commentaires.size() == 0)
			return "Aucun commentaire pour cet article";
		return "toto";
	}

}
