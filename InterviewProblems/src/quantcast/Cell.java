package quantcast;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Cell {

	String input;
	String name;

	double evaluatedValue;
	boolean evaluated;

	ArrayList<String> references = new ArrayList<String>();
	ArrayList<Token> tokens = new ArrayList<Token>();
	
	volatile transient int edgeCount;

	public void setInput(String input) {
		this.input = input;
		StringTokenizer st = new StringTokenizer(input);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if ("+".equals(token)) {
				tokens.add(new Token(2));
			} else if ("-".equals(token)) {
				tokens.add(new Token(3));
			} else if ("*".equals(token)) {
				tokens.add(new Token(4));
			} else if ("/".equals(token)) {
				tokens.add(new Token(5));
			} else if ("++".equals(token)) {
				tokens.add(new Token(6));
			} else if ("--".equals(token)) {
				tokens.add(new Token(7));
			} else {
				char c = token.charAt(0);
				if ('A' <= c && c <= 'Z') {
					// reference
					tokens.add(new Token(token));
					references.add(token);
				} else {
					// integer
					double d = Double.valueOf(token);
					tokens.add(new Token(d));
				}
			}
		}
	}

	public double evaluate() throws CircularDependancyException {		
		if (evaluated)
			return evaluatedValue;

		Stack<Double> stack = new Stack<Double>();
		double eval, arg2, arg1;
		for (Token token : tokens) {
			switch (token.type) {
			case 0:
				stack.push(token.value);
				break;
			case 1:
				Cell reference = Spreadsheet.cells[token.referenceRow][token.referenceColumn];
				eval = reference.evaluate();
				stack.push(eval);
				break;
			case 2:
				arg1 = stack.pop();
				arg2 = stack.pop();
				eval = arg2 + arg1;
				stack.push(eval);
				break;
			case 3:
				arg1 = stack.pop();
				arg2 = stack.pop();
				eval = arg2 - arg1;
				stack.push(eval);
				break;
			case 4:
				arg1 = stack.pop();
				arg2 = stack.pop();
				eval = arg2 * arg1;
				stack.push(eval);
				break;
			case 5:
				arg1 = stack.pop();
				arg2 = stack.pop();
				eval = arg2 / arg1;
				stack.push(eval);
				break;
			case 6:
				arg1 = stack.pop();
				eval = arg1 + 1;
				stack.push(eval);
				break;
			case 7:
				arg1 = stack.pop();
				eval = arg1 - 1;
				stack.push(eval);
				break;
			}
		}
		evaluatedValue = stack.pop();
		evaluated = true;
		return evaluatedValue;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
