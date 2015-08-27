package uber;

import java.util.*;

/**
 * 写一个class实现下面功能：
 * 
 * put(key,value,time)
 * 
 * get(key, time)
 * 
 * 要求get返回给定time前面的那个值.一个map，value用一个sort list，然后binary search查找
 * 
 * 我也被问了这题 用hash table加 sorted map秒杀 结果实现get的时候用stl的map：： lower_bound死活返回不对的值
 * 面试官也不知道为什么
 * 
 * 后来我说我自己实现map。用bst写了个。运行加测试用例写了十几个，通过
 *
 */
public class ClassImplementation<K, V> {
    class TimeMap {
	// HashMap<key, TreeMap<time, value>>
	private Map<K, TreeMap<Integer, V>> data;

	public void put(K key, V value, Integer time) {
	    if (!data.containsKey(key)) {
		data.put(key, new TreeMap<Integer, V>());
	    }

	    data.get(key).put(time, value);
	}

	public V get(K key, Integer time) {
	    if (!data.containsKey(key)) {
		return null;
	    } else if (data.get(key).floorKey(time) == null) {
		return null;
	    }

	    return data.get(key).floorEntry(time).getValue();
	}
    }
}
