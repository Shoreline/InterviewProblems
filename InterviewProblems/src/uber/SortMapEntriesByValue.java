package uber;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortMapEntriesByValue {
    static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
	SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(new Comparator<Map.Entry<K, V>>() {

	    @Override
	    public int compare(Entry<K, V> e1, Entry<K, V> e2) {
		int res = e1.getValue().compareTo(e2.getValue());
		return res == 0 ? 1 : res;
	    }
	});
	sortedEntries.addAll(map.entrySet());
	return sortedEntries;
    }
}
