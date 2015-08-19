package string;

public class AddStrings {
    class Method {
	public String addStrings(String a, String b) {
	    if (a.length() < b.length()) {
		return addStrings(b, a);
	    }

	    // int lenA = a.length();
	    // int lenB = b.length();

	    char[] res = new char[a.length()];
	    int carry = 0;
	    for (int i = 0; i < a.length(); i++) {
		int val1 = a.charAt(a.length() - 1 - i) - '0';
		int val2 = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
		int sum = val1 + val2 + carry;
		res[a.length() - 1 - i] = (char) ('0' + sum % 10);
		carry = sum / 10;
	    }

	    return carry > 0 ? "1" + new String(res) : new String(res);
	}
    }
}
