package tripadvisor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Arguments: 
 * 1) file name for a list of synonyms 
 * 2) input file 1 
 * 3) input file 2 
 * 4) (optional) the number N, the tuple size. If not supplied, the default
 * should be N=3.
 *
 */
public class PlagiarismDetector {
    Set<String> syns;
    List<String> file1;
    List<String> file2;
    int N;

    public PlagiarismDetector(Set<String> syns, List<String> file1,
	    List<String> file2, int n) {
	this.syns = syns;
	this.file1 = file1;
	this.file2 = file2;
	N = n;
    }

    public PlagiarismDetector(String _syns, String _file1, String _file2, int n) {
	try {
	    syns = new HashSet<String>(readFile(_syns));
	    file1 = readFile(_file1);
	    file2 = readFile(_file2);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	N = n;
    }

    public static void main(String[] args) {
	if (args.length < 3) {
	    System.out.println("Invalid arguments");
	    System.out
		    .println("PlagiarismDetector [synonyms file] [input file 1] [input file 2] [(optional) tuple size]");
	    System.exit(1);
	}

	int tupleSize = args.length > 3 ? Integer.parseInt(args[3]) : 3;

	PlagiarismDetector pd = new PlagiarismDetector(args[0], args[1],
		args[2], tupleSize);
	System.out.println(pd.detect() * 100 + "%");
    }

    List<String> readFile(String fileName) throws IOException {

	List<String> res = new ArrayList<String>();
	BufferedReader br = null;
	try {
	    br = new BufferedReader(new FileReader(fileName));
	    String line = br.readLine();

	    while (line != null) {
		for (String word : line.split(" ")) {
		    res.add(word);
		}
		line = br.readLine();
	    }

	} finally {
	    if (br != null) {
		br.close();
	    }
	}
	return res;
    }

    private double detect() {
	if (file1.size() < N) {
	    return 0;
	}

	int count = 0;
	for (int i = 0; i <= file1.size() - N; i++) {
	    for (int j = 0; j <= file2.size() - N; j++) {
				
		int k = 0;
		while (k < N && equals(file1.get(i + k), file2.get(j + k))) {
		    k++;
		}

		count = k == N ? count + 1 : count;
	    }
	}

	return (double) count / (file1.size() - N + 1);
    }

    private boolean equals(String s1, String s2) {
	if (s1.equals(s2)) {
	    return true;
	} else if (syns.contains(s1)) {
	    for (String word : syns) {
		if (word.equals(s2)) {
		    return true;
		}
	    }
	}

	return false;
    }
}
