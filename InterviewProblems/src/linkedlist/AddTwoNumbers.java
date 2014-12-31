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
     * second round.
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (l1 == null || l2 == null)
	    return null;

	ListNode preHead = new ListNode(-1);
	ListNode cur = preHead;

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

	ListNode rest = null;

	if (l1 == null) {
	    rest = l2;
	} else {
	    rest = l1;
	}

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
