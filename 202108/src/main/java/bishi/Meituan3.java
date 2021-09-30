package bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Meituan3
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2516:23
 * @Version 1.0
 */
public class Meituan3 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] s = sc.nextLine().trim().split(" ");
//        int n = Integer.parseInt(s[0]);
//        int m = Integer.parseInt(s[1]);
//        int[] tongs = new int[n];
//        int k = 0;
//        for (String s1 : sc.nextLine().trim().split(" ")) {
//            tongs[k++] = Integer.parseInt(s1);
//        }
        int[] tongs={6,7,90,89};
        int m=9;
        System.out.println(check(tongs, m));
    }
    static int check(int[] tongs, int m) {
        //每次找到数组里最小数 然后加1；
        //m次后 输出数组最小数
        //排序然后一个一个加
        Arrays.sort(tongs);
        int t = 1;
        //最小的永远在第一个
        for (int i = 1; i < tongs.length; i++) {
            //
            int k = (tongs[i] - tongs[0]) * t;
            if (k < m) {
                tongs[0] = tongs[i];
                m = m - k;
                t++;
            } else {
                return tongs[0] + (m / t);
            }
        }
        return tongs[0];
    }
}

