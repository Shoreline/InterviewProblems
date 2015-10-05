package facebook;

import java.util.*;

/**
 * Follow up of tasks execution time I.
 *
 * How to optimize the task order to get best execution time
 * 
 */
/*
 * 我觉得应该实时更新剩余字符的个数，然后选剩余字符最多的并且和前k字符不一样的作为下一个字符吧
 */
public class TasksExecutionTimeII {
    class Method {
	class Task {
	    int id;
	    int count;
	    int timestamp;
	}

	public int[] getExecTime(int[] tasks, int N) {
	    int[] res = new int[tasks.length];
	    PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
		@Override
		public int compare(Task o1, Task o2) {
		    if (o1.count != o2.count) {
			return -(o1.count - o2.count); // descending order
		    } else {
			return o1.timestamp - o2.timestamp; // ascending order
		    }
		}
	    });

	    int i = 0;
	    while (i < tasks.length) {
		Set<Task> tmp = new HashSet<>();
		for (int c = 0; c < N && !pq.isEmpty(); c++) {
		    Task t = pq.poll();
		    res[i] = t.id;
		    t.count--;
		    t.timestamp = i;
		    tmp.add(t);
		    i++;
		}

		for (Task t : tmp) {
		    pq.add(t);
		}
	    }

	    return res;
	}
    }
}
