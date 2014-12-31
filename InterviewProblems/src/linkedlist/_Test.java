package linkedlist;

public class _Test {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	LinkedListNode anExample = LinkedListNode.getExample();

	System.out.println(anExample.tostring());

	ListNode haha = new ListNode(1);
	haha.next = new ListNode(2);
	haha.next.next = new ListNode(3);
	haha.next.next.next = new ListNode(4);

	ReverseOuputListValues.printListReversely(haha);

	ReverseNodesInKGroup.reverseKGroup2(haha, 2);

	LinkedListUtil.getReversedLinkedList(anExample);
	System.out.println(anExample.tostring());

	ListNode a = new ListNode(1);
	ListNode b = new ListNode(2);
	addTwoNumbers(a, b);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (l1 == null || l2 == null)
	    return null;

	ListNode preHead = new ListNode(-1);
	ListNode cur = preHead;
	int carrier = 0;

	while (l1 == null || l2 == null) {
	    int value = (l1.val + l2.val + carrier) % 10;
	    carrier = (l1.val + l2.val + carrier) / 10;

	    cur.next = new ListNode(value);

	    cur = cur.next;
	    l1 = l1.next;
	    l2 = l2.next;

	}

	return preHead.next;
    }
}
