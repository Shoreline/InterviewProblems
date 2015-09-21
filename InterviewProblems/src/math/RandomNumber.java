package math;

import java.util.Random;

/*
 * Just for learning random number generator
 */
public class RandomNumber {
    public static void main(String[] args) {
	Random rnd = new Random(12);
	for (int i = 1; i <= 10; i++) {
	    System.out.println(rnd.nextInt(i));
	}
    }
}
