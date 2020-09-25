package Util;

/**
 * @Author lzy
 * @create 2020/9/11 22:12
 */
public class LambdaThreadTest {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
            }
        }).start();
    }
}
