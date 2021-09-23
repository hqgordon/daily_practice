package jianzhi;

/**
 * @ClassName JZ46
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/179:34
 * @Version 1.0
 */
public class JZ46 {
    static class Solution {
        public int translateNum(int num) {
            //动态规划 12258
            //1225的情况 如果 8 可以与5 组成10到25那么
            String s = String.valueOf(num);
            int[] dp = new int[s.length()+1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= s.length(); i ++){
                String temp = s.substring(i-2, i);
                if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
                    dp[i] = dp[i-1] + dp[i-2];
                else
                    dp[i] = dp[i-1];
            }
            return dp[s.length()];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(12258));
    }
}
