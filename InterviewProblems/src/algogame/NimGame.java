package algogame;

import java.util.*;

public class NimGame {
    /*
     * 当n∈[1,3]时，先手必胜。
     * 
     * 当n == 4时，无论先手第一轮如何选取，下一轮都会转化为n∈[1,3]的情形，此时先手必负。
     * 
     * 当n∈[5,7]时，先手必胜，先手分别通过取走[1,3]颗石头，可将状态转化为n == 4时的情形，此时后手必负。
     * 
     * 当n == 8时，无论先手第一轮如何选取，下一轮都会转化为n∈[5,7]的情形，此时先手必负。 ......
     * 
     * 以此类推，可以得出结论：
     * 
     * 当n % 4 != 0时，先手必胜；否则先手必负。
     */
    public class Solution {
	public boolean canWinNim(int n) {
	    return n % 4 != 0;
	}
    }

    public class Method_tle2 {
	public boolean canWinNim(int n) {
	    Set<Integer> win = new HashSet<>();
	    win.add(1);
	    win.add(2);
	    win.add(3);

	    boolean canWin = true;
	    for (int i = 4; i <= n; i++) {
		canWin = true;
		for (int j = 1; j <= 3; j++) {
		    if (win.contains(i - j)) {
			canWin = false;
			break;
		    }
		}
		if (canWin) {
		    win.add(i);
		}
	    }

	    return canWin;
	}
    }

    public class Method_tle {
	Set<Long> win = new HashSet<>();

	public boolean canWinNim(int n) {
	    if (n <= 3 || win.contains(n)) {
		return true;
	    }
	    for (int i = 1; i <= 3; i++) {
		if (!canWinNim(n - i)) {
		    win.add((long) (n - i));
		    return true;
		}
	    }

	    return false;
	}
    }
}
