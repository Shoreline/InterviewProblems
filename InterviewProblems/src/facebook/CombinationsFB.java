package facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 有一个set里有不同的字母{'a', 'b', 'c'}, 有一个整数值K，如果K＝2，输出aa,ab,ac,ba,bb,bc,ca,cb,cc
 * 
 * follow up:组合中不包含相同字符怎么实现
 * 
 * follow up++:不用额外空间怎么做。
 *
 */
public class CombinationsFB {
    class Method {
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
		tmp[size] = chars[i];
		dfs(chars, k, tmp, size + 1, res);
	    }
	}
    }
}
