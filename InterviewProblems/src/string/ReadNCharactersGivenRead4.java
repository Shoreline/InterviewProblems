package string;

/**
 * Read N Characters Given Read4
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * Note: The read function will only be called once for each test case.
 * 
 * @param buf
 *            Destination buffer
 * @param n
 *            Maximum number of characters to read
 * @return The number of characters read
 */

public class ReadNCharactersGivenRead4 {
    public class Solution extends Reader4 {

	public int read(char[] buf, int n) {
	    int ptr = 0;
	    char[] tmp = new char[4];
	    while (ptr < n) {
		int count = read4(tmp);
		for (int i = 0; i < count && ptr < n; i++) {
		    buf[ptr] = tmp[i];
		    ptr++;
		}
		if (count < 4) {
		    break;
		}
	    }

	    return ptr;
	}
    }
}
