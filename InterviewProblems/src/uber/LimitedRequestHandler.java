package uber;

import uber.LimitedRequestHandler.Solution.Myapp;
import uber.LimitedRequestHandler.Solution.Request;

/**
 * myapp.com/v1/api - 100 requests/second rate limit
 */

public class LimitedRequestHandler {

    // class MyApp {
    // public ... HandleRequest(..) {
    // // make sure that you don't process more than 100/second
    // }
    // }

    class Solution {
	class Request {
	    public long ts; // ms
	    public long val;
	}

	class Myapp {
	    int size = 10;
	    long[] buffer = new long[size];
	    int start = -1; // index of the first element
	    int tail = 0; // index of next element to insert

	    public void handleRequest(Request r) {
		if (tail == start && r.ts - buffer[start] < 1000) {
		    System.out.println("over limit!");
		    return;
		}

		buffer[tail] = r.ts;
		if (start == tail || start == -1) {
		    start = (start + 1) % size;
		}

		tail = (tail + 1) % size;

		System.out.println(r.val);
	    }

	}

    }

    /**
     * t=0.20s - 10 requests - OK t=0.80s - 1 request - NOT OK t=1.30s - 3
     * requests - OK
     */
    public static void main(String[] args) {
	Myapp myapp = new LimitedRequestHandler().new Solution().new Myapp();

	System.out.println();
	for (int i = 0; i < 10; i++) {
	    Request r = new LimitedRequestHandler().new Solution().new Request();
	    // currentTimeMillis
	    // r.ts = System.currentTimeMillis();
	    // r.val = System.currentTimeMillis();
	    r.ts = 200;
	    r.val = r.ts;

	    myapp.handleRequest(r);
	}

	Request r2 = new LimitedRequestHandler().new Solution().new Request();
	r2.ts = 800;
	r2.val = r2.ts;
	myapp.handleRequest(r2);

	for (int i = 0; i < 3; i++) {
	    Request r = new LimitedRequestHandler().new Solution().new Request();
	    r.ts = 1300;
	    r.val = r.ts;
	    myapp.handleRequest(r);
	}
    }
}
