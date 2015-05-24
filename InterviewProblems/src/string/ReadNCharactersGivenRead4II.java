package string;

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

}
