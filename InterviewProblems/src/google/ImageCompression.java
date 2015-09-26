package google;

import java.util.HashMap;
import java.util.Map;

public class ImageCompression {
    class Rect {
	int x1;
	int y1;
	int x2;
	int y2;

	public Rect(int x1, int y1, int x2, int y2) {
	    this.x1 = x1;
	    this.y1 = y1;
	    this.x2 = x2;
	    this.y2 = y2;
	}
    }

    class QTNode // quad-tree node class
    {
	int x1;
	int y1;
	int x2;
	int y2;
	QTNode[] children;
	int color;

	public QTNode(int x1, int y1, int x2, int y2, int color) {
	    this.x1 = x1;
	    this.y1 = y1;
	    this.x2 = x2;
	    this.y2 = y2;
	    this.color = color;
	}

	public int getCount() {
	    if (children == null) {
		return 1;
	    } else {
		int sum = 0;
		for (QTNode child : children) {
		    sum += child.getCount();
		}
		return sum;
	    }
	}

    }

    class QuadTree {
	QTNode root;

	public QuadTree(int[][] image) {
	    root = createQuadTree(new Rect(0, 0, image.length, image[0].length),
		    image, new HashMap<Rect, QTNode>());
	}

	QTNode createQuadTree(Rect rect, int[][] image, Map<Rect, QTNode> map) {
	    if (map.containsKey(rect)) {
		return map.get(rect);
	    }

	    QTNode root = new QTNode(rect.x1, rect.y1, rect.x2, rect.y2,
		    image[rect.x1][rect.y1]);

	    // If all the pixels are of same color we stop dividing.
	    if (sameColor(rect) && is2N(rect.x2 - rect.x1)
		    && is2N(rect.y2 - rect.y1)) {
		map.put(rect, root);
		return root;
	    }

	    int colorCount = Integer.MAX_VALUE;
	    for (int i = rect.x1; i <= rect.x2; i++) {
		for (int j = rect.y1; j <= rect.y2; j++) {

		    QTNode tmp = new QTNode(rect.x1, rect.y1, rect.x2, rect.y2,
			    image[rect.x1][rect.y1]);
		    tmp.children = new QTNode[4];

		    tmp.children[0] = createQuadTree(
			    new Rect(rect.x1, rect.y1, i, j), image, map);
		    tmp.children[1] = createQuadTree(
			    new Rect(rect.x1, j, i, rect.y2), image, map);
		    tmp.children[2] = createQuadTree(
			    new Rect(i, rect.y1, rect.x2, j), image, map);
		    tmp.children[3] = createQuadTree(
			    new Rect(i, j, rect.x2, rect.y2), image, map);

		    if (tmp.getCount() < colorCount) {
			root = tmp;
			colorCount = tmp.getCount();
		    }
		}
	    }

	    map.put(rect, root);
	    return root;
	}

	private boolean sameColor(Rect rect) {
	    // check colors
	    return false;
	}

	private boolean is2N(int x) {
	    int i = 0;
	    while (i < Integer.MAX_VALUE / 2 && i != x) {
		i = i << 1;
	    }
	    return i == x;
	}
    }

}
