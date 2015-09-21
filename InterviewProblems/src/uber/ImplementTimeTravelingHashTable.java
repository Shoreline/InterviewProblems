package uber;

/**
 * * TimeTravelingHashTable
 * 
 * insert(key, value, timestamp)
 * 
 * get(key, timestamp)
 * 
 * get(key) // returns value associated with key at latest time
 *
 *
 ** insert("k1", "v1", 10)
 *
 * get("k1") // returns "v1"
 * 
 * get("k1", 11) // returns "v1"
 * 
 * insert("k1", "v2", 20)
 * 
 * get("k1", 15) // returns "v1"
 * 
 * get("k1", 11) // returns "v1"
 */
/*
 * Use linked list. Each node is a BST node.
 * 
 * get takes klong(n)
 * 
 * 
 * My thought:
 * 
 * 1) Map<Key, BST Node>. the value of each BST node is the timestamp, an additional 'data' field saves data.
 * 
 * 2) BST, each BST node is a linked list. BST node value is
 * 
 * BSTNode{
 * 	Key keyval;
 * 	LinkedList
 * }
 */
public class ImplementTimeTravelingHashTable {

}
