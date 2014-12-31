package stackandqueue;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
    ArrayList<Stack> stacks;

    public SetOfStacks() {
	stacks = new ArrayList<Stack>();
    }

    public void push(int value) {

    }

    public Object pop() {

	Object value;

	value = getLastStack().pop();
	if (getLastStack().size() == 0) {
	    stacks.remove(stacks.size() - 1);
	}
	return value;
    }

    private Stack getLastStack() {
	return stacks.get(stacks.size());
    }
}
