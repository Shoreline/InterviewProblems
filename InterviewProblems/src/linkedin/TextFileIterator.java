package linkedin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * http://my.oschina.net/hsm/blog/108551
 *
 */
public class TextFileIterator implements Iterator<String> {

    // stream being read from
    BufferedReader br;
    // return value of next call to next()
    String nextline;

    // the structure method of TextFileItrator
    public TextFileIterator(String filename) {
	// 打开文件并读取第一行 如果第一行存在获得第一行
	try {
	    br = new BufferedReader(new FileReader(filename));
	    nextline = br.readLine();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    // if the next line is non-null then we have a next line
    @Override
    public boolean hasNext() {
	return nextline != null;
    }

    // return the next line,but first read the line that follows it
    @Override
    public String next() {
	try {
	    String res = nextline;
	    // if we dont have reached EOF yet
	    if (nextline != null) {
		nextline = br.readLine(); // read another line
		if (nextline == null) {
		    br.close(); // and close on EOF
		}
	    }
	    return res;
	} catch (IOException e) {
	    throw new IllegalArgumentException(e);
	}
    }

    // we dont need remove the line just read it
    // @Override
    // public void remove() {
    // throw new UnsupportedOperationException();
    // }

}