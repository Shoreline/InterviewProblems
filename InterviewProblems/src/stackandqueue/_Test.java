package stackandqueue;

public class _Test {

    public static void main(String[] args) {
	LRUCache cache = new LRUCache(1);
	cache.set(2,1);
	cache.get(2);
	cache.set(3, 2);
	cache.get(2);
	cache.get(3);
	
	StringBuilder sb = new StringBuilder();
	sb.append("");
    }

}
