package bishi;

import java.util.Scanner;

/**
 * @ClassName baidu3
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2219:50
 * @Version 1.0
 */
public class baidu3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = new int[s.length()];
        int j = 0;
        for (String s1 : s.split("")) {
            nums[j++] = Integer.parseInt(s1);
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                if (flag == 0) dp[i] = dp[i - 1] + dp[i - 1] + 1;
                else dp[i] = dp[i - 1] + dp[i - 1] + 1 - i;
                flag++;
            } else if (nums[i - 1] == nums[i])
                dp[i] = dp[i - 1] + 1;
            else dp[i] = dp[i - 1] + 1;
        }
        System.out.println(dp[nums.length - 1]);


    }
}
