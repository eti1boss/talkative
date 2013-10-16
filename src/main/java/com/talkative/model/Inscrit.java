package com.talkative.model;

public class Inscrit {
	/**
	 * Classe representant un inscrit standard. Attention pour le password
	 * !!!!!!
	 * !!!!!!A AMELIORER : IMPLEMENTER UNE FONCTION DE HACHAGE POUR LE PASS
	 * !!!!!!
	 * @author ttr
	 *
	 */
		
	protected Integer id;
	protected String login, pass, email;
	
	
	/*
	 * Constructeur
	 **************/
	
	/**
	 * Constructeur complet (sans id). A utiliser pour l'insertion en base.
	 * @param login
	 * @param pass
	 * @param email
	 */
	public Inscrit(String login, String pass, String email) {
		super();
		this.login = login;
		this.pass = pass;
		this.email = email;
	}
	
	/**
	 * Constructeur complet (avec id). A utiliser par la DAO.
	 * @param id
	 * @param login
	 * @param pass
	 * @param email
	 */
	public Inscrit(Integer id,String login, String pass, String email) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
		this.email = email;
	}

	/*
	 * Accesseurs
	 ************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * CLASSE DANGEREUSE
	 * @deprecated
	 */
	public String getPass() {
		return pass;
	}
	
	/**
	 * CLASSE DANGEREUSE
	 * @deprecated
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * CETTE METHODE AFFICHE LE PASS
	 * @deprecated
	 */
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(
			this.login+"\n"+ 
			this.email+"\n"+  
			this.pass); 
	 	return builder.toString();	
	}
}

