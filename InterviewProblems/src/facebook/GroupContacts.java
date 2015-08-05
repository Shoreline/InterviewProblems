package facebook;

import java.util.*;

/**
 * 有这么一个class Contact，里面有一个String的name，和一个List<String> 装着email
 * address，是这个Contact有的address，用一个list装着是因为一个人有可 能有多个email，现在给你an array of
 * Contact，比如
 * 
 * #1 John [john@gmail.com]
 * 
 * #2 Mary [mary@gmail.com]
 * 
 * #3 John [john@yahoo.com]
 * 
 * #4 John [john@gmail.com, john@yahoo.com, john@hotmail.com]
 * 
 * #5 Bob [bob@gmail.com]
 * 
 * 现在我们知道如果email address相同的话，那么就说明是同一个人，现在要做的是根 据这些email
 * address，把同一个contact给group起来，生成一个List<List<Contact>>
 * ，比如我们就可以知道#1，#3，#4是同一个人。注意不能根据名字来group，因为有可 能有相同名字的人，或者同一个人有可能有不同的名字来注册之类的。
 *
 */

/*
 * Use union-find algorithm
 * 
 * http://dongxicheng.org/structure/union-find-set/
 */
public class GroupContacts {

    class Contact {
	String name;
	List<String> emails;
    }

    // Use Integers to represent elements
    class UnionFind {
	int[] father;
	int[] rank;

	/*
	 * Initially, each element's father is itself; and initial rank is 0
	 */
	public UnionFind(int size) {
	    father = new int[size];
	    rank = new int[size];
	    for (int i = 0; i < size; i++) {
		father[i] = i;
		rank[i] = 0;
	    }
	}

	// find the father of an element
	int find(int x) {
	    if (father[x] == x) {
		return x;
	    }

	    return find(father[x]);
	}

	/*
	 * union two groups, only need to deal with their fathers: making the
	 * lower rank father to be the child of the higher rank father.
	 */
	void union(int x, int y) {
	    int fx = find(x); // father of x
	    int fy = find(y);

	    if (fx == fy) {
		return;
	    }

	    if (rank[fx] < rank[fy]) {
		father[fx] = fy;
	    } else {
		father[fy] = fx;
		if (rank[fx] == rank[fy]) {
		    rank[fx]++;
		}
	    }
	}
    }

    public List<List<Contact>> groupContacts(List<Contact> input) {
	List<List<Contact>> res = new ArrayList<List<Contact>>();
	if (input == null || input.size() == 0) {
	    return res;
	}

	Map<String, List<Integer>> emailMap = new HashMap<>();

	for (int i = 0; i < input.size(); i++) {
	    for (String email : input.get(i).emails) {
		if (!emailMap.containsKey(email)) {
		    emailMap.put(email, new ArrayList<Integer>());
		}
	    }
	}

	UnionFind uf = new UnionFind(input.size());

	for (String email : emailMap.keySet()) {
	    List<Integer> contactIds = emailMap.get(email);
	    for (int i = 0; i < contactIds.size() - 1; i++) {
		uf.union(contactIds.get(i), contactIds.get(i + 1));
	    }
	}

	// fatherID-> List<contactID>
	Map<Integer, List<Integer>> groups = new HashMap<>();
	for (int i = 0; i < input.size(); i++) {
	    int fi = uf.find(i);

	    if (!groups.containsKey(fi)) {
		groups.put(fi, new ArrayList<Integer>());
	    }

	    groups.get(fi).add(i);
	}

	for (int father : groups.keySet()) {
	    List<Contact> group = new ArrayList<>();
	    for (int child : groups.get(father)) {
		group.add(input.get(child));
	    }
	    res.add(group);
	}

	return res;
    }

}
