package Util;

import java.util.Arrays;


/**
 * @Author lzy
 * @create 2020/9/10 23:34
 */
public class Utils {
    public static void swap(Comparable a[], int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    public static void  show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "");
        }
        System.out.println();
    }
}
