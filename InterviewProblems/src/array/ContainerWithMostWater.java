package array;

/**
 * Container with most water
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 */

public class ContainerWithMostWater {
    /*
     * Two approaching pointers! Another good implementation.
     * 
     * Important: This time the array is not sorted.
     */
    public static int maxArea(int[] height) {
	if (height == null) {
	    return 0;
	}

	int max = 0;

	int i = 0;
	int j = height.length - 1;

	while (i < j) {
	    int cur = (j - i) * Math.min(height[i], height[j]);

	    if (cur > max) {
		// Here do not need to change i, j, since the condition is
		// cur>max, not >=
		max = cur;
	    } else if (height[i] <= height[j]) {
		// when leftHeight<=rightHeight, any possible larger container
		// will not use this left line
		i++;
	    } else {
		j--;
	    }
	}

	return max;
    }
}
