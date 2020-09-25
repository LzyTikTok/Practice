package CrazyJava;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author lzy
 * @create 2020/9/19 16:10
 */
class RtnThread implements Callable<Integer> {
    @Override
    public Integer call() {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  的循环变量i的值:" + i);
        }
        return i;
    }
}

public class CallableTset {
    public static void main(String[] args) {
        RtnThread rt = new RtnThread();
        FutureTask<Integer> task = new FutureTask<Integer>(rt);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "i的值" + i);
            if (i == 20){
                new Thread(task, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值" + task.get());
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
