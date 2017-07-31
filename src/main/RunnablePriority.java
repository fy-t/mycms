package threadpool.priority;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * Created by falcon on 2017/8/1.
 */
@Slf4j
@Data
public class RunnablePriority extends RunnablePriorityBase implements Runnable,Callable<Boolean>, Comparable<RunnablePriorityBase> {

    private Long timeOut;

    public RunnablePriority(int priority,Long timeOut) {
        super(priority);
        this.timeOut=timeOut;
    }

    @Override
    public int compareTo(RunnablePriorityBase o) {
        // 复写此方法进行任务执行优先级排序
        if (priority < o.priority) {
            return -1;
        } else {
            if (priority >= o.priority) {
                return 1;
            } else {
                return 1;
            }
        }
    }

    @Override
    public void run() {
        // 执行任务代码..
        log.info("run...");

    }

    @Override
    public Boolean call() throws Exception {
        return Boolean.TRUE;
    }
}
