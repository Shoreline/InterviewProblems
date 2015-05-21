package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class _Test {

    public static void main(String[] args) {

	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next= new ListNode(3);
	new ReverseNodesInKGroup().new Solution().reverseKGroup(head, 2);
    }

    
}
