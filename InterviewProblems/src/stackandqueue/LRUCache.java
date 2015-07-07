package stackandqueue;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 *
 * 
 *
 */

/*
 * To achieve O(1) get() and set(), use a double-linked list and a Map to
 * implement
 * 
 * some code is duplicated, can be more concise
 */
public class LRUCache {
    class Node {
	int key;
	int val;
	Node pre;
	Node next;

	public Node(int _key, int _val) {
	    this.key = _key;
	    this.val = _val;
	}
    }

    int capacity = 0;
    Map<Integer, Node> map;
    Node head; // head of node list
    Node tail;

    public LRUCache(int capacity) {
	this.capacity = capacity;
	map = new HashMap<>();
    }

    public int get(int key) {
	if (!map.containsKey(key)) {
	    return -1;
	} else {
	    update(key);
	    return map.get(key).val;
	}
    }

    public void set(int key, int value) {
	if (map.containsKey(key)) {
	    map.get(key).val = value;
	} else {
	    Node node = new Node(key, value);
	    if (head == null) {
		head = node;
		tail = node;
	    } else {
		node.next = head;
		head.pre = node;
		head = node;
	    }

	    map.put(key, node);
	}
	update(key);
    }

    private void update(int key) {
	Node node = map.get(key);
	if (head != node) {
	    if (tail == node) {
		tail = node.pre;
		tail.next = null;
	    } else {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	    }

	    node.next = head;
	    head.pre = node;
	    head = node;
	}

	if (map.size() > capacity) {
	    map.remove(tail.key);
	    tail = tail.pre;
	    tail.next = null;
	}
    }
}
/*
 * Below solution put newest node in the end
 */
//public class LRUCache {
//    class Node {
//	Node pre;
//	Node next;
//	int key;
//	int value;
//
//	public Node(int _key, int _value) {
//	    this.key = _key;
//	    this.value = _value;
//	}
//    }
//
//    int capacity;
//    int nodeCount;
//    Map<Integer, Node> nodeMap; // node.key -> node map
//    // List<Node> nodeList; // wrong way
//    Node head, tail; // nodeList implementation
//
//    public LRUCache(int capacity) {
//	this.capacity = capacity;
//	nodeCount = 0;
//	nodeMap = new HashMap<Integer, Node>();
//	head = null;
//	tail = null;
//    }
//
//    public int get(int key) {
//	Node node = nodeMap.get(key);
//	if (node == null) {
//	    return -1;
//	} else if (node != tail) {
//	    if (node == head) {
//		head = node.next;
//		head.pre = null;
//	    } else {
//		node.pre.next = node.next;
//		node.next.pre = node.pre;
//	    }
//
//	    tail.next = node;
//	    node.pre = tail;
//	    node.next = null;
//	    tail = node;
//	}
//	return node.value;
//    }
//
//    public void set(int key, int value) {
//	Node node = nodeMap.get(key);
//	if (node == null) {
//	    if (nodeCount == capacity) {
//		nodeMap.remove(head.key);
//
//		head = head.next;
//
//		if (head != null) {
//		    head.pre = null;
//		} else {
//		    tail = null;
//		}
//
//		nodeCount--;
//	    }
//
//	    Node newNode = new Node(key, value);
//	    nodeMap.put(key, newNode);
//	    nodeCount++;
//
//	    if (head == null) {
//		head = newNode;
//		tail = newNode;
//	    } else {
//		tail.next = newNode;
//		newNode.pre = tail;
//		tail = newNode;
//	    }
//	} else {
//	    node.value = value;
//
//	    if (node != tail) {
//		if (node == head) {
//		    head = node.next;
//		    head.pre = null;
//		} else {
//		    node.pre.next = node.next;
//		    node.next.pre = node.pre;
//		}
//
//		tail.next = node;
//		node.pre = tail;
//		node.next = null;
//		tail = node;
//	    }
//	}
//
//    }
//
//}
