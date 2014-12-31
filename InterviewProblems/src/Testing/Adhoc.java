package Testing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Adhoc {
    
    private static final String[] PRIVATE_VALUES = {"a", "b", "c"};
    
    public static final String[] getPrivateValues(){
	return PRIVATE_VALUES.clone();
    }
    
    public static final List<String> getPrivateValueList(){
	return Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
    }

    public static void main(String[] args) {
	Integer a = 20;
	Integer b = 20;
	System.out.println(a==b);
	
	System.out.println(new Integer(20) == new Integer(20));

    }

}
