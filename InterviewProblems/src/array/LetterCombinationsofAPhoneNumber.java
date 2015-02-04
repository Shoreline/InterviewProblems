package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofAPhoneNumber {
    /**
     * Letter Combinations of a Phone Number
     * 
     * Given a digit string, return all possible letter combinations that the
     * number could represent.
     * 
     * A mapping of digit to letters (just like on the telephone buttons) is
     * given below.
     * 
     * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
     * "cd", "ce", "cf"]. Note: Although the above answer is in lexicographical
     * order, your answer could be in any order you want.
     */

    /*
     * similar to solution 1
     */
    public class Solution2 {
	public List<String> letterCombinations(String digits) {
	    List<String> res = new ArrayList<String>();

	    if (digits == null || digits.length() == 0) {
		res.add("");
		return res;
	    }

	    Map<Character, char[]> keyboard = new HashMap<Character, char[]>();
	    keyboard.put('0', " ".toCharArray());
	    keyboard.put('1', "".toCharArray());
	    keyboard.put('2', "abc".toCharArray());
	    keyboard.put('3', "def".toCharArray());
	    keyboard.put('4', "ghi".toCharArray());
	    keyboard.put('5', "jkl".toCharArray());
	    keyboard.put('6', "mno".toCharArray());
	    keyboard.put('7', "pqrs".toCharArray());
	    keyboard.put('8', "tuv".toCharArray());
	    keyboard.put('9', "wxyz".toCharArray());

	    List<StringBuilder> sbList = letterCombinationshelp(digits.toCharArray(),
		    digits.length() - 1, keyboard);
	    for (StringBuilder sb : sbList) {
		res.add(sb.toString());
	    }

	    return res;
	}

	private List<StringBuilder> letterCombinationshelp(char[] digits, int ptr,
		Map<Character, char[]> keyboard) {
	    List<StringBuilder> res = new ArrayList<StringBuilder>();
	    
	    if (ptr == 0) {
		for (char c : keyboard.get(digits[ptr])) {
		    StringBuilder sb = new StringBuilder();
		    sb.append(c);
		    res.add(sb);
		}
		return res;
	    }

	    for (char c : keyboard.get(digits[ptr])) {
		List<StringBuilder> tmp = letterCombinationshelp(digits, ptr - 1, keyboard);
		for (StringBuilder sb : tmp) {
		    StringBuilder newSB = new StringBuilder(sb);
		    newSB.append(c);
		    res.add(newSB);
		}
	    }

	    return res;
	}
    }

    /*
     * The HashMap can be replaced by a normal array and remain same time
     * complexity
     */
    public static class Solution1 {
	public static ArrayList<String> letterCombinations(String digits) {
	    ArrayList<String> result = new ArrayList<String>();

	    if (digits == null || digits.length() == 0) {
		// corner case! add an empty string to result.
		result.add("");
		return result;
	    }

	    digits = digits.replaceAll("1", ""); // simple way to handle "1"s

	    HashMap<Character, String> keyboard = new HashMap<Character, String>();
	    keyboard.put('2', "abc");
	    keyboard.put('3', "def");
	    keyboard.put('4', "ghi");
	    keyboard.put('5', "jkl");
	    keyboard.put('6', "mno");
	    keyboard.put('7', "pqrs");
	    keyboard.put('8', "tuv");
	    keyboard.put('9', "wxyz");
	    keyboard.put('0', " ");

	    ArrayList<StringBuilder> resultBuilder = letterCombinations(digits,
		    keyboard);

	    for (StringBuilder aStr : resultBuilder) {
		result.add(aStr.toString());
	    }

	    return result;
	}

	private static ArrayList<StringBuilder> letterCombinations(
		String digits, HashMap<Character, String> keyboard) {

	    ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();

	    if (digits == null || digits.length() == 0) {
		return result;
	    }
	    if (digits.length() == 1) {

		String letters = keyboard.get(digits.charAt(0));
		for (int i = 0; i < letters.length(); i++) {
		    StringBuilder newStr = new StringBuilder();
		    newStr.append(letters.charAt(i));
		    result.add(newStr);
		}
		return result;
	    }

	    String letters = keyboard.get(digits.charAt(digits.length() - 1));
	    ArrayList<StringBuilder> temp = letterCombinations(
		    digits.substring(0, digits.length() - 1), keyboard);
	    // *Do not add original temp back!
	    // result.addAll(temp);
	    for (StringBuilder aString : temp) {
		for (int j = 0; j < letters.length(); j++) {
		    StringBuilder newStr = new StringBuilder();
		    newStr.append(aString);
		    newStr.append(letters.charAt(j));
		    result.add(newStr);
		}
	    }

	    return result;
	}
    }
}
