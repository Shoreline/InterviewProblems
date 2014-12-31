package Testing;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Tokenizer {
    private static final int BUFFER_SIZE = 0x1000000;

    private static HashMap<String, Integer> frequency = new HashMap<String, Integer>();
    private static HashMap<String, Integer> lastLineNum = new HashMap<String, Integer>();
    private static ArrayList<String> fileContent = new ArrayList<String>();
    private static ArrayList<String> byTerm = new ArrayList<String>();
    private static ArrayList<String> byPos = new ArrayList<String>();

    public static void main(String[] args) {

	try {
	    load(args[0]);

	} catch (Exception e) {

	    e.printStackTrace();
	}

	if (args.length == 1) {
	    for (String word : fileContent) {
		System.out.println(word);
	    }
	} else {
	    if (args[1].equals("--all-by-term")) {
		sortByTerm();
		for (String word : byTerm) {
		    System.out.println(word);
		}

	    } else if (args[1].equals("--all-by-pos")) {
		sortByPos();
		for (String word : byPos) {
		    System.out.println(word);
		}

	    } else {
		System.out.println(frequency.get(args[1].toLowerCase()));
	    }
	}
    }

    private static void load(String inputFile) throws Exception {

	File in = new File(inputFile);
	BufferedInputStream streamFromFile = new BufferedInputStream(
		new FileInputStream(in));
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		streamFromFile, "utf-8"), BUFFER_SIZE);

	ArrayList<String> content = new ArrayList<String>();
	HashMap<String, Integer> lastLine = new HashMap<String, Integer>();
	HashMap<String, Integer> fre = new HashMap<String, Integer>();

	String line = "";
	int counter = 0;
	while ((line = reader.readLine()) != null) {
	    counter++;
	    line = line.replaceAll("\\p{Punct}", "");

	    String[] words = line.split(" |\t|\r|\n");

	    for (int i = 0; i < words.length; i++) {
		if (!words[i].isEmpty()) {
		    content.add(words[i]);

		    // construct two hashmaps
		    String wordLowerCase = words[i].toLowerCase();

		    lastLine.put(wordLowerCase, counter);

		    if (!fre.containsKey(wordLowerCase)) {
			fre.put(wordLowerCase, 1);
		    } else {
			fre.put(wordLowerCase, fre.get(wordLowerCase) + 1);
		    }

		}
	    }

	}

	reader.close();

	fileContent = content;
	lastLineNum = lastLine;
	frequency = fre;

    }

    private static void sortByTerm() {
	String[] terms = new String[frequency.size()];
	int j = 0;
	for (Map.Entry<String, Integer> anEntry : frequency.entrySet()) {
	    terms[j] = anEntry.getKey();
	    j++;
	}

	Arrays.sort(terms);

	ArrayList<String> bt = new ArrayList<String>();
	for (int i = 0; i < terms.length; i++) {
	    bt.add(frequency.get(terms[i]) + "\t" + lastLineNum.get(terms[i])
		    + "\t" + terms[i]);
	}
	byTerm = bt;
    }

    private static void sortByPos() {
	ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
		lastLineNum.entrySet());
	Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	    @Override
	    public int compare(Map.Entry<String, Integer> o1,
		    Map.Entry<String, Integer> o2) {
		return (o2.getValue() - o1.getValue()); // descending sort
	    }
	});

	ArrayList<String> bp = new ArrayList<String>();
	for (Map.Entry<String, Integer> anEntry : list) {
	    bp.add(frequency.get(anEntry.getKey()) + "\t" + anEntry.getValue()
		    + "\t" + anEntry.getKey());
	}
	byPos = bp;
    }

}
