package com.talkative.repository;

import com.talkative.model.Editeur;

public interface EditorRepository {

	public boolean contains(String editorId);
	public void addEditor(Editeur i);
	
}
