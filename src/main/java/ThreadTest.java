import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author lzy
 * @create 2020/9/9 12:16
 */
public class ThreadTest {
    /**
     * 测试线程
     */
    private static int CORE_POOL_SIZE = 5;
    private static int MAX_POOL_SIZE = 5;
    private static int KEEP_ALIVE_TIME = 60;
    private static ThreadFactory nameThreadFactory =
            new ThreadFactoryBuilder().setNameFormat("thread-test-%d").build();
    private static ExecutorService executorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), nameThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println("测试guava" + Thread.currentThread().getName());
                }
            });
        }
    }
}
//        T1 t1 = new T1("t1");
//        synchronized (t1){
//            t1.start();
//            t1.wait();
//        }
//        T2 t2 = new T2();
//        t2.start();
//    }
//
//}
//
//class T1 extends Thread{
//    public T1(String name) {
//        super(name);
//    }
//    @Override
//    public void run() {
//        synchronized (this){
//            this.notify();
//            for (int i = 0; i < 100; i++) {
//                System.out.println("t1 :" + i);
//            }
//        }
//    }
//}
//class T2 extends Thread{
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println("t2: " + i);
//        }
//    }
//}
