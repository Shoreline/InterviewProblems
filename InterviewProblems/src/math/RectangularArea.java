package math;

public class RectangularArea {
    public class Solution {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	    // get overlap rectangular
	    int left = Math.max(A, E);
	    int right = Math.min(C, G);
	    int top = Math.min(D, H);
	    int bottom = Math.max(B, F);

	    int overlap = 0;
	    if (top > bottom && left < right) {
		overlap = (top - bottom) * (right - left);
	    }

	    int area1 = (C - A) * (D - B);
	    int area2 = (G - E) * (H - F);

	    return area1 + area2 - overlap;
	}
    }
}
