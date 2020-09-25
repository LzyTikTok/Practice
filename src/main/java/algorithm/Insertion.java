package algorithm;

import Util.Utils;

import java.util.Arrays;

/**
 * @Author lzy
 * @create 2020/9/10 23:26
 */
public class Insertion {
    public static Integer[] InsertionSort(Integer[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                Utils.swap(a, j, j-1);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Integer[] a = {1,3,4,10,2,3,22};
        System.out.println(Arrays.toString(InsertionSort(a)));
    }
}
