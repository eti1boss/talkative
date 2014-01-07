package com.talkative.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="commentaire")
public class CommentaireGuest extends AbstractCommentaire{
	
	protected String guestEmail;
	
	/*
	 * Constructeurs
	 * ************/
	public CommentaireGuest(){
		
	}

	public CommentaireGuest(String contenu, String pseudo, String guestEmail, Date dateCreation) {
		super(contenu, pseudo, dateCreation);
		this.guestEmail = guestEmail;
	}

	
	/*
	 * Accesseurs
	 ************/


}