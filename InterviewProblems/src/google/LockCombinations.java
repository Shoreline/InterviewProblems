package google;

import java.util.*;

public class LockCombinations {
    class Method {
	public String shortestComboStream(String[] input) {
	    StringBuilder res = new StringBuilder();

	    for (String combo : input) {
		res.append(combo);
		Set<String> visited = new HashSet<>();
		boolean succeed = dfs(input, visited, combo, res);
		if (succeed) {
		    return res.toString();
		}
	    }
	    return null;
	}

	private boolean dfs(String[] input, Set<String> visited, String combo, StringBuilder res) {
	    visited.add(combo);
	    if (visited.size() == input.length) {
		return true;
	    }

	    for (int i = 0; i < 10; i++) {
		char digit = (char) ('0' + i);
		String nextCombo = combo.substring(1) + digit;
		if (!visited.contains(nextCombo)) {
		    res.append(digit);
		    boolean succeed = dfs(input, visited, nextCombo, res);
		    if (succeed) {
			return true;
		    }
		    res.setLength(res.length() - 1);
		}
	    }
	    visited.remove(combo);

	    return false;
	}
    }
}

//string calculate() {
//    // assume all the strings are in an array vector<string> input;
//    string result;
//    for(int i=0; i<input.size(0; ++i) {
//        result = input[i];
//        unordered_set<string> visited;
//        bool succeed = DFS(visited, input[i], result);
//        if(succeed)
//            return result;
//    }
//    // Can not generate!
//    return ""; 
//}
//
//bool DFS(unordered_set<string> &visited, const string &node, string &
//result) {
//    visited.insert(node);
//    if(visited.size() == 10000)
//        return true;
//    string nodeseg = node.substr(1, 3);
//    for(int i=0; i<10; ++i)  {
//        char ch = '0' + i;
//        string nextNode = nodeset;
//        nextNode.push_back(ch);
//        if(visited.find(nextNode) != visited.end()) {
//            result.push_back(ch);
//            bool bSucceed = DFS(visited, nextNode, result);
//            if(bSucceed)
//                return true;
//            result.pop_back();
//        }
//    }
//    visited.erase(node);
//    
//    return false;
//}
//}
