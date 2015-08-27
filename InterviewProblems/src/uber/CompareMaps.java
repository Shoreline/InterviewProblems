package uber;

import java.util.*;
import java.util.Map.Entry;

/**
 * 比较两个Map Object，Map的Value可能有两种情况 1. Strings; 2. Map<String, Object> objects
 *
 */

/*
 * two maps m1 and m2 represent the same mappings if
 * m1.entrySet().equals(m2.entrySet())
 */
public class CompareMaps {
    class Method {
	public boolean isEqual(Map<String, Object> m1, Map<String, Object> m2) throws ClassCastException {
	    if (m1.size() != m2.size()) {
		return false;
	    }

	    Iterator<Entry<String, Object>> itr = m1.entrySet().iterator();
	    while (itr.hasNext()) {
		Entry<String, Object> e = itr.next();
		String key = e.getKey();
		Object val1 = e.getValue();

		Object val2 = m2.get(key);

		if (val1 == null) {
		    if (m2.get(key) != null) {
			return false;
		    }
		} else if (val1 instanceof String) {
		    if (!(m2.get(key) instanceof String) || ((String) m2.get(key)).equals(val1)) {
			return false;
		    }
		} else {
		    if (!isEqual((Map<String, Object>) val1, (Map<String, Object>) val2)) {
			return false;
		    }
		}
	    }

	    return true;
	}
    }
}
