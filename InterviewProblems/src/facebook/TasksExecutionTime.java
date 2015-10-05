package facebook;

import java.util.*;

/**
 * 给一个vector 里面的元素表示task type，给一个N，表示执行相同task时要等上N个单位时间 例子中用‘_’表示.
 * 问按顺序执行这些tasks最后要花多少时间。
 * 
 * [1,2,1,2], N=3: 1,2,_,_,1,2--> 6
 * 
 * 
 * [1,2,1,2], N=2: 1,2,_,1,2 --> 5,
 *
 */
public class TasksExecutionTime {
    /*
     * Use a map to save task_id -> last finishing time
     * 
     * Each round, timeStamp is increased anyway. And if the next task in list
     * is allowed to finish, finish it and move to next task
     */
    class Method {
	public int getExecTime(int[] tasks, int N) {
	    if (tasks == null || tasks.length == 0) {
		return 0;
	    }

	    Map<Integer, Integer> map = new HashMap<>();

	    int i = 0; // # of tasks finished
	    int timeStamp = 0;

	    while (i < tasks.length) {
		if (!map.containsKey(tasks[i]) || timeStamp - map.get(tasks[i]) > N) {

		    map.put(tasks[i], timeStamp);
		    i++;
		}
		timeStamp++;
	    }
	    return timeStamp;
	}
    }

    class Method2 {
	public int getExecTime(int[] tasks, int N) {
	    if (tasks == null || tasks.length == 0) {
		return 0;
	    }

	    Map<Integer, Integer> map = new HashMap<>();
	    int idle = 0;
	    int i = 0; // # of tasks finished
	    int curTS = 0;

	    // i + idle is current TS (since each task took 1 unit time to
	    // finish)
	    while (i < tasks.length) {
		curTS = i + idle;
		if (!map.containsKey(tasks[i])) {
		    map.put(tasks[i], curTS);
		    i++;
		} else {
		    int lastFinshTS = map.get(tasks[i]);
		    if (curTS - lastFinshTS <= N) { // condition is "<=" !
			idle++;
		    } else {
			map.put(tasks[i], curTS);
			i++;
		    }
		}
	    }
	    return curTS;
	}
    }
}
