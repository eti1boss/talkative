package com.talkative.repository;

import java.util.ArrayList;

import javax.ejb.Singleton;

import com.talkative.model.Editeur;

@Singleton
public class MockEditorRepository implements EditorRepository {
	
	private ArrayList<Editeur> listEditors = new ArrayList<Editeur>();
	
	/**
	 * Recuperation de la liste des inscrits
	 * @param id
	 * @return
	 */
	@Override
	public boolean contains(String id){
		for(Editeur i : listEditors)
			if(i.getLogin().equals(id))
				return true;
		return false;
	}
	
	public void addEditor(Editeur i){
		listEditors.add(i);
	}
}
