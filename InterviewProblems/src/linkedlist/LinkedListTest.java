package linkedlist;

import java.util.LinkedList;

public class LinkedListTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	LinkedListNode anExample = LinkedListNode.getExample();

	System.out.println(anExample.tostring());

	LinkedListUtil.getReversedLinkedList(anExample);
	System.out.println(anExample.tostring());

	LinkedList<String> haha = new LinkedList<String>();

    }

}
