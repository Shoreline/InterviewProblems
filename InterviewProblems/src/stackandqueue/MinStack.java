package stackandqueue;

import java.util.Stack;

/**
 * 
 * @author Yuan
 * 
 *         150-question book, 3.2
 * 
 */
public class MinStack extends Stack<Integer> {
    Stack<Integer> minStack;

    public MinStack() {
	minStack = new Stack<Integer>();

    }

    public void push(int item) {
	super.push(item);
	if (item < getMin()) {
	    minStack.push(item);
	}

    }

    public int pop(int item) {
	int value = super.pop();
	if (value == getMin()) {
	    minStack.pop();
	}
	return value;
    }

    public int getMin() {
	if (minStack.isEmpty()) {
	    System.err.println("stack is empty");
	    return Integer.MIN_VALUE;
	} else {
	    return minStack.peek();
	}
    }

}
