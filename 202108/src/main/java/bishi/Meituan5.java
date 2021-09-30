package bishi;

import javafx.scene.transform.Scale;

import java.util.*;

/**
 * @ClassName Meituan5
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2517:25
 * @Version 1.0
 */
public class Meituan5 {
    //找两个区间 区间的子序列和最大
    /**小美有一个长度为n的序列，为了使得这个序列的和尽量大，
    她向会魔法的小团进行求助。
    小团可以选择序列中至多两个不相交的区间，将区间里的数全都变为原来的10倍。
    小团想知道他的魔法最多可以帮助小美将序列的和变大到多少？（也可以不使用魔法保持原来的序列）
    * */
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int[] nums=new int[n];
        int p=0;
        for (String s : sc.nextLine().trim().split(" ")) {
            nums[p++]=Integer.parseInt(s);
        }
        //也就是 选出所有子序列和》0的区间 然后选出最好的两个x10
        Map<Integer, List<Integer>> map=new HashMap<>();
        int max=nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];
        int m=0;
        for(int i=0;i<n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);

            if(dp[i]>max){
                max=dp[i];
                map.put(m++,new ArrayList(Collections.singleton(new int[]{1, 2})));
            }
        }


    }
}
