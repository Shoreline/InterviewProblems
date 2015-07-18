package linkedin;

import java.util.List;

/**
 * Place Flowers
 * 
 * Suppose you have a long flower bed in which some of the plots are planted and
 * some are not. However, flowers cannot be planted in adjacent plots - they
 * would compete for water and both would die. Given a flower bed (represented
 * as an array containing booleans), return if a given number of new flowers can
 * be planted in it without violating the no-adjacent-flowers rule.
 */

public class PlaceFlowers {
    class Solution {
	public boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace) {
	    if (flowerbed == null || flowerbed.isEmpty()) {
		return false;
		// throw new IllegalArgumentException("bed is empty");
	    } else if (numberToPlace == 0) {
		return true;
	    }

	    int count = 0;
	    for (int i = 0; i < flowerbed.size(); i++) {
		if (!flowerbed.get(i)) {
		    if ((i == 0 && !flowerbed.get(i + 1)) || (i == flowerbed.size() - 1 && !flowerbed.get(i - 1))
			    || (!flowerbed.get(i + 1) && !flowerbed.get(i - 1))) {
			// place the flower
			flowerbed.set(i, true);
			count++;
			if (count == numberToPlace)
			    return true;
		    }
		}
	    }

	    return false;
	}
    }
}
