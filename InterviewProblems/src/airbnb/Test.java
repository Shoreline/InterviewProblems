package airbnb;

public class Test {

    public static void main(String[] args) {
	String s1 ="Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
	String s2 = "\"\"\"Alexandra Alex\"\"\"";
	String s3 = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1";
	System.out.println(new ParseCSV().new Method3().parseCSV(s2));
    }

}
