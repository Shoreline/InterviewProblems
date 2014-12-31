package linkedlist;

/*
 * "LinkedListNode" is used in 150-question book but it is not a build-in Java class
 * 
 * We need to define it before using it
 * 
 * So here I give a simple singly linked list node that takes a char as data field.
 * 
 * This class is usually used to indirectly represent a linked list, instead of a node of it
 * 
 */

public class LinkedListNode {

	public char data;
	public LinkedListNode next;

	LinkedListNode(char value) {
		data = value;
	}

	public String tostring() {
		LinkedListNode current = this;
		String output = "";
		while (current != null) {
			output += current.data + "->";
			current = current.next;
		}
		return output + "NULL";
	}

	public static LinkedListNode getExample() {
		LinkedListNode head = new LinkedListNode('a');
		head.next = new LinkedListNode('b');
		head.next.next = new LinkedListNode('c');
		head.next.next.next = new LinkedListNode('d');

		return head;
	}

}
