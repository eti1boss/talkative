package com.talkative.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class AbstractCommentaire {
	
	protected String contenu;
	
	protected String pseudo;
	
	protected Date dateCreation;
	
	public AbstractCommentaire(){
	}
	
	public AbstractCommentaire(String contenu, String pseudo, Date dateCreation) {
		super();
		this.contenu = contenu;
		this.pseudo = pseudo;
		this.dateCreation = dateCreation;
	}
	
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
}
