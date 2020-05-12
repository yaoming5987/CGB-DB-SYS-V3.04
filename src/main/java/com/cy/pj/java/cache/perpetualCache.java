package com.cy.pj.java.cache;

import java.util.HashMap;
import java.util.Map;


//最大-Xmx5m
public class perpetualCache implements Cache {


	private Map<Object,Object> cache = new HashMap<>();
	@Override
	public void putObject(Object key, Object value) {
		cache.put(key,value);
	}

	@Override
	public Object getObject(Object key) {

		return cache.get(key);
	}

	@Override
	public Object removeObject(Object key) {

		return cache.remove(key);
	}

	@Override
	public void clear() {
		cache.clear();
	}

	@Override
	public int size() {
		return cache.size();
	}
	@Override
	public String toString() { 
		
		return cache.toString();
	}
	public static void main(String[] args) {
		Cache cache = new perpetualCache();
		cache.putObject("a", 100);
		cache.putObject("b", 200);
		cache.putObject("c", 300);
		cache.putObject("f", new byte[1024*1024]);
		cache.putObject("g", new byte[1024*1024]);
		cache.putObject("h", new byte[1024*1024]);
		cache.putObject("i", new byte[1024*1024]);
		System.out.println(cache);
		cache.removeObject("d");
		
		cache.clear();
		System.out.println(cache.size());
	}
}
