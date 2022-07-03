package bishi;


import java.util.Scanner;

/**
 * @ClassName Bi360
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2515:21
 * @Version 1.0
 */
public class Bi360 {
    public static void main(String[] args) {
        //找到数组里高于两边的数 并且记录位置
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        int[] nums = new int[n];
//        String[] s = sc.nextLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(s[i]);
//        }
        int[] nums = {5};
        int n = 1;
        int res = 0;
        int t=1;
        boolean pre=true;
        if (nums[n - 1] > nums[n - 2]) {
            t++;
            res++;
        }
        if(nums[0]>nums[1]) {
            pre=true;
            res++;
        }
        else pre=false;
        for (int i = 1; i < n - t; i++) {
            if (nums[i] > nums[i + 1]&& !pre) {
                res++;
                i++;
                pre=true;
            } else if(nums[i] > nums[i + 1]&& pre){
                continue;
            }else {
                res++;
            }
        }
        System.out.println(res);

    }
}
