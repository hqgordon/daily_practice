package bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName jinshan1
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2419:43
 * @Version 1.0
 */
public class jinshan1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int[][] mi=new int[n][n];
        for(int i=0;i<n;i++){
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            for (int k=0;k<s1.length;k++){
                mi[i][k]=Integer.parseInt(s1[k]);
            }
        }

        //走到最后一层只能是上面来的 可以向右或者向下
        int[][] dp=new int[n][n];
        //表示到这个点收集的奶酪
        dp[0][0]=mi[0][0];
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+mi[i][0];
        }
        for(int i=1;i<mi.length;i++){
            for (int j=1;j<mi[i].length;j++){
                if(i==mi.length-1){
                    dp[i][j]=dp[i-1][j]+mi[i][j];
                }else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+mi[i][j];
            }
        }
        //输出 最后一层的最大值但是不包括最后一个
        int max=dp[n-1][0];
        for(int i=1;i<dp[n-1].length-1;i++){
            max=Math.max(dp[n-1][i],max);
        }
        System.out.println(max);

    }

}
