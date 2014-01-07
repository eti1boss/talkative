package com.talkative.model;

import java.util.Date;

public interface ICommentaire {

	public abstract String getContenu();

	public abstract void setContenu(String contenu);

	public abstract String getPseudo();

	public abstract void setPseudo(String pseudo);

	public abstract Date getDateCreation();

	public abstract void setDateCreation(Date dateCreation);

}