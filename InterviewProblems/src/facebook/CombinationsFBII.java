package facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 有一个set里有不同的字母{'a', 'b', 'c'}, 有一个整数值K，如果K＝2，输出不包含相同字符的组合
 */
public class CombinationsFBII {
    class Method {
	public List<String> combination(Set<Character> input, int k) {
	    List<String> res = new ArrayList<>();

	    dfs(input.toArray(new Character[0]), k, new boolean[input.size()], new char[k], 0, res);

	    return res;
	}

	private void dfs(Character[] chars, int k, boolean[] occupied, char[] tmp, int size, List<String> res) {
	    if (size == k) {
		res.add(new String(tmp));
		return;
	    }

	    for (int i = 0; i < chars.length; i++) {
		if (!occupied[i]) {
		    tmp[size] = chars[i];
		    occupied[i] = true;
		    dfs(chars, k, occupied, tmp, size + 1, res);
		    occupied[i] = false;
		}
	    }
	}
    }

    /*
     * follow up++:不用额外空间怎么做。
     * 
     * Trade with time.
     */
    class Method2 {
	public List<String> combination(Set<Character> input, int k) {
	    List<String> res = new ArrayList<>();

	    dfs(input.toArray(new Character[0]), k, new char[k], 0, res);

	    return res;
	}

	private void dfs(Character[] chars, int k, char[] tmp, int size, List<String> res) {
	    if (size == k) {
		res.add(new String(tmp));
		return;
	    }

	    for (int i = 0; i < chars.length; i++) {
		boolean occupied = false;
		for (int j = 0; j < size; j++) {
		    if (tmp[j] == chars[i]) {
			occupied = true;
			break;
		    }
		}

		if (!occupied) {
		    tmp[size] = chars[i];
		    dfs(chars, k, tmp, size + 1, res);
		}
	    }
	}
    }
}
