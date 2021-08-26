import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * @title: Test0819
 * @Author hqgordon
 * @Date: 2021/8/19 1:09 下午
 * @Description:
 * @Version 1.0
 */
public class Test0819 {
    public static void main(String[] args) {
        int[] nums={1,2,3,1,2,3,4};
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            System.out.println(Arrays.toString(dp));
            res = Math.max(res, dp[i]);
        }
        Date date=new Date();
        long time = date.getTime();
        System.out.println(new Timestamp(System.currentTimeMillis()));

        System.out.println(res);
    }

}
