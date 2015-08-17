package linkedin;

public class CubicRoot {
    /*
     * Newton's method
     * 
     * z_next = (2*z + x/(z^2) )/3
     */
    class Solution {
	public int cubicRoot(int x) {
	    if (x == 0) {
		return 0;
	    }

	    double res = x / 3.0;
	    double pre = 0;
	    while (pre != res) {
		pre = res;
		res = (2 * pre + x / (pre * pre)) / 3;
	    }

	    return (int) res;
	}
    }

}
