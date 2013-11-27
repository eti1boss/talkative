package com.talkative.model;

public class Editeur {

	protected String login;
	
	
	/*
	 * Constructeur
	 **************/
	public Editeur(String login) {
		super();
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
	
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(
			this.login); 
	 	return builder.toString();	
	}
}

