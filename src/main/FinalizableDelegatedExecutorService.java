package threadpool.priority;

import java.util.concurrent.ExecutorService;

/**
 * Created by falcon on 2017/8/1.
 */
public class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
    FinalizableDelegatedExecutorService(ExecutorService executor) {
        super(executor);
    }

    protected void finalize() {
        super.shutdown();
    }
}
