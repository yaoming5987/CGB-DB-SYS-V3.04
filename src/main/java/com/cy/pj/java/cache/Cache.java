package com.cy.pj.java.cache;

public interface Cache {
	
	public void putObject(Object key,Object value);
	public  Object getObject(Object key);
	public  Object removeObject(Object key);
	public  void  clear();
	public int size();
	
}
