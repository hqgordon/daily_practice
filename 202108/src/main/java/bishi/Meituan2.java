package bishi;

import java.util.Scanner;

/**
 * @ClassName Meituan2
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2516:15
 * @Version 1.0
 */
public class Meituan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < g; i++) {
            int[] nums = new int[3];
            int t = 0;
            for (String s : sc.nextLine().split(" ")) {
                nums[t++] = Integer.parseInt(s);
            }
            int n = nums[0];
            int m = nums[1];
            int val = nums[2];
            int[] nums1 = new int[n];
            t = 0;
            for (String s : sc.nextLine().split(" ")) {
                nums1[t++] = Integer.parseInt(s);
            }
            System.out.println(check(val, nums1, m));
        }
    }

    static String check(int val, int[] nums, int m) {
        //一个数组 m次操作机会 操作可以使得一个数变为立方
        //最后判断和是否可以为val
        int n=nums.length;



        return "NO";
    }

}
