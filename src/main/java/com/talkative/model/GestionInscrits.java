package com.talkative.model;

import java.util.ArrayList;

public class GestionInscrits {

	protected ArrayList<Inscrit> listInscrits = new ArrayList<Inscrit>();
	
	/**
	 * Recuperation de la liste des inscrits
	 * @param id
	 * @return
	 */
	public boolean exists(int id){
		for(Inscrit i : listInscrits)
			if(i.getId() == id)
				return true;
		
		return false;
	}
	
	public void load(){
		Inscrit inscrit1 = new Inscrit(1, null,null,null);
		Inscrit inscrit2 = new Inscrit(2, null,null,null);
		Inscrit inscrit3 = new Inscrit(3, null,null,null);
		listInscrits.add(inscrit1);
		listInscrits.add(inscrit2);
		listInscrits.add(inscrit3);
	}
}
