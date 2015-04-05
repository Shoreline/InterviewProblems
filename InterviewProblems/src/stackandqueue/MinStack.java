package stackandqueue;

import java.util.Stack;

/**
 * 
 * @author Yuan
 * 
 *         150-question book, 3.2
 * 
 */
/*
 * Lack of exception handling. (may not be necessary)
 * 
 * use '<=' in push() and pop(). '<' won't work.
 */
class MinStack2 {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) {
        if(minStack.isEmpty() || x<=minStack.peek()){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.peek()<=minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/*
 * Extends Stack, just need to add the one additional minStack
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
