package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Read N Characters Given Read4 II
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * Note: The read function may be called multiple times.
 */

/*
 * The tricky part is that this method can be invoked multiple times. While
 * using read4(char[] tmp), there may be some characters in tmp that were not
 * copied to char[] buf. These characters are the first to be copied while next
 * time invoke read(char[],int)
 * 
 * So, need some cache to save them.
 */
public class ReadNCharactersGivenRead4II {
    public class Solution extends Reader4 {
	char[] tmp = new char[4];
	int ptr = 0;
	int size = 0;

	public int read(char[] buf, int n) {
	    int len = 0;

	    while (ptr < size && len < n) {
		buf[len] = tmp[ptr];
		ptr++;
		len++;
	    }

	    while (len < n) {
		size = read4(tmp);
		ptr = 0;
		while (ptr < size && len < n) {
		    buf[len] = tmp[ptr];
		    ptr++;
		    len++;
		}
		if (size < 4) {
		    break;
		}
	    }

	    return len;
	}
    }

    public class Solution2 extends Reader4 {
	List<Character> remains = new ArrayList<>();

	public int read(char[] buf, int n) {
	    int ptr = 0;
	    for (int i = 0; i < remains.size() && ptr < n; i++) {
		buf[ptr] = remains.get(i);
		// remains.remove(i); wrong
		ptr++;
	    }
	    remains.subList(0, ptr).clear();
	    if (!remains.isEmpty()) {
		return ptr;
	    }

	    char[] tmp = new char[4];
	    while (ptr < n) {
		int count = read4(tmp);

		int i = 0;
		while (i < count && ptr < n) {
		    buf[ptr] = tmp[i];
		    i++;
		    ptr++;
		}

		while (i < count) {
		    remains.add(tmp[i]);
		    i++;
		}

		if (count < 4) {
		    break;
		}
	    }

	    return ptr;
	}
    }
}
