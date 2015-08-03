package facebook;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
	Set<Character> input = new HashSet<>();
	input.add('a');
	input.add('b');
	input.add('c');

	System.out.println(new CombinationsFBII().new Method2().combination(input,
		2));
    }

}
