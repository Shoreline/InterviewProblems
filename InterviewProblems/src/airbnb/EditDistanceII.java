package airbnb;

import java.util.*;

/**
 * 题目是给定一个word list 和一个target word，要求输出在word list 里跟target word的edit distance
 * 相差不大于k的所有words。 给一个list，找出所有和target相似的words。
 *
 * http://www.mitbbs.com/article_t1/JobHunting/32692817_0_1.html
 *
 * http://www.fgdsb.com/2015/01/24/get-similar-words/
 */
public class EditDistanceII {
    /*
     * For a trie node, if dist>=k, no need to check the rest words of this
     * path.?? wrong?
     * 
     * ex: target = "abcde"; word1 = "xyz", word2 = "xyzabcde".
     * 
     * the distance of word1 is 5; while for word2 is just 3 ? -for word1 is 5:
     * 3 replacements and 2 additions. For word2 is 3 deletions
     * 
     * -> need to also check the reversed trie?
     */
    class Method {
	class trieNode {
	    boolean isEnd;
	    trieNode[] nexts;

	    public trieNode() {
		nexts = new trieNode[256];
	    }

	    public void add(String str) {
		trieNode cur = this;
		for (char c : str.toCharArray()) {
		    if (cur.nexts[c] == null)
			cur.nexts[c] = new trieNode();
		    cur = cur.nexts[c];
		}
		cur.isEnd = true;
	    }
	}

	public List<String> getWords(String[] dict, int d, String target) {
	    List<String> res = new ArrayList<String>();
	    trieNode root = new trieNode();
	    for (String str : dict) {
		root.add(str);
	    }

	    // dist[i] = Dist (the first i-char substring of target, cur Str).
	    // Here, the initial curStr is empty
	    int dist[] = new int[target.length() + 1];
	    for (int i = 0; i < dist.length; i++) {
		dist[i] = i;
	    }

	    dfs(d, target, "", dist, root, res);
	    return res;
	}

	private void dfs(int d, String target, String curStr, int[] preDist, trieNode root, List<String> res) {
	    if (root.isEnd) {
		if (preDist[target.length()] <= d) {
		    res.add(curStr);
		} else {
		    return;
		}
	    }

	    for (int i = 0; i < 256; i++) {
		if (root.nexts[i] != null) {
		    int[] curDist = new int[target.length() + 1];
		    curDist[0] = curStr.length() + 1;
		    
		    for (int j = 1; j < preDist.length; j++) {
			if (target.charAt(j - 1) == i) {
			    curDist[j] = preDist[j - 1];
			} else {
			    curDist[j] = Math.min(preDist[j], Math.min(preDist[j - 1], curDist[j - 1])) + 1;
			}
		    }
		    
		    dfs(d, target, curStr + (char) i, curDist, root.nexts[i], res);
		}
	    }
	}
    }
}
