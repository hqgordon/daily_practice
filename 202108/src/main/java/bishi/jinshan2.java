package bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName jinshan2
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2420:00
 * @Version 1.0
 */
public class jinshan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        //和最大的 绝对递增 3个元素子序列
        //无序
        //求最长的长度
        int[] dp = new int[n];
        int res = 0;
        int[] temp = new int[3];
        int flag = 0;
        Arrays.fill(dp, 1);
        //问题 最后的替换还是会把大的替换了
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    temp[2] = nums[i];
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    temp[flag++] = nums[j];
                    flag = flag % 2;
                    if (dp[i] >= 3) {
                        res = Math.max(Arrays.stream(temp).sum(), res);
                        System.out.println(Arrays.toString(temp));

                    }
                }
            }
            flag = 0;
            temp = new int[3];
        }
        System.out.println(res);
    }
}
