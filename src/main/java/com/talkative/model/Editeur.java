package com.talkative.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Editeur {

	protected String login;
	protected String password;
	protected String email;
	protected Date dateInscription;
	
	
	/*
	 * Constructeur
	 **************/
	public Editeur(String login, String password, String email, Date dateInscription) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.dateInscription = dateInscription;
	}
		
	public Editeur(String login) {
		this.login = login;
	}

	public Editeur(){
		
	}
	/*
	 * Accesseurs
	 ************/
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

//	@XmlTransient
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(
			this.login); 
	 	return builder.toString();	
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
}

