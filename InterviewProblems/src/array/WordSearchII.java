package array;

import java.util.*;

/**
 * Word Search II
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * For example, Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [ ['o','a','a','n'],
 * 
 * ['e','t','a','e'],
 * 
 * ['i','h','k','r'],
 * 
 * ['i','f','l','v'] ] Return ["eat","oath"]. Note: You may assume that all
 * inputs are consist of lowercase letters a-z.
 * 
 * click to show hint.
 * 
 * You would need to optimize your backtracking to pass the larger test. Could
 * you stop backtracking earlier?
 * 
 * If the current candidate does not exist in all words' prefix, you could stop
 * backtracking immediately. What kind of data structure could answer such query
 * efficiently? Does a hash table work? Why or why not? How about a Trie? If you
 * would like to learn how to implement a basic trie, please work on this
 * problem: Implement Trie (Prefix Tree) first.
 *
 */
/*
 * Trie only need to implement insert.
 * 
 * Keep track of a trie node during DFS.
 */
public class WordSearchII {
    public class Solution {
	class TrieNode {
	    boolean isEnd;
	    Map<Character, TrieNode> children;

	    public TrieNode() {
		children = new HashMap<>();
		isEnd = false;
	    }
	}

	class TrieTree {
	    TrieNode root;

	    public TrieTree() {
		root = new TrieNode();
	    }

	    public void insert(String word) {
		if (word == null || word.isEmpty()) {
		    return;
		}
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
		    char c = word.charAt(i);
		    if (!cur.children.containsKey(c)) {
			cur.children.put(c, new TrieNode());
		    }
		    cur = cur.children.get(c);
		}
		cur.isEnd = true;
	    }

	    public boolean delete(String word) {
		return true;
	    }
	}

	public List<String> findWords(char[][] board, String[] words) {
	    List<String> res = new ArrayList<>();
	    if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
		return res;
	    }

	    TrieTree trie = new TrieTree();
	    for (String word : words) {
		trie.insert(word);
	    }

	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[0].length; j++) {
		    dfs(board, trie.root, i, j, "", res);
		}
	    }

	    return res;
	}

	private void dfs(char[][] board, TrieNode t, int i, int j, String tmp, List<String> res) {
	    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
		return;
	    }

	    TrieNode child = t.children.get(board[i][j]);
	    if (child == null) {
		return;
	    }
	    tmp = tmp + board[i][j];
	    if (child.isEnd) {
		res.add(tmp);
		child.isEnd = false;	// A better way is to delete tmp from the trie tree.
	    }

	    char c = board[i][j];
	    board[i][j] = '.';

	    dfs(board, child, i + 1, j, tmp, res);
	    dfs(board, child, i - 1, j, tmp, res);
	    dfs(board, child, i, j + 1, tmp, res);
	    dfs(board, child, i, j - 1, tmp, res);

	    board[i][j] = c;

	}
    }
}
