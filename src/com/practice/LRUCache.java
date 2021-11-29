package com.practice;

import java.util.LinkedHashMap;

public class LRUCache {
	
	LinkedHashMap<Integer, String> lruMap;
	
	public LRUCache(int capacity) {
		this.lruMap = new LinkedHashMap<>(capacity, 1.0f, true){
			/**
			 * 
			 */
			private static final long serialVersionUID = -1637925347198623104L;

			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<Integer, String> eldest) {
				return lruMap.size() > capacity;
			}
		};
	}

}
