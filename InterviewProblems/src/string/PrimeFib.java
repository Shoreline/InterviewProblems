package string;

public class PrimeFib {

    public static int getPrimeFib(int target) {
	int result = 0;

	int fib1 = 1;
	int fib2 = 1;

	while (result <= target || !isPrime(result)) {
	    int temp = fib2;
	    fib2 = fib1 + fib2;
	    fib1 = temp;
	    result = fib1 + fib2;
	}

	// result = fib1 + fib2;
	return result;
    }

    public static boolean isPrime(int input) {

	for (int i = 2; i < Math.sqrt(input); i++) {
	    if (input % i == 0) {
		return false;
	    }
	}

	return true;
    }

    public static int getPrimeDiversorSum(int input) {
	int sum = 0;

	for (int i = 2; i < input; i++) {
	    if (input % i == 0 && isPrime(i)) {
		sum += i;
	    }
	}

	return sum;
    }
}
