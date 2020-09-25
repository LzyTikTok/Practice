/**
 * @Author lzy
 * @create 2020/9/9 13:33
 */
public class TestYield
{

    public static void main(String[] args) throws InterruptedException
    {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread
{
    MyThread(final String threadName)
    {
        System.out.println(threadName);
    }

    @Override
    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            if (i < 100 && getName().equals("t1")){
                yield();
            }
            System.out.println(getName() + ":" + i);
        }
    }
}