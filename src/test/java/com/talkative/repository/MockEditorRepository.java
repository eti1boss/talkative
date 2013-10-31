package com.talkative.repository;

import java.util.ArrayList;

import javax.ejb.Singleton;

import com.talkative.model.Inscrit;

@Singleton
public class MockEditorRepository implements EditorRepository {
	
	private ArrayList<Inscrit> listEditors = new ArrayList<Inscrit>();
	
	/**
	 * Recuperation de la liste des inscrits
	 * @param id
	 * @return
	 */
	@Override
	public boolean contains(String id){
		for(Inscrit i : listEditors)
			if(i.getId() == Integer.parseInt(id))
				return true;
		
		return false;
	}
	
	public void addEditor(Inscrit i){
		listEditors.add(i);
	}
}
