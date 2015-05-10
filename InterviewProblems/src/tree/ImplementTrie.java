package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement Trie (prefix tree)
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * =================
 * Your Trie object will be instantiated and called as such:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("somestring");
 * 
 * trie.search("key");
 *
 */

/*
 * No need to let TrieNode class have an independent field to save its
 * corresponding character. Instead, a TrieNode's character is determined by its
 * parent's <Character,TrieNode> map.
 */
public class ImplementTrie {
    class TrieNode {
	// Initialize your data structure here.
	boolean isEnd;
	Map<Character, TrieNode> children;

	public TrieNode() {
	    children = new HashMap<Character, TrieNode>();
	}
    }

    public class Trie {
	private TrieNode root;

	public Trie() {
	    root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
	    TrieNode cur = root;
	    for (int i = 0; i < word.length(); i++) {
		Character c = (Character) word.charAt(i);
		if (!cur.children.containsKey(c)) {
		    cur.children.put(c, new TrieNode());
		}
		cur = cur.children.get(c);
	    }

	    cur.isEnd = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
	    TrieNode node = lookUp(word);
	    return node != null && node.isEnd;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
	    TrieNode node = lookUp(prefix);

	    return node != null;
	}

	private TrieNode lookUp(String word) {
	    TrieNode cur = root;
	    for (int i = 0; i < word.length(); i++) {
		Character c = (Character) word.charAt(i);
		if (!cur.children.containsKey(c)) {
		    return null;
		}
		cur = cur.children.get(c);
	    }
	    return cur;
	}
    }
}
