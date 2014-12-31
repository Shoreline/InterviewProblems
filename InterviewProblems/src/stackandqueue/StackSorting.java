package stackandqueue;

import java.util.Stack;

public class StackSorting {

    public static Stack<Integer> getSortedStack(Stack<Integer> aStack) {

	Stack<Integer> tempStack = new Stack<Integer>();
	Stack<Integer> singleItem = new Stack<Integer>();

	while (!aStack.isEmpty()) {
	    singleItem.push(aStack.pop());
	    while (!tempStack.isEmpty() && tempStack.peek() > singleItem.peek()) {
		aStack.push(tempStack.pop());
	    }

	    tempStack.push(singleItem.pop());

	}

	return tempStack;
    }

}
