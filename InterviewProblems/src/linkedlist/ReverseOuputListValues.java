package linkedlist;

public class ReverseOuputListValues {
    /**
     * Output linkedlist node values in reverse order
     * 
     * http://zhedahht.blog.163.com/blog/static/2541117420079237185699/
     * 
     * 程序员面试题精选100 题(31)-从尾到头输出链表
     * 
     * 题目：输入一个链表的头结点，从尾到头反过来输出每个结点的值。
     * 
     * 扩展：该题还有两个常见的变体：
     * 
     * 1. 从尾到头输出一个字符串；
     * 
     * 2. 定义一个函数求字符串的长度，要求该函数体内不能声明任何变量。
     */

    /*
     * Naturally, recursion is a stack
     * 
     * Recursively output the values, without using any additional stack. *
     */

    public static void printListReversely(ListNode head) {
	if (head == null)
	    return;

	printListReversely(head.next);

	System.out.println(head.val);

    }
}
