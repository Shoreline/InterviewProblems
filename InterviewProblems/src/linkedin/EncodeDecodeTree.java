package linkedin;

import java.util.*;

class BTreeNode {
    public int val;
    public List<BTreeNode> children;

    public BTreeNode(int _val) {
	this.val = _val;
	children = new ArrayList<>();
    }
}

public class EncodeDecodeTree {

    class Method {
	public String serialize(BTreeNode root) {
	    StringBuilder res = new StringBuilder();

	    if (root == null) {
		return res.toString();
	    }

	    Queue<BTreeNode> queue = new LinkedList<>();
	    queue.add(root);

	    while (!queue.isEmpty()) {
		int lSize = queue.size();
		for (int i = 0; i < lSize; i++) {
		    BTreeNode node = queue.poll();
		    res.append(node.val).append('|').append(node.children.size()).append(';');
		    for (BTreeNode child : node.children) {
			queue.add(child);
		    }
		}
	    }

	    return res.toString();
	}

	public BTreeNode deSerialize(String s) {
	    if (s == null || s.length() == 0) {
		return null;
	    }
	    String[] nodeStrs = s.split(";");

	    String[] nodeFields = nodeStrs[0].split("\\|");
	    BTreeNode root = new BTreeNode(Integer.valueOf(nodeFields[0]));

	    List<BTreeNode> curLvlNodes = new ArrayList<>();
	    curLvlNodes.add(root);
	    List<Integer> curLvlSizes = new ArrayList<>();
	    curLvlSizes.add(Integer.valueOf(nodeFields[1]));

	    int ptr = 1;

	    while (!curLvlNodes.isEmpty()) {

		List<BTreeNode> nextLvlNodes = new ArrayList<>();
		List<Integer> nextLvlSizes = new ArrayList<>();

		for (int i = 0; i < curLvlNodes.size(); i++) {
		    BTreeNode node = curLvlNodes.get(i);
		    int size = curLvlSizes.get(i);

		    for (int j = ptr; j < ptr + size; j++) {
			nodeFields = nodeStrs[j].split("\\|");
			BTreeNode child = new BTreeNode(Integer.valueOf(nodeFields[0]));
			node.children.add(child);

			nextLvlNodes.add(child);
			nextLvlSizes.add(Integer.valueOf(nodeFields[1]));		
		    }
		    
		    System.out.print(node.val + "  ");
		    
		    ptr += size;
		}
		
		curLvlNodes= nextLvlNodes;
		curLvlSizes = nextLvlSizes;
		System.out.println();

	    }

	    return root;
	}
    }

    public static void main(String[] args) {
	BTreeNode root = new BTreeNode(2);
	root.children.add(new BTreeNode(3));
	root.children.add(new BTreeNode(4));
	root.children.get(0).children.add(new BTreeNode(5));
	root.children.get(0).children.add(new BTreeNode(6));
	root.children.get(0).children.add(new BTreeNode(7));
	root.children.get(1).children.add(new BTreeNode(8));
	root.children.get(1).children.add(new BTreeNode(9));

	String encoded = new EncodeDecodeTree().new Method().serialize(root);
	System.out.println(encoded);
	
	System.out.println(new EncodeDecodeTree().new Method().deSerialize(encoded));

    }
}
