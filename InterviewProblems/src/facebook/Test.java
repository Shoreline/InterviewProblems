package facebook;

import java.util.*;

public class Test {

    public static void main(String[] args) {
	
	String[] input = new String[]{"foo", "foog", "food", "asdf"};
	System.out.println(new SmallestPrefixSubset().new Method_noTrie().smallestPrefixSubset(input));
	
	int[] tasks = new int[]{1,2,1,2};
	System.out.println(new TasksExecutionTime().new Method().getExecTime(tasks, 3));
    }

}
