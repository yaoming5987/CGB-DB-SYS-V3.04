package com.cy.pj.java.cache;

public class SynchronizedCache implements Cache {
  
	private Cache cache;
	
	 public SynchronizedCache(Cache cache) {
		 this.cache=cache;
	 }
	
	@Override
	public  synchronized  void   putObject(Object key, Object value) {
		cache.putObject(key, value);

	}

	@Override
	public synchronized  Object  getObject(Object key) {
		
		return cache.getObject(key);
	}

	@Override
	public synchronized Object removeObject(Object key) {
		
		return cache.removeObject(key);
	}

	@Override
	public synchronized void clear() {
		cache.clear();

	}

	@Override
	public synchronized int size() {
		
		return cache.size();
	}
	@Override
	public String toString() {
		
		return cache.toString();
	}
	
	
	
  public static void main(String[] args) {
	  SynchronizedCache cache = new SynchronizedCache(new perpetualCache());
	  	cache.putObject("a", 100);
		cache.putObject("b", 200);
		cache.putObject("c", 300);
		System.out.println(cache);
}
	

	
}
