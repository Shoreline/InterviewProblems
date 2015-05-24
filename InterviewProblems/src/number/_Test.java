package number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _Test {

    public static void main(String[] args) {
	String[] haha = new String[] { "a@b", "aaa", "c@d" };
	for (String str : haha) {
	    try {
		System.out.println(str.split("@")[1]);
	    }

	    catch (Exception e) {
		System.out.println("wrong: " + str);
	    }
	}
    }
}
