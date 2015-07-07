package stackandqueue;

import java.util.Stack;

/**
 * Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * top() -- Get the top element.
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 150-question book, 3.2
 * 
 */
/*
 * Lack of exception handling. (may not be necessary)
 * 
 * use '<=' in push() and pop(). '<' won't work.
 */
class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
	if (minStack.isEmpty() || x <= minStack.peek()) {
	    minStack.push(x);
	}
	stack.push(x);
    }

    public void pop() {
	// "==" won't work!
	if (stack.peek() <= minStack.peek()) {
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
