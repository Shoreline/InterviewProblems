package linkedlist;

public class AddTwoNumbers {
    /**
     * Add two numbers
     * 
     * You are given two linked lists representing two non-negative numbers. The
     * digits are stored in reverse order and each of their nodes contain a
     * single digit. Add the two numbers and return it as a linked list.
     * 
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
     * 
     */

    /* 
     * A more simplified version: let val1 = 0 if l1 == null; similar handling for l2.
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
	if (l1 == null && l2 == null) {
	    return null;
	}

	ListNode preHead = new ListNode(-1);
	ListNode cur = preHead;
	int carrier = 0;

	while (l1 != null || l2 != null) {
	    int val1 = (l1 == null ? 0 : l1.val);
	    int val2 = (l2 == null ? 0 : l2.val);

	    int sum = val1 + val2 + carrier;

	    cur.next = new ListNode(sum % 10);
	    carrier = sum / 10;

	    cur = cur.next;
	    if (l1 != null) {
		l1 = l1.next;
	    }
	    if (l2 != null) {
		l2 = l2.next;
	    }
	}

	if (carrier != 0) {
	    cur.next = new ListNode(carrier);
	}

	return preHead.next;
    }
    
    
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
	if (l1 == null && l2 == null) {
	    return null;
	}

	ListNode preHead = new ListNode(-1);
	ListNode cur = preHead; // cur also starts with preHead

	int carrier = 0;

	while (l1 != null && l2 != null) {
	    int sum = l1.val + l2.val + carrier;
	    int value = sum % 10;
	    carrier = sum / 10;

	    cur.next = new ListNode(value);

	    cur = cur.next;
	    l1 = l1.next;
	    l2 = l2.next;
	}

	ListNode rest = (l1 == null ? l2 : l1);

	while (rest != null) {
	    int sum = rest.val + carrier;
	    int value = sum % 10;
	    carrier = sum / 10;

	    cur.next = new ListNode(value);

	    cur = cur.next;
	    rest = rest.next;
	}

	if (carrier != 0) {
	    cur.next = new ListNode(carrier);
	}

	return preHead.next;
    }

    /*
     * shall be a more concise version
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)

    {

	ListNode result = null;
	int carrier = 0;

	if (l1 != null && l2 != null) {
	    int sum1 = l1.val + l2.val;
	    if (sum1 < 10) {
		result = new ListNode(sum1);
	    } else {
		carrier = 1;
		result = new ListNode(sum1 - 10);
	    }
	    l1 = l1.next;
	    l2 = l2.next;
	} else if (l1 != null) {
	    return l1;
	} else if (l2 != null) {
	    return l2;
	} else {
	    return null;
	}

	ListNode curNode = result;

	while (l1 != null && l2 != null) {
	    int sum = l1.val + l2.val + carrier;
	    if (sum > 9) {
		carrier = 1;
		sum = sum - 10;
	    } else {
		carrier = 0;
	    }

	    ListNode newNode = new ListNode(sum);
	    curNode.next = newNode;

	    l1 = l1.next;
	    l2 = l2.next;
	    curNode = curNode.next;
	}

	ListNode temp = null;
	if (l1 != null) {
	    temp = l1;
	} else if (l2 != null) {
	    temp = l2;
	}

	while (temp != null) {
	    int sum = temp.val + carrier;
	    if (sum > 9) {
		carrier = 1;
		sum = sum - 10;
	    } else {
		carrier = 0;
	    }
	    ListNode newNode = new ListNode(sum);
	    curNode.next = newNode;

	    temp = temp.next;
	    curNode = curNode.next;
	}

	if (carrier == 1) {
	    ListNode newNode = new ListNode(1);
	    curNode.next = newNode;
	}

	return result;
    }
}
