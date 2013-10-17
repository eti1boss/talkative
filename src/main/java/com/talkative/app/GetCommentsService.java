package com.talkative.app;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.talkative.model.Commentaire;
import com.talkative.model.GestionArticles;
import com.talkative.model.GestionInscrits;

@Path("/getComments")
public class GetCommentsService {
	
//	@GET
//    public String getComments() {
//        return "Aucun commentaire pour cet article";
//    }
	
	@GET
	public String getParam(
			@FormParam("idInscrit") String idInscrit,
			@FormParam("urlArticle") String urlArticle
			){

		ArrayList<Commentaire> commentaires = null;
		int testedIdInscrit;
		
		try{
			testedIdInscrit = Integer.parseInt(idInscrit);	
		}
		catch(NumberFormatException e){
			return "Saisie incorrecte";
		}
		
		GestionInscrits gestionInscrits = new GestionInscrits();
		gestionInscrits.load();
		
		GestionArticles gestionArticles = new GestionArticles();
		gestionArticles.load();
		
		/*
		 * Ajouter un contrôle sur le string idInscrit (interger requiered)
		 */
		if (gestionInscrits.exists(Integer.parseInt(idInscrit))){
			commentaires = gestionArticles.getComments(urlArticle, Integer.parseInt(idInscrit));
			if (commentaires == null){
				return "L'article "+ urlArticle + " n'existe pas pour l'auteur " + idInscrit;
			}
			else if (commentaires.size() == 0)
				return "Aucun commentaire trouvé pour l'article " +urlArticle;
			/*
			 * Cas où il y a des commentaires à gérer
			 */
			else
				return "Il y a des commentaires";
			
		}
		else 
			return "Utilisateur inconnu";	
	}

}
