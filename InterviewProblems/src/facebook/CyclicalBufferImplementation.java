package facebook;

/**
 * Implement a cyclical buffer of bytes of fixed size n
 *
 * Support the creation and enqueue/dequeue operations.The buffer is intended to
 * be use in a high throughput environment
 *
 */

/*
 * Similar to a queue. Use a fixed size array to implement. If adding too many
 * items that exceeds buffer size, just throw an exception.
 * 
 * Need two pointers: head and tail. Add new item to array[tail], and remove old
 * item from array[head]
 * 
 * The key is how to increase head and tail: tail = (tail+1)%size;
 */
public class CyclicalBufferImplementation {
    class Method {
	class CyclicalBuffer {
	    int size;
	    int count;
	    int head;
	    int tail;
	    int[] array;

	    public CyclicalBuffer(int _size) {
		this.size = _size;
		this.count = 0;
		this.head = 0;
		this.tail = 0;
		this.array = new int[_size];
	    }

	    void push(int x) throws Throwable {
		if (count == size) {
		    throw new Exception("Cyclical Buffer full");
		} else {
		    array[tail] = x;
		    tail = (tail + 1) % size;
		    count++;
		}
	    }

	    int pop() throws Throwable {
		if (count == 0) {
		    throw new Exception("Cyclical Buffer is empty");
		} else {
		    int res = array[head];
		    head = (head + 1) % size;
		    count--;
		    return res;
		}
	    }
	}
    }
}
