package quantcast;

public class Token {

	public Token(int type) {
		this.type = type;
	}

	public Token(String reference) {
		type = 1;
		referenceRow = reference.charAt(0)-65;
		referenceColumn = Integer.valueOf(reference.substring(1))-1;
	}

	public Token(double d) {
		type = 0;
		value = d;
	}

	// 0 = value
	// 1 = reference
	// 2 = operator+
	// 3 = operator-
	// 4 = operator*
	// 5 = operator/
	// 6 = operator ++
	// 7 = operator --
	int type;
	
	int operatorType;
	double value;
	int referenceRow;
	int referenceColumn;
	
	@Override
	public String toString() {
		switch (type) {
		case 0:
			return String.valueOf(value);
		case 1:
			return String.valueOf((char)(referenceRow+65)+referenceColumn);
		case 2:
			return "+";
		case 3:
			return "-";
		case 4:
			return "*";
		case 5:
			return "/";
		case 6:
			return "++";
		case 7:
			return "--";
		}
		return super.toString();
	}
}
