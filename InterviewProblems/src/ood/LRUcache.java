package ood;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implement a Latest Recently Used cache (LRU cache)
 */

public class LRUcache<K, V> extends LinkedHashMap<K, V> {

    /*
     * serialVersionUID is used to check version compatibility. It has to be a
     * static final long number
     */
    private static final long serialVersionUID = 9027438489648841037L;

    private int capacity;

    public LRUcache(int i) {
	/*
	 * i is the capacity of new LinkedHashMap; 1.0 is the load factor. It
	 * has to be a float, so use 1.0f; true means use access Order (false
	 * means use insertion order) *
	 */
	super(i, 1.0f, true);
	capacity = i;
    }

    /*
     * This method is a build-in method of LinkedHashMap.
     * 
     * It will be called once a put() or get() is invoked. If it returns true,
     * then the first entry in LinkedHashMap will be removed
     */
    protected boolean removeEldestEntry(Map.Entry eldest) {
	return (this.size() > this.capacity);
    }
}
