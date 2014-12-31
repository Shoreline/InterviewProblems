package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PermutationCheck {

	public static boolean isPermutation(String firstString, String secondString) {

//		if (firstString.length() != secondString.length()) {
//			return false;
//		}

		char[] charArray1 = firstString.toCharArray();
		char[] charArray2 = secondString.toCharArray();
		
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		
		if (!Arrays.equals(charArray1, charArray2)){
			return false;
		}
		

		// ArrayList<Character> charList1 = new ArrayList<Character>();
		// ArrayList<Character> charList2 = new ArrayList<Character>();
		//
		// for (char aChar : charArray1) {
		// charList1.add(aChar);
		// }
		//
		// for (char aChar : charArray2) {
		// charList2.add(aChar);
		// }
		//
		// Collections.sort(charList1);
		// Collections.sort(charList2);
		//
		// Iterator<Character> itr1 = charList1.iterator();
		// Iterator<Character> itr2 = charList2.iterator();
		// while(itr1.hasNext()){
		// Character char1 = itr1.next();
		// Character char2 = itr2.next();
		//
		// if (char1 != char2){
		// return false;
		// }
		//
		// }

		return true;
	}

}
