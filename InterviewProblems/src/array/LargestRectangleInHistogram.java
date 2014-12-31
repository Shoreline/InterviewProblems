package array;

import java.util.Stack;

public class LargestRectangleInHistogram {
    /**
     * Largest Rectangle in Histogram
     * 
     * Given n non-negative integers representing the histogram's bar height
     * where the width of each bar is 1, find the area of largest rectangle in
     * the histogram.
     * 
     * 
     * Above is a histogram where width of each bar is 1, given height =
     * [2,1,5,6,2,3].
     * 
     * 
     * The largest rectangle is shown in the shaded area, which has area = 10
     * unit.
     * 
     * For example,
     * 
     * Given height = [2,1,5,6,2,3], return 10.
     */

    /*
     * O(n) idea:
     * 
     * The point of this algorithm is to maintain a stack where higher element
     * is always greater or equal to the lower element. Why do we need to
     * maintain that kind of stack? Because if we have a non-decreasing list, we
     * can easily calculate the maximum area in one scan. We just need to
     * compare: height[i] * (n ¨C i) for every i. So how do we maintain this
     * stack? If we keep seeing larger element, we just need to push them onto
     * the stack. If we see a smaller (compared to the top element on the stack)
     * element, we need to do two things:
     * 
     * Pop the stack until we can maintain the non-decreasing order. Pushing the
     * smaller element for m times, where m = number of poped elements. Keep
     * track of the maximum area that cause by those pop. For example, we have
     * height = {1,3,5,7,4}. We push onto the stack for {1,3,5,7} then we see 4.
     * 4 is less than 7, so we need to pop. We stop popping until we see 3.
     * However many times we pop, we push 4 onto the stack. Therefore the
     * resulted stack would be {1,3,4,4,4}. Because of popping 7, we need to
     * remember that the maximum area that contains 7 is 7. The largest area
     * that contains 5, the other element which get popped, is 10. So we take
     * that down. We then finish processing all the elements in the original
     * array and end up with a non-decreasing stack {1,3,4,4,4}. We can compute
     * the largest area of this stack, which is 4*3 = 12. Since 12 is larger
     * than the previous largest, 10, we output 12.
     */

    /*
     * second round. Do not need additional class
     */
    public static int largestRectangleArea(int[] height) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (height == null || height.length == 0)
	    return 0;

	int max = 0;

	Stack<Integer> stack = new Stack<Integer>();

	for (int i = 0; i < height.length; i++) {

	    if (stack.isEmpty() || height[i] >= stack.peek()) {
		stack.push(height[i]);
	    } else {
		int j = 0;
		while (!stack.isEmpty() && height[i] < stack.peek()) {
		    j++;
		    int tempArea = stack.pop() * (j);
		    max = Math.max(max, tempArea);

		}

		for (int k = 0; k < j + 1; k++) {
		    stack.push(height[i]);
		}
	    }
	}

	int i = 0;
	while (!stack.isEmpty()) {
	    i++;
	    int tempArea = stack.pop() * i;
	    max = Math.max(tempArea, max);
	}

	return max;
    }

    // slow solution: O(n^2) time and O(n^2) space. Cannot pass the large set:
    // memory exceeded
    public int largestRectangleAreaSlow(int[] height) {
	if (height == null || height.length == 0) {
	    return 0;
	}

	/*
	 * min table: record the minimum bar between [i,j]
	 */
	int[][] minTable = new int[height.length][height.length];
	for (int i = 0; i < height.length; i++) {
	    for (int j = i; j < height.length; j++) {
		if (i == j) {
		    minTable[i][j] = height[i];
		} else {
		    minTable[i][j] = Math.min(height[j], minTable[i][j - 1]);
		}
	    }
	}

	int max = 0;
	for (int i = 0; i < height.length; i++) {
	    for (int j = i; j < height.length; j++) {
		int length = j - i + 1;

		// the width is the minimum bar between [i,j]
		int width = minTable[i][j];

		max = Math.max(max, length * width);
	    }
	}
	return max;
    }

    /*
     * O(n) solution first round.
     * 
     * Created a new class StackElement
     */
    public static int largestRectangleArea1(int[] height) {
	class StackElement {
	    int index;
	    int value;

	    public StackElement(int i, int v) {
		this.index = i;
		this.value = v;
	    }
	}

	if (height == null || height.length == 0) {
	    return 0;
	}

	int max = 0;
	Stack<StackElement> haha = new Stack<StackElement>();

	for (int i = 0; i < height.length; i++) {
	    if (haha.isEmpty() || height[i] >= haha.peek().value) {
		haha.push(new StackElement(i, height[i]));
	    } else {
		while (!haha.isEmpty() && haha.peek().value > height[i]) {
		    int preElementIndex = haha.size() == 1 ? -1 : haha.get(haha
			    .size() - 2).index;
		    max = Math.max(max, haha.peek().value
			    * (i - (preElementIndex + 1)));
		    haha.pop();
		}
		haha.push(new StackElement(i, height[i]));
	    }
	}

	while (!haha.isEmpty() && haha.peek().value > 0) {
	    int preElementIndex = haha.size() == 1 ? -1 : haha
		    .get(haha.size() - 2).index;
	    max = Math.max(max, haha.peek().value
		    * (height.length - (preElementIndex + 1)));
	    haha.pop();
	}
	return max;
    }
}
