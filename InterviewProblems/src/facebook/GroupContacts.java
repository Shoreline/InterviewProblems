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
 * 
 * 
 * While grouping, use the ID of each contact record (#1->0; #2->1, etc) instead
 * of contact name to represent each contact record.
 */

class Contact {
	int id;
	String name;
	List<String> emails;
	
	public Contact(int id, String name, List<String> emails) {
	    this.id = id;
	    this.name = name;
	    this.emails = emails;
	}
}

public class GroupContacts {

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

    class UnionFindSimple {
	int[] parent;

	/*
	 * Initially, each element's father is itself; and initial rank is 0
	 */
	public UnionFindSimple(int size) {
	    parent = new int[size];
	    for (int i = 0; i < size; i++) {
		parent[i] = i;
	    }
	}

	// find the father of an element
	int find(int x) {
	    if (parent[x] == x) {
		return x;
	    }

	    return find(parent[x]);
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
	    } else {
		parent[fx] = fy;
	    }
	}
    }

    public List<List<Contact>> groupContacts(List<Contact> input) {
	List<List<Contact>> res = new ArrayList<List<Contact>>();
	if (input == null || input.size() == 0) {
	    return res;
	}

	// construct email -> list<uid> map
	Map<String, List<Integer>> emailMap = new HashMap<>();
	for (Contact c : input) {
	    for (String email : c.emails) {
		if (!emailMap.containsKey(email)) {
		    emailMap.put(email, new ArrayList<Integer>());
		}
		emailMap.get(email).add(c.id);
	    }
	}

	UnionFindSimple uf = new UnionFindSimple(input.size());
	for (String email : emailMap.keySet()) {
	    List<Integer> contactIds = emailMap.get(email);
	    for (int i = 0; i < contactIds.size() - 1; i++) {
		uf.union(contactIds.get(i), contactIds.get(i + 1));
	    }
	}

	// rootID-> List<contactID>
	Map<Integer, List<Integer>> groups = new HashMap<>();
	for (int i = 0; i < input.size(); i++) {
	    int root = uf.find(i);

	    if (!groups.containsKey(root)) {
		groups.put(root, new ArrayList<Integer>());
	    }
	    groups.get(root).add(i);
	}
	
	System.out.print(groups); //testing

	for (int father : groups.keySet()) {
	    List<Contact> group = new ArrayList<>();
	    for (int child : groups.get(father)) {
		group.add(input.get(child));
	    }
	    res.add(group);
	}
	return res;
    }

    public static void main(String[] args) {
	Contact c1 = new Contact(0,"John", Arrays.asList(new String[]{"john@gmail.com"}));
	Contact c2 = new Contact(1,"Mary", Arrays.asList(new String[]{"mary@gmail.com"}));
	Contact c3 = new Contact(2,"John", Arrays.asList(new String[]{"john@yahoo.com"}));
	Contact c4 = new Contact(3,"John", Arrays.asList(new String[]{"john@gmail.com", "john@yahoo.com", "john@hotmail.com"}));
	Contact c5 = new Contact(4,"Bob", Arrays.asList(new String[]{"bob@gmail.com"}));
	List<Contact> contacts = new ArrayList<>();
	contacts.add(c1);
	contacts.add(c2);
	contacts.add(c3);
	contacts.add(c4);
	contacts.add(c5);
	
	new GroupContacts().groupContacts(contacts);
	
    }

}
