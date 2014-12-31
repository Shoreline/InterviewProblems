package array;

public class PlusOne {
    /**
     * Plus One
     * 
     * Given a number represented as an array of digits, plus one to the number.
     */
    public int[] plusOne(int[] digits) {

	int carrier = 1;

	for (int i = digits.length - 1; i >= 0; i--) {
	    if (digits[i] + carrier > 9) {
		digits[i] = digits[i] + carrier - 10;
		carrier = 1;
	    } else {
		digits[i] = digits[i] + carrier;
		carrier = 0;
		break;
	    }
	}

	if (carrier == 0) {
	    return digits;
	} else {
	    int[] result = new int[digits.length + 1];
	    result[0] = carrier;

	    for (int i = 0; i < digits.length; i++) {
		result[i + 1] = digits[i];
	    }

	    return result;
	}

    }
}
