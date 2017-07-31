package threadpool.priority;

import lombok.Data;
import threadpool.*;

import java.text.SimpleDateFormat;
import java.util.concurrent.*;

/**
 * Created by falcon on 2017/8/1.
 */
public class Test {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss::SSS");
    // public ExecutorService singleTest =
    // Executors.newSingleTest();
    public ExecutorService singleTest = new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L,
            TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>()));

    public static void main(String[] args) {
        Test Test = new Test();
        for(int i=0;i<10;i++){
            testTask(Test.singleTest,new RunnablePriority(i ,5*1000L));
            testTask(Test.singleTest,new RunnablePriority(i ,5*1000L));
        }
    }

    public static void testTask(ExecutorService exec, RunnablePriority task) {
        Future<Boolean> future = (Future<Boolean>) exec.submit((Runnable) task);
        Boolean taskResult = null;
        String failReason = null;
        try {
            // 等待计算结果，最长等待timeout秒，timeout秒后中止任务
            taskResult = future.get(task.getTimeOut(), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            failReason = "主线程在等待计算结果时被中断！";
        } catch (ExecutionException e) {
            failReason = "主线程等待计算结果，但计算抛出异常！";
        } catch (TimeoutException e) {
            failReason = "主线程等待计算结果超时，因此中断任务线程！";
            exec.shutdownNow();
        }

        System.out.println("\ntaskResult : " + taskResult);
        System.out.println("failReason : " + failReason);
    }

}

@Data
class T extends threadpool.RunnablePriority {
    private String name;
    private Long timeOut;
    public T(int priority,String name,Long timeOut){
        super(priority);
        this.name=name;
        this.timeOut=timeOut;
    }
    public T(int priority) {
        super(priority);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPriority()+"======"+name);
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}