package quantcast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Spreadsheet {

    static String input = "F:/Downloads/quantcast-spreadsheet coding test/input.txt";

    static int n; // column (width) 3 : 1..n
    static int m; // rows (height) 26 : A..Z

    static Cell[][] cells;

    // static List<Cell> topologicalSortL = new ArrayList<Cell>();
    static LinkedList<Cell> topologicalSortS = new LinkedList<Cell>(); // save
								       // cells
								       // that
								       // have
								       // expressions
								       // needed
								       // to be
								       // calculated

    static HashMap<String, LinkedList<Cell>> dependancyMap = new HashMap<String, LinkedList<Cell>>(
	    10000);

    static void testCode() throws CircularDependancyException {
	Cell testCell = new Cell();
	testCell.setInput("-100 1 *");
	System.out.println(testCell.evaluate());
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	try {
	    if (args.length > 0)
		input = args[0];
	    sc = new Scanner(new File(input));
	} catch (Exception e) {

	}

	n = sc.nextInt();
	m = sc.nextInt();
	sc.nextLine();

	try {

	    cells = new Cell[26][];
	    for (int row = 0; row < m; row++) {
		cells[row] = new Cell[n];
		for (int col = 0; col < n; col++) {
		    Cell cell = cells[row][col] = new Cell();
		    String input = sc.nextLine().toUpperCase();
		    cell.setInput(input);

		    // just for fun setting the name;
		    cell.setName((char) ('A' + row) + String.valueOf(col + 1));
		    cell.edgeCount = cell.references.size();
		    if (cell.edgeCount == 0) { // at this time, all cells will
					       // have edgeCount=0. edgeCount is
					       // initilized to be 0 by the
					       // default constructor.
			topologicalSortS.add(cell);
		    } else {
			ArrayList<String> references = cell.references;
			for (String string : references) {
			    addDependancyMap(string, cell);
			}
		    }
		}
	    }

	    // do topological sort
	    int countEvaluated = 0;
	    while (topologicalSortS.size() > 0) {
		Cell cell = topologicalSortS.removeFirst();
		cell.evaluate();
		countEvaluated++;
		// topologicalSortL.add(cell);

		// get every cell x that refer cell y
		LinkedList<Cell> list = dependancyMap.get(cell.name);
		if (null == list)
		    continue;
		for (Cell cellx : list) {
		    cellx.edgeCount--;
		    if (cellx.edgeCount == 0) {
			topologicalSortS.add(cellx);
		    }
		}
	    }

	    if (countEvaluated < n * m)
		throw new CircularDependancyException(
			"circular dependency detected: " + countEvaluated
				+ " cells evaluated");

	    System.out.println(n + " " + m);
	    for (int row = 0; row < m; row++) {
		for (int col = 0; col < n; col++) {
		    Cell cell = cells[row][col];
		    double d = cell.evaluate();
		    String s = String.format("%.5f", d);
		    System.out.println(s);
		}
	    }

	} catch (CircularDependancyException e) {
	    System.out.println(e.getMessage());
	    System.exit(1);
	}
    }

    private static void addDependancyMap(String string, Cell cell) {
	LinkedList<Cell> list = dependancyMap.get(string);
	if (null == list) {
	    list = new LinkedList<Cell>();
	    dependancyMap.put(string, list);
	}
	list.add(cell);
    }

}
