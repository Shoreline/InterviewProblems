package stackandqueue;

import java.util.Stack;

public class StackAndQueueTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	MinStack aStack = new MinStack();
	Stack<Integer> bStack = new Stack<Integer>();
	int[] intArray = { 2, 5, 6, 2, 1, 4, 3 };

	for (int anInt : intArray) {
	    // aStack.push(anInt);
	    bStack.push(anInt);
	}

	System.out.println(bStack.toString());
	bStack = StackSorting.getSortedStack(bStack);
	System.out.println(bStack.toString());

    }

}
