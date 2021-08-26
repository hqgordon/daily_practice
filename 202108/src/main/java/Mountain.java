import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @title: Mountain
 * @Author hqgordon
 * @Date: 2021/8/15 6:57 下午
 * @Description:
 * @Version 1.0
 */
public class Mountain {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 8, 9, 20, 12, 37, 5, 7, 26, 44, 88};
        boolean[] bool = new boolean[arr.length];
        findK(arr, bool);
        //bool数组中为true的下标，即是满足需要的索引
        for (int i = 1; i < bool.length - 1; i++) {
            if (bool[i]) {
                System.out.print(i);
                System.out.println(arr[i]);
            }
        }

    }
    //查找数组中比左边都大，比右边都小的数，返回索引
    private static boolean[] findK(int[] arr, boolean[] bool) {
        if (arr == null || arr.length < 3) {
            return bool;
        }
        int max = arr[0];
        for (int i = 1; i <= arr.length - 2; i++) {
            if (arr[i] > max) {
                max = arr[i];
                bool[i] = true;
            }
        }
        int min = arr[arr.length - 1];
        for (int i = arr.length - 2; i > 0; i--) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                bool[i] = false;
            }
        }
        return bool;
    }
}


