package dp;

import java.util.Arrays;

/**
 * @ClassName Lc198
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2410:40
 * @Version 1.0
 */
public class Lc198 {
    public static void main(String[] args) {
        int[] nums={2,4,8,9,9,3};

        System.out.println(new Solution().rob(nums));
    }
    static class Solution {
        public int rob(int[] nums) {
            if(nums.length<2){
                return nums[0];
            }
            if(nums.length==2){
                return Math.max(nums[0],nums[1]);
            }
            if(nums.length==3){
                return Math.max(nums[2],Math.max(nums[0],nums[1]));
            }
            if(nums.length==4){
                return Math.max(nums[0]+nums[2],nums[1]+nums[3]);
            }
            //起点是0
            int[] dp=new int[nums.length];
            dp[0]=nums[0];
            dp[2]=nums[0]+nums[2];
            dp[3]=nums[0]+nums[3];
            dp[4]=dp[2]+nums[4];
            for(int i=5;i<nums.length;i++){
                dp[i]=Math.max(dp[i-3],dp[i-2])+nums[i];
            }
            //终点需要改变
            int max1= Math.max(dp[nums.length-2],dp[nums.length-3]);
            //起点是1
            int max2=0;
            if(nums.length==5){
                max2= Math.max(nums[2]+nums[4],Math.max(nums[1]+nums[4],nums[1]+nums[3]));
                return Math.max(max1,max2);
            }
            dp=new int[nums.length];
            dp[1]=nums[1];
            dp[3]=nums[1]+nums[3];
            dp[4]=nums[1]+nums[4];
            dp[5]=dp[3]+nums[5];
            for(int i=6;i<nums.length;i++){
                dp[i]=Math.max(dp[i-3],dp[i-2])+nums[i];
            }
            //终点需要改变
            max2= Math.max(dp[nums.length-2],dp[nums.length-1]);
            //起点为2 这种情况比较特殊 因为如果终点取0 那和起点为0一样了
            //所以 起点为2 终点一定为最后一个
            int max3=0;
            if(nums.length==6){
                return Math.max(max1,Math.max(max2,nums[2]+nums[5]));
            }
            dp=new int[nums.length];
            dp[2]=nums[2];
            dp[4]=nums[2]+nums[4];
            dp[5]=nums[2]+nums[5];
            dp[6]=dp[4]+nums[6];
            for(int i=7;i<nums.length;i++){
                dp[i]=Math.max(dp[i-3],dp[i-2])+nums[i];
            }
            max3= dp[nums.length-1];
            return Math.max(max3,Math.max(max1,max2));
        }
    }
}
