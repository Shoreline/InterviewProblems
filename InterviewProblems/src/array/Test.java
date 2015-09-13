package array;

import java.util.Arrays;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] nums = new int[]{3, 5, 2, 1, 6, 4};
	new WiggleSort().new Solution().wiggleSort(nums);
	System.out.println(Arrays.toString(nums));

    }

}
