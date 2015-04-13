package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class _Test {

    public static void main(String[] args) {
	
	ListNode head = new ListNode(2);
	head.next = new ListNode(1);
	
	new _Test().partition(head, 2);
    }

    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        
        ListNode preHead1 = new ListNode(-1);
        ListNode tail1= preHead1;
        ListNode preHead2 = new ListNode(-1);
        ListNode tail2 = preHead2;
        ListNode cur = head;
        
        while(cur!=null){
            if(cur.val<x){
                tail1.next = cur;
                tail1=tail1.next;
            }
            else{
                tail2.next = cur;
                tail2=tail2.next;
            }
            
            cur=cur.next;
        }
        
        tail1.next = preHead2.next;
        
        return preHead1.next;
    }
}
