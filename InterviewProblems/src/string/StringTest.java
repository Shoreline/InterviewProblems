package string;

import java.util.Arrays;

public class StringTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	PalindromeNumber.isPalindrome(1);

	System.out.println("hello word");

	String str1 = "hello fuck";
	String str2 = "fuck helosl";

	System.out.println(PermutationCheck.isPermutation(str1, str2));

	String strSort = "23omlske402lskf";
	char[] aCharArray = strSort.toCharArray();
	Arrays.sort(aCharArray);
	// Arrays.sort(aCharArray, Comparator<char a1, char a2>)
	String strSorted = new String(aCharArray);
	System.out.println(strSorted);

	String strPalindrome = "FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequalNowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
	System.out.println(LongestPalindrome
		.getLongestPalindrome(strPalindrome));

	System.out.println("=============");
	System.out.println(AddBinary.addBinary2("1101", "1111"));

	System.out.println("=============");
	int fib = PrimeFib.getPrimeFib(227000);
	System.out.println(fib);
	System.out.println(PrimeFib.getPrimeDiversorSum(fib + 1));

	System.out.println("=============");
	System.out.println(CountAndSay.countAndSay(6));

	System.out.println("=============");
	System.out.println(DecodeWays.numDecodings("01"));

	System.out.println("=============");
	System.out.println(DivideTwoIntegers.divideHighHand(207, 32));

	System.out.println("=============");
	System.out.println(EditDistance.minDistance("ab", "a"));

    }
}
