package uber;

import java.util.*;

/**
 * Design a Spread Sheet
 *
 */

/*
 * (A spread sheet is similar to a functional language?)
 * 
 * Each cell is either a function or value; each cell can be referenced and used
 * in other cell. The
 * 
 * Change the value of a cell, all other cells depending on it will
 * automatically change accordingly. -> This sequence of change must be
 * performed in topological order
 */

public class DesignAnExcel {

    class Method {
	/*
	 * The idea is to use a Map<Integer, Map<Integer, Cell>> to save data:
	 * Map<RowNumber, Map<ColNumber,CellContent>>
	 */
	class Cell { // maybe to use an interface.
	    int value;	// saves the direct value of this cell.
	    String formula;
	    List<Cell> parents;
	    List<Cell> children;
	}

	class SpreadSheet {
	    private static final int MAX_CELL_INDEX = 65000;
	    private final Map<Integer, Map<Integer, Cell>> data = new HashMap<>();

	    public void setValue(int row, int column, Cell value) {
		// checkRowAndColumnIndex(row, column);
		Map<Integer, Cell> columnsMap = data.get(row);
		if (columnsMap == null) {
		    columnsMap = new HashMap<>();
		    data.put(row, columnsMap);
		}
		columnsMap.put(column, value);
		
	    }

	    public Cell getValue(int row, int column) {
		// checkRowAndColumnIndex(row, column);
		Map<Integer, Cell> columnsMap = data.get(row);
		if (columnsMap != null) {
		    return columnsMap.get(column);
		}
		return null;
	    }
	}
    }
}