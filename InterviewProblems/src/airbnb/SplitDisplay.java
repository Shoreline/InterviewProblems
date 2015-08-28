package airbnb;

import java.util.*;

/**
 * 实现分页显示。给了以下一些输入数据，要求将以下行分页显示，每页12行，其中每行已经按score排好序，分页显示的时候如果有相同host
 * id的行，则将后面同host id的行移到下一页。 [
 * 
 * "host_id,listing_id,score,city",
 * 
 * "1,28,300.1,SanFrancisco",
 * 
 * "4,5,209.1,SanFrancisco",
 * 
 * "20,7,208.1,SanFrancisco",
 * 
 * "23,8,207.1,SanFrancisco",
 * 
 * "16,10,206.1,Oakland",
 * 
 * "1,16,205.1,SanFrancisco",
 * 
 * ...
 * 
 * "30,23,1.1,SanJose"
 * 
 * ]
 */

public class SplitDisplay {
    /*
     * Note: It is impossible that a page is full before all of its previous
     * pages are full
     */
    class Method {
	public List<List<String>> getPages(String[] source, int k) {
	    List<List<String>> pages = new ArrayList<List<String>>();
	    pages.add(new ArrayList<String>());
	    int vacant = 0;

	    // Map<id, last inserted page# of this id>
	    Map<Integer, Integer> map = new HashMap<>();

	    for (String record : source) {
		int hostId = Integer.valueOf(record.substring(0, record.indexOf(',')));
		int pageToInsert = vacant;
		if (map.containsKey(hostId)) {
		    pageToInsert = map.get(hostId) + 1;
		    if (pages.size() == pageToInsert) {
			pages.add(new ArrayList<String>());
		    }
		}

		pages.get(pageToInsert).add(record);
		map.put(hostId, pageToInsert);

		if (pages.get(vacant).size() == k) {
		    vacant++;
		    if (pages.size() == vacant) {
			pages.add(new ArrayList<String>());
		    }
		}
	    }

	    return pages;
	}

    }

    class Method2 {
	public List<List<String>> getPages(String[] source, int k) {
	    int firstEmptyPage = 0;
	    List<List<String>> pages = new ArrayList<List<String>>();
	    pages.add(new ArrayList<String>());
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (String s : source) {
		int id = getId(s);
		if (map.containsKey(id)) {
		    int index = map.get(id) + 1;
		    if (index == pages.size())
			pages.add(new ArrayList<String>());
		    pages.get(index).add(s);
		    map.put(id, index);
		} else {
		    map.put(id, firstEmptyPage);
		    pages.get(firstEmptyPage).add(s);
		    if (pages.get(firstEmptyPage).size() == k)
			firstEmptyPage = updata(map, pages, firstEmptyPage);
		}
	    }
	    return pages;
	}

	private int updata(HashMap<Integer, Integer> map, List<List<String>> pages, int i) {
	    for (String s : pages.get(i)) {
		int id = getId(s);
		if (map.get(id) == i)
		    map.remove(id);
	    }
	    if (i == pages.size())
		pages.add(new ArrayList<String>());
	    return i + 1;
	}

	private int getId(String s) {
	    int i = s.indexOf(',');
	    return Integer.parseInt(s.substring(0, i));
	}

    }

    class Method3 {
	/*
	 * 这题的思路不难，但是实现起来还是有点难度的。在遍历的时候需要维护一个LinkedHashMap作为page并且完成去重。
	 * 用LinkedHashMap的好处是可以保证所有的entry是按插入的顺序排序的，所以仍然可以保证按score排序的性质。另外，
	 * 一旦遇到相同的host_id，则将其对应的行存到另一个buffer里。由于需要变遍历边增减容器里的数据，需要用ListIterator，
	 * 并调用remove和add方法。之前只用过remove，从来没用过add。
	 */
    }

    public static void main(String[] args) {
	String[] source = new String[] { "1,28,300.1,SanFrancisco",

		"4,5,209.1,SanFrancisco",

		"20,7,208.1,SanFrancisco",

		"23,8,207.1,SanFrancisco",

		"16,10,206.1,Oakland",

		"1,16,205.1,SanFrancisco",

		"6,29,204.1,SanFrancisco",

		"7,20,203.1,SanFrancisco",

		"8,21,202.1,SanFrancisco",

		"2,18,201.1,SanFrancisco",

		"2,30,200.1,SanFrancisco",

		"15,27,109.1,Oakland",

		"10,13,108.1,Oakland",

		"11,26,107.1,Oakland",

		"12,9,106.1,Oakland",

		"13,1,105.1,Oakland",

		"22,17,104.1,Oakland",

		"1,2,103.1,Oakland",

		"28,24,102.1,Oakland",

		"18,14,11.1,SanJose",

		"6,25,10.1,Oakland",

		"19,15,9.1,SanJose",

		"3,19,8.1,SanJose",

		"3,11,7.1,Oakland",

		"27,12,6.1,Oakland",

		"1,3,5.1,Oakland",

		"25,4,4.1,SanJose",

		"5,6,3.1,SanJose",

		"29,22,2.1,SanJose",

	};
	List<List<String>> pages = new SplitDisplay().new Method().getPages(source, 12);
	int i = 0;
	for (List<String> page : pages) {
	    System.out.println("page " + i++ + ": size " + page.size());
	    for (String record : page)
		System.out.println(record);
	}
    }
}
