package array;

/**
 * Medium Sort Colors II
 * 
 * 32% Accepted
 * 
 * Given an array of n objects with k different colors (numbered from 1 to k),
 * sort them so that objects of the same color are adjacent, with the colors in
 * the order 1, 2, ... k.
 * 
 * 
 * Example Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors
 * in-place to [1, 2, 2, 3, 4].
 * 
 * @array
 *
 */
/*
 * 题目要求不使用额外的数组，可以利用上面的思想，只不过要用原来的数组a来统计每个颜色出现的频率。由于原来的颜色肯定是正数1-k，所以我们可以用负数比如a[i
 * ]=-k,表示第i种颜色在原来的数组里面出现了k次。这道题原数组还要重复利用作为bucket数组，那么我们应该怎么办呢？首先for循环遍历一遍原来的数组，
 * 如果扫到a[i]，首先检查a[a[i]]是否为正数，如果是把a[a[i]]移动a[i]存放起来，然后把a[a[i]]记为-1(表示该位置是一个计数器，计1
 * )。 如果a[a[i]]是负数，那么说明这一个地方曾经已经计数了，那么把a[a[i]]计数减一，并把color[i] 设置为0
 * （表示此处已经计算过），然后重复向下遍历下一个数，这样遍历原数组所有的元素过后，数组a里面实际上存储的每种颜色的计数，
 * 然后我们倒着再输出每种颜色就可以得到我们排序后的数组。
 * 
 * inplace，并且O(N)时间复杂度的算法。
 * 
 * 我们可以使用类似桶排序的思想，对所有的数进行计数。
 * 
 * 1. 从左扫描到右边，遇到一个数字，先找到对应的bucket.比如
 * 
 * 3 2 2 1 4
 * 
 * 第一个3对应的bucket是index = 2 (bucket从0开始计算）
 * 
 * 2. Bucket 如果有数字，则把这个数字移动到i的position(就是存放起来），然后把bucket记为-1(表示该位置是一个计数器，计1）。
 * 
 * 3. Bucket 存的是负数，表示这个bucket已经是计数器，直接减1. 并把color[i] 设置为0 （表示此处已经计算过）
 * 
 * 4. Bucket 存的是0，与3一样处理，将bucket设置为-1， 并把color[i] 设置为0 （表示此处已经计算过）
 * 
 * 5. 回到position i，再判断此处是否为0（只要不是为0，就一直重复2-4的步骤）。
 * 
 * 6.完成1-5的步骤后，从尾部到头部将数组置结果。（从尾至头是为了避免开头的计数器被覆盖）
 * 
 * 例子(按以上步骤运算)：
 * 
 * 3 2 2 1 4
 * 
 * 2 2 -1 1 4
 * 
 * 2 -1 -1 1 4
 * 
 * 0 -2 -1 1 4
 * 
 * -1 -2 -1 0 4
 * 
 * -1 -2 -1 -1 0
 */
public class SortColorsII {
    /*
     * counting sort. O(N) time, O(1) space
     * 
     * remember, the colors are 1-based (from 1 - k)
     * 
     * Wrong input: [1,1,2,3,3,3,3,3,3,3],2. There are actually 2 colors, so the
     * second color shall be 2, not 3
     */
    class Solution {
	public void sortColors2(int[] colors, int k) {
	    if (colors == null) {
		return;
	    }

	    for (int i = 0; i < colors.length; i++) {
		while (colors[i] > 0) {
		    int colorIndex = colors[i] - 1;
		    if (colors[colorIndex] > 0) {
			colors[i] = colors[colorIndex];
			colors[colorIndex] = -1;
		    } else {
			colors[colorIndex]--;
			colors[i] = 0;
		    }
		}
	    }

	    int ptr = colors.length - 1;
	    for (int i = k - 1; i >= 0; i--) {
		int count = -colors[i];
		while (count > 0) {
		    colors[ptr] = i + 1;
		    ptr--;
		    count--;
		}
	    }
	}
    }
}
