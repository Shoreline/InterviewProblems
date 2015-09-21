package uber;

import java.util.List;

public class WeightedRandomChooser {

    interface Item {
	double getWeight();
    }

    class RandomItemChooser {
	public Item chooseOnWeight(List<Item> items) {
	    double completeWeight = 0.0;
	    for (Item item : items)
		completeWeight += item.getWeight();
	    
	    double r = Math.random() * completeWeight;
	    
	    double countWeight = 0.0;
	    for (Item item : items) {
		countWeight += item.getWeight();
		if (countWeight >= r)
		    return item;
	    }
	    
	    throw new RuntimeException("Should never be shown.");
	}
    }

}
