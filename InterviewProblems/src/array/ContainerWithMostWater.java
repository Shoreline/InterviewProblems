package array;

public class ContainerWithMostWater {
    /**
     * Container with most water
     * 
     * Given n non-negative integers a1, a2, ..., an, where each represents a
     * point at coordinate (i, ai). n vertical lines are drawn such that the two
     * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
     * together with x-axis forms a container, such that the container contains
     * the most water.
     * 
     * Note: You may not slant the container.
     */

    /*
     * Two approaching pointers! Another good implementation.
     * 
     * Important: This time the array is not sorted.
     */
    public static int maxArea(int[] height) {
	int maxArea = 0;

	int i = 0;
	int j = height.length - 1;

	while (i < j) {
	    int curArea = Math.min(height[i], height[j]) * (j - i);
	    if (curArea > maxArea) {
		maxArea = curArea;
		/*
		 * Do not need to change i, j here, since the condition is
		 * curArea>maxArea, not >=
		 */

	    } else if (height[i] <= height[j]) {
		/*
		 * when left <= right, then the only possible case in to find a
		 * larger left
		 */
		i++;
	    } else {
		j--;
	    }
	}

	return maxArea;
    }
}
