package string;

import java.util.HashMap;

public class IntegerToRoman {
    /**
     * Integer to Roman
     * 
     * Given an integer, convert it to a roman numeral.
     * 
     * Input is guaranteed to be within the range from 1 to 3999.
     */

    /*
     * Straightforward
     * 
     * M (1000) is a special case, and shall be dealt individually.
     * 其中每两个阶段的之间有一个减法的表示，比如900=CM， C写在M前面表示M-C。
     * 
     * The following solution can be re-written to a iterative version
     * 
     * Some good examples:
     * 
     * 1910 as MDCCCCX; 1954 as MCMLIV; 1990 as MCMXC
     * 
     * *There is a simpler way: check the previous character and current
     * character...?
     * 
     * I started building the Roman number from the left
     */

    class Solution2 {
	public String intToRoman(int num) {
	    if (num < 1 || num > 3999)
		return null;
	    StringBuilder res = new StringBuilder();
	    int val[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	    String roman[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
		    "IX", "V", "IV", "I" };

	    int i = 0;
	    while (num > 0) {
		int count = num / val[i];
		num = num % val[i];
		for (int j = 0; j < count; j++) {
		    res.append(roman[i]);
		}
		i++;
	    }

	    return res.toString();
	}
    }

    class Solution1 {
	public String intToRoman(int num) {
	    HashMap<Integer, Character> ntr = new HashMap<Integer, Character>();
	    ntr.put(1, 'I');
	    ntr.put(5, 'V');
	    ntr.put(10, 'X');
	    ntr.put(50, 'L');
	    ntr.put(100, 'C');
	    ntr.put(500, 'D');
	    ntr.put(1000, 'M');

	    StringBuilder result = new StringBuilder();
	    int temp = num / 1000;
	    num = num % 1000;
	    for (int i = 0; i < temp; i++) {
		result.append('M');
	    }
	    result.append(intToRomanHelp(num, ntr));

	    return result.toString();
	}

	private StringBuilder intToRomanHelp(int num,
		HashMap<Integer, Character> ntr) {
	    StringBuilder result = new StringBuilder();
	    if (num == 0)
		return result;

	    int i = 1;
	    while (num / i > 0) {
		i = i * 10;
	    }
	    i = i / 10;

	    int temp = num / i;
	    num = num % i;
	    char c = ntr.get(i);
	    char c2 = ntr.get(5 * i);
	    char c3 = ntr.get(10 * i);
	    if (temp < 4) {
		for (int j = 0; j < temp; j++) {
		    result.append(c);
		}
	    } else if (temp == 4) {
		result.append(c);
		result.append(c2);
	    } else if (temp == 5) {
		result.append(c2);
	    } else if (temp < 9) {
		result.append(c2);
		for (int j = 0; j < temp - 5; j++) {
		    result.append(c);
		}
	    } else {
		result.append(c);
		result.append(c3);
	    }

	    StringBuilder rest = intToRomanHelp(num, ntr);
	    result.append(rest.toString());
	    return result;
	}
    }
}
