package linkedin;

import java.util.*;

public class FindKNearestPoints {
    /*
     * No need to modify Point class
     */
    class Method1 {
	class Point {
	    int x, y;
	    double dist;

	    public Point(int x, int y) {
		this.x = x;
		this.y = y;
	    }
	}

	private double getDist(Point p1, Point p2) {
	    return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
	}

	public List<Point> getClosestPoints(List<Point> points, int k, Point o) {
	    final Point x = o;
	    PriorityQueue<Point> minHeap = new PriorityQueue<Point>(k, new Comparator<Point>() {
		@Override
		public int compare(Point p1, Point p2) {

		    if (getDist(p1, x) - getDist(p2, x) > 0) {
			return 1;
		    } else if (getDist(p1, x) - getDist(p2, x) < 0) {
			return -1;
		    } else {
			return 0;
		    }
		}
	    });

	    for (Point p : points) {
		minHeap.add(p);
	    }

	    return new ArrayList<Point>(minHeap);
	}
    }

    class Method2 {
	class Point implements Comparable<Point> {
	    int x, y;
	    double dist;

	    public Point(int x, int y, Point originPoint) {
		this.x = x;
		this.y = y;
		this.dist = Math.hypot(x - originPoint.x, y - originPoint.y);
	    }

	    public Point(int x, int y) {
		this.x = x;
		this.y = y;
	    }

	    @Override
	    public int compareTo(Point p) {
		return Double.valueOf(p.dist).compareTo(this.dist);
	    }
	}

	public List<Point> getClosestPoints(List<Point> points, int k) {
	    PriorityQueue<Point> queue = new PriorityQueue<Point>(k);

	    for (Point point : points) {
		if (queue.size() < k) {
		    queue.offer(point);
		} else {
		    if (queue.peek().compareTo(point) < 0) {
			queue.poll();
			queue.offer(point);
		    }
		}
	    }

	    return new ArrayList<Point>(queue);
	}
    }
}
