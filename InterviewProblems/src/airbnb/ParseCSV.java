package airbnb;

import java.util.*;

/**
 * 给定一个CSV文件，格式是 “some_name|some_address|some_phone|some_job”，
 * 
 * 要求输出Json format “{name:some_name, address:some_addres,phone:some_phone,
 * job:some_job}”
 *
 * 特殊情况为两个引号之间的分号，不可作为分割字符
 * 
 * John,Smith,john.smith@gmail.com,Los Angeles,1
 * 
 * Jane,Roberts,janer@msn.com,"San Francisco, CA",0
 * 
 * "Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
 * 
 * """Alexandra Alex"""
 * 
 * John|Smith|john.smith@gmail.com|Los Angeles|1
 * 
 * Jane|Roberts|janer@msn.com|San Francisco, CA|0
 * 
 * Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
 * 
 * "Alexandra Alex"
 * 
 * 
 * 如果有逗号，转化成| 如果有引号，把不考虑引号里逗号，把引号里的内容去引号整体打印。 如果有两重引号，只去掉一重引号。
 * 
 * 例子 aa, bb, "aa","aa,bb", "aa""aa"""
 * 
 * 输出 aa|bb|aa|aa,bb|aa"aa"
 */
public class ParseCSV {

    class Method3 {
	public String parseCSV(String line) {
	    StringBuilder res = new StringBuilder();
	    StringBuilder part = new StringBuilder();

	    int quote = 0;
	    char delimiter = ',';

	    for (int i = 0; i <= line.length(); i++) {
		char c = i < line.length() ? line.charAt(i) : delimiter;
		if (c == delimiter) {
		    if (quote % 2 == 1) {
			part.append(c);
		    } else {
			if (quote > 0) {
			    String tmp = part.toString();
			    // get rid of the first layer of quote
			    int a = tmp.indexOf('"');
			    int b = tmp.lastIndexOf('"');
			    res.append(tmp.substring(0, a));
			    res.append(tmp.substring(a + 1, b));
			    res.append(tmp.substring(b + 1, tmp.length()));
			    
			    // get rid of unnecessary quotes?
			    
			    res.append('|');
			    quote = 0;
			} else {
			    res.append(part.toString()).append("|");
			}

			part.setLength(0);
		    }
		} else if (c == '"') {
		    quote++;
		    part.append(c);
		} else {
		    part.append(c);
		}
	    }
	    
	    if (res.length() > 0) {
		res.setLength(res.length() - 1);
	    }
	    return res.toString();//.replaceAll("\"\"", "\""); // not correct
	}
    }

    class Method2 {
	public String parseCSV1(String str) {
	    StringBuilder res = new StringBuilder();
	    StringBuilder part = new StringBuilder();

	    boolean isQuote = false;
	    for (int i = 0; i < str.length(); i++) {
		char c = str.charAt(i);
		if (isQuote) {
		    if (c == '\"') {
			if (i == str.length() - 1)
			    return res.append(part.toString()).toString();
			else if (str.charAt(i + 1) == '\"') {
			    part.append('\"');
			    i++;
			} else
			    isQuote = false;
		    } else
			part.append(c);
		} else {
		    if (c == ',') {
			part.append('|');
			res.append(part.toString());
			part.setLength(0);
		    } else if (c == '\"') {
			isQuote = true;
		    } else
			part.append(c);
		}
	    }
	    return res.append(part.toString()).toString();
	}

    }

    class Method {
	public List<String> parseCSV(String str) {
	    List<String> res = new ArrayList<String>();
	    boolean inQuote = false;
	    StringBuilder record = new StringBuilder();

	    for (int i = 0; i < str.length(); i++) {
		if (inQuote) {
		    if (str.charAt(i) == '"') {
			if (i == str.length() - 1) {
			    res.add(record.toString());
			    return res;
			} else if (str.charAt(i + 1) == '"') {
			    record.append('"');
			    i++;
			} else {
			    res.add(record.toString());
			    record.setLength(0);
			    inQuote = false;
			    i++;
			}
		    } else
			record.append(str.charAt(i));
		} else {
		    if (str.charAt(i) == '"') {
			inQuote = true;
		    } else if (str.charAt(i) == ',') {
			res.add(record.toString());
			record.setLength(0);
		    } else {
			record.append(str.charAt(i));
		    }

		}

	    }

	    if (record.length() > 0)
		res.add(record.toString());
	    return res;
	}

    }
}

