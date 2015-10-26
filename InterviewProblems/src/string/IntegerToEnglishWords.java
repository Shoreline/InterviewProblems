package string;

/**
 * Integer to English Words
 * 
 * My Submissions Question Solution Total Accepted: 3554 Total Submissions:
 * 24261 Difficulty: Medium
 * 
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 2^31 - 1.
 * 
 * For example,
 * 
 * 123 -> "One Hundred Twenty Three"
 * 
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 
 * 1234567 ->
 * "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * Hint:
 * 
 * Did you see a pattern in dividing the number into chunk of words? For
 * example, 123 and 123000.
 * 
 * Group the number by thousands (3 digits). You can write a helper function
 * that takes a number less than 1000 and convert just that chunk to words.
 * 
 * There are many edge cases. What are some good test cases? Does your code work
 * with input such as 0? Or 1000010? (middle chunk is zero and should not be
 * printed out) *
 */
/*
 * Since i< 2^31 - 1, so i is at most about 23 billion
 * 
 * underThousand() only deal with values from [0, 999]
 */
public class IntegerToEnglishWords {
    class Solution {
	public String numberToWords(int num) {
	    StringBuilder res = new StringBuilder();
	    String[] units = new String[] { "Billion", "Million", "Thousand", "" };

	    int div = 1000000000;
	    for (int i = 0; i < 4; i++) {
		String seg = underThousand(num / div);
		if (!seg.isEmpty()) {
		    res.append(seg).append(" ").append(units[i]).append(" ");
		}

		num = num % div;
		div /= 1000;
	    }
	    return res.length() == 0 ? "Zero" : res.toString().trim();
	}

	// returns "" if num is 0.
	private String underThousand(int num) {
	    String[] arr1 = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
		    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
		    "Nineteen" };
	    String[] arr2 = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
		    "Ninety" };
	    StringBuilder res = new StringBuilder();

	    int high = num / 100;
	    int midLow = num % 100;
	    int low = num % 10;

	    if (high > 0) {
		res.append(arr1[high]).append(" Hundred "); // an additional " " is attached to the end
	    }

	    if (midLow == 0) {
		if (res.length() > 0) {
		    res.setLength(res.length() - 1);
		}
		return res.toString();
	    }

	    if (midLow < 20) {
		res.append(arr1[midLow]);
	    } else {
		res.append(arr2[midLow / 10]);
		if (low > 0) {
		    res.append(" ").append(arr1[low]);
		}
	    }

	    return res.toString();
	}
    }

    class Solution2 {
	public String numberToWords(int num) {
	    String res = underThousand(num % 1000);
	    String[] units = new String[] { "Thousand", "Million", "Billion" };
	    for (int i = 0; i < 3; i++) {
		num /= 1000;
		res = num % 1000 > 0 ? underThousand(num % 1000) + " " + units[i] + " " + res : res;
	    }

	    res = res.trim();

	    return res.isEmpty() ? "Zero" : res;
	}

	private String underThousand(int num) {
	    String[] arr1 = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
		    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
		    "Nineteen" };
	    String[] arr2 = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
		    "Ninety" };
	    String res = "";

	    int high = num / 100;
	    int midLow = num % 100;
	    int low = num % 10;

	    if (midLow < 20) {
		res = arr1[midLow];
	    } else {
		res = arr2[midLow / 10] + (low > 0 ? " " + arr1[low] : "");
	    }

	    if (high > 0) {
		res = arr1[high] + " Hundred" + (midLow > 0 ? " " + res : "");
	    }

	    return res;
	}
    }

    // if use more .trim()
    class Solution3 {
	public String numberToWords(int num) {
	    StringBuilder res = new StringBuilder(); // underThousand(num %
						     // 1000);
	    String[] units = new String[] { "Billion", "Million", "Thousand", "" };

	    int div = 1000000000;
	    for (int i = 0; i < 4; i++) {
		String seg = underThousand(num / div);
		if (!seg.isEmpty()) {
		    res.append(seg).append(" ").append(units[i]).append(" ");
		}

		num = num % div;
		div /= 1000;
	    }
	    return res.length() == 0 ? "Zero" : res.toString().trim();
	}

	// returns "" if num is 0.
	private String underThousand(int num) {
	    String[] arr1 = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
		    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
		    "Nineteen" };
	    String[] arr2 = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
		    "Ninety" };
	    StringBuilder res = new StringBuilder();

	    int high = num / 100;
	    int midLow = num % 100;
	    int low = num % 10;

	    if (high > 0) {
		res.append(arr1[high]).append(" Hundred ");
	    }

	    if (midLow < 20) {
		res.append(arr1[midLow]);
	    } else {
		res.append(arr2[midLow / 10]).append(" ").append(arr1[low]);
	    }

	    return res.toString().trim();
	}
    }

}
