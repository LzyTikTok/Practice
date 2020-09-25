package CrazyJava;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lzy
 * @create 2020/9/14 13:18
 */
public class Account {
    private final Lock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();
    private String accountNo;
    private double balance;
    //标识账户中是否已经存款
    private boolean isDepoised;
    public void draw(double drawAmount){
        //加锁
        lock.lock();
        try{
            if(!isDepoised){
                cond.await();
            } else{
                //...取钱
                isDepoised = false;
                cond.signalAll();
            }
        } catch (InterruptedException ex){
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void deposit(double depositAmount){
        //加锁
        lock.lock();
        try{
            if(isDepoised){
                cond.await();
            } else{
                //...存钱
                isDepoised = true;
                cond.signalAll();
            }
        } catch (InterruptedException ex){
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
