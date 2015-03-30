package linkedlist;

public class _Test {

    public static void main(String[] args) {
	
	ListNode head = new ListNode(3);
	head.next = new ListNode(5);
	
	new _Test().new Solution().reverseBetween(head, 1, 2);
    }

    public class Solution {
	    public ListNode reverseBetween(ListNode head, int m, int n) {
	        if(head==null || m==n){
	            return head;
	        }
	        
	        ListNode preSubHead = new ListNode(-1);
	        preSubHead.next = head;
	        for(int i =0; i<m;i++){
	            preSubHead = preSubHead.next;
	        }
	        
	        ListNode pre = preSubHead;
	        ListNode cur = pre.next;
	        for(int i = 0; i<=n-m && cur!=null; i++){
	            ListNode tmp = cur.next;
	            cur.next = pre;
	            pre = cur;
	            cur = tmp;
	        }
	        
	        preSubHead.next.next = cur; // if reach here than m<n
	        preSubHead.next = pre;
	        
	        return (m==1?pre:head);
	    }
	}
}
