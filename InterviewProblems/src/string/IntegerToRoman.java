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
     * M (1000) is a special case, and shall be dealt individually. The
     * following solution can be re-written to a iterative version
     * 
     * Some good examples:
     * 
     * 1910 as MDCCCCX; 1954 as MCMLIV; 1990 as MCMXC
     * 
     * *There is a simpler way: check the previous character and current
     * character...?
     * 
     * I started building the roman number from the left
     */

    public static String intToRoman(int num) {
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

    private static StringBuilder intToRomanHelp(int num,
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
