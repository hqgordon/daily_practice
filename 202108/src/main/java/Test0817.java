import java.util.ArrayList;
import java.util.Arrays;

/**
 * @title: Test0817
 * @Author hqgordon
 * @Date: 2021/8/17 7:12 下午
 * @Description:
 * @Version 1.0
 */
public class Test0817 {
    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 2, -5, 4};
        //dp[i] 表示是i位置上最大值
        int n = nums.length;
        int k=8;
        int d=n/k;
        System.out.println(d);
        int max = -999;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int right = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (dp[i] > max) {
                max = dp[i];
                right = i;
            }
        }
        int sum = 0;
        int left = right;
        for (; left >= 0; left--) {
            sum += nums[left];
            if (sum == max) {
                break;
            }
        }
        int[] res = new int[right - left + 1];
        for (int i = 0; i < res.length; ) {
            res[i++] = nums[left++];
        }
        System.out.println(Arrays.toString(res));
    }
}
