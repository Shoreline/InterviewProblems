package linkedin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

class Point {
    int x;
    int y;

    // this is the constructor for the Point class
    public Point(int x, int y) {
	this.x = x;
	this.y = y;
    }

    // this function is used to get the distance of a point from the origin
    public double getDistanceFromOrigin() {
	return Math.sqrt((this.x) * (this.x) + (this.y) * (this.y));
    }
}

public class FindNClosestPointsToOrigin {

    // this is a custom comparator we use to arrange points in a PriorityQueue
    // public static Comparator<Point> pointComparator = new Comparator<Point>()
    // {
    // public int compare(Point p1, Point p2) {
    // if (p2.getDistanceFromOrigin() > p1.getDistanceFromOrigin())
    // return 1;
    // else if (p2.getDistanceFromOrigin() < p1.getDistanceFromOrigin())
    // return -1;
    // else
    // return 0;
    // }
    // };

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader(new File("NClosestPointsToOrigin.txt")));
	int n = Integer.parseInt(br.readLine());
	// PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(n,
	// pointComparator);
	PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(n, new Comparator<Point>() {
	    @Override
	    public int compare(Point p1, Point p2) {
		return (int) (p1.getDistanceFromOrigin() - p2.getDistanceFromOrigin());
	    }
	});

	// add first n points in the max heap
	while (maxHeap.size() < n) {
	    String[] temp = br.readLine().split("\\s+");
	    int x = Integer.parseInt(temp[0]);
	    int y = Integer.parseInt(temp[1]);
	    Point newPoint = new Point(x, y);
	    maxHeap.add(newPoint);
	}

	// check for other candidate points in the plane which are closest to
	// the origin
	String temp;
	while ((temp = br.readLine()) != null) {
	    String[] tempArray = temp.split("\\s+");
	    int x = Integer.parseInt(tempArray[0]);
	    int y = Integer.parseInt(tempArray[1]);
	    Point newPoint = new Point(x, y);
	    if (maxHeap.peek().getDistanceFromOrigin() > newPoint.getDistanceFromOrigin()) {
		maxHeap.poll();
		maxHeap.add(newPoint);
	    }
	}
	br.close();

	System.out.println("The " + n + " closest points to origin are as follows - ");
	while (!maxHeap.isEmpty()) {
	    Point p = maxHeap.poll();
	    System.out.println(p.x + " " + p.y + " " + p.getDistanceFromOrigin());
	}

    }
}