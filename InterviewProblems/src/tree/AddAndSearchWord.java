package tree;

/**
 * Add and Search Word - Data structure design
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * 
 * bool search(word)
 * 
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad")
 * 
 * addWord("dad")
 * 
 * addWord("mad")
 * 
 * search("pad") -> false
 * 
 * search("bad") -> true
 * 
 * search(".ad") -> true
 * 
 * search("b..") -> true
 * 
 * Note: You may assume that all words are consist of lowercase letters a-z.
 *
 */

/*
 * Trie tree.
 */
public class AddAndSearchWord {
    public class WordDictionary {
	class TrieNode {
	    TrieNode[] children;
	    boolean isEnd;

	    public TrieNode() {
		children = new TrieNode[26];
		isEnd = false;
	    }
	}

	TrieNode root;

	public WordDictionary() {
	    root = new TrieNode();
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
	    TrieNode cur = this.root;
	    for (int i = 0; i < word.length(); i++) {
		int c = word.charAt(i) - 'a';
		if (cur.children[c] == null) {
		    cur.children[c] = new TrieNode();
		}
		cur = cur.children[c];
	    }

	    cur.isEnd = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
	    return search(word, 0, root);
	}

	private boolean search(String word, int pos, TrieNode node) {
	    TrieNode cur = node;

	    while (pos < word.length() && cur != null) {
		if (word.charAt(pos) == '.') {
		    for (TrieNode child : cur.children) {
			if (child != null && search(word, pos + 1, child)) {
			    return true;
			}
		    }
		    return false;
		}

		cur = cur.children[word.charAt(pos) - 'a'];
		pos++;
	    }

	    return cur != null && cur.isEnd;
	}
    }

    // Your WordDictionary object will be instantiated and called as such:
    // WordDictionary wordDictionary = new WordDictionary();
    // wordDictionary.addWord("word");
    // wordDictionary.search("pattern");
}
