package linkedlist;

import java.util.ArrayList;
import java.util.List;

import array.Subsets2;

public class _Test {

    public static void main(String[] args) {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	new ReorderList().new Solution2().reorderList(head);
    }

    
}
