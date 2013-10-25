package com.talkative.model;

import java.util.ArrayList;

public class GestionInscrits {

	public static ArrayList<Inscrit> listInscrits = new ArrayList<Inscrit>();
	
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
	
}
