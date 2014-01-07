package com.talkative.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class AbstractCommentaire implements ICommentaire {
	
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
	
	/* (non-Javadoc)
	 * @see com.talkative.model.ICommentaire#getContenu()
	 */
	@Override
	public String getContenu() {
		return contenu;
	}
	/* (non-Javadoc)
	 * @see com.talkative.model.ICommentaire#setContenu(java.lang.String)
	 */
	@Override
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/* (non-Javadoc)
	 * @see com.talkative.model.ICommentaire#getPseudo()
	 */
	@Override
	public String getPseudo() {
		return pseudo;
	}
	/* (non-Javadoc)
	 * @see com.talkative.model.ICommentaire#setPseudo(java.lang.String)
	 */
	@Override
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	/* (non-Javadoc)
	 * @see com.talkative.model.ICommentaire#getDateCreation()
	 */
	@Override
	public Date getDateCreation() {
		return dateCreation;
	}
	/* (non-Javadoc)
	 * @see com.talkative.model.ICommentaire#setDateCreation(java.util.Date)
	 */
	@Override
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
}
