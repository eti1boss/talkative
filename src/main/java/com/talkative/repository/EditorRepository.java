package com.talkative.repository;

import com.talkative.model.Inscrit;

public interface EditorRepository {

	public boolean contains(String editorId);
	public void addEditor(Inscrit i);
	
}
