package linkedlist;

public class LinkedListUtil {

    public static void removeDuplicates(LinkedListNode a) {

    }

    public static void getReversedLinkedList(LinkedListNode head) {
	if (head == null) {
	    return;
	}

	LinkedListNode end = head;

	while (end.next != null) {
	    // reverse(cur, cur.next);
	    end = end.next;
	}

	getReversedLinkedList(head, end);

    }

    public static void getReversedLinkedList(LinkedListNode head,
	    LinkedListNode end) {

	if (head == end) {
	    return;
	}

	LinkedListNode cur = head;
	LinkedListNode previous = head;
	while (cur.next != end.next) {
	    char temp = cur.data;
	    cur.data = cur.next.data;
	    cur.next.data = temp;
	    previous = cur;
	    cur = cur.next;
	}

	// System.out.println(head.tostring());
	getReversedLinkedList(head, previous);

    }

}
