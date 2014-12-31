package linkedlist;

public class ReverseOuputListValues {
    /**
     * Output linkedlist node values in reverse order
     * 
     * http://zhedahht.blog.163.com/blog/static/2541117420079237185699/
     * 
     * ����Ա�����⾫ѡ100 ��(31)-��β��ͷ�������
     * 
     * ��Ŀ������һ�������ͷ��㣬��β��ͷ���������ÿ������ֵ��
     * 
     * ��չ�����⻹�����������ı��壺
     * 
     * 1. ��β��ͷ���һ���ַ�����
     * 
     * 2. ����һ���������ַ����ĳ��ȣ�Ҫ��ú������ڲ��������κα�����
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
