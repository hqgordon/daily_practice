package daily;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName HUAWEI2
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/819:12
 * @Version 1.0
 */
public class HUAWEI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[2];
        String s = sc.nextLine();
        String[] ss = s.split(",");
        for (int i = 0; i < 2; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        System.out.println();
        int m = nums[0];
        int n = nums[1];
        int[][] mei = new int[nums[0]][nums[1]];
        //初始化梅花阵
        s = sc.nextLine();
        ss = s.split(" ");
        int t = 0;
        for (int i = 0; i < mei.length; i++) {
            for (int j = 0; j < mei[0].length; j++) {
                mei[i][j] = Integer.parseInt(ss[t++]);
            }
        }
        m=3;
        n=3;
        mei= new int[][]{{3, 2, 2}, {0, 1, 0}, {1, 1, 1}};
        int res = -1;
        //dp数组表示 到这一步最小跳跃次数
        if (mei[0][0] == 0) {
            return;
        }

        int[][] dp = new int[m][n];
        //初始化dp 行
        for (int i=0;i<m&&i<=mei[0][0];i++){
            if(mei[i][0]==0) dp[i][0]=Integer.MAX_VALUE;
            else dp[i][0]=1;
        }
        for (int i=0;i<n&&i<=mei[0][0];i++){
            if(mei[0][i]==0) dp[0][i]=Integer.MAX_VALUE-10;
            else dp[0][i]=1;
        }

        //初始化完成开始跳跃
        //转移方程：可能来自于你的上方和左边所有的格子
        // 所以最好是从一个格子出发去更新其他的距离 而不是到了一个格子是从上和左下来
        int min=Integer.MAX_VALUE;
        for(int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (mei[i][j]==0) {
                    dp[i][j]=Integer.MAX_VALUE;
                    continue;
                }
                //左边来
                for(int k=j-1;k>=0;k--){
                    min=Math.min(min,dp[i][k]);
                }
                for(int k=i-1;k>=0;k--){
                    min=Math.min(min,dp[k][j]);
                }
                dp[i][j]=min+1;

            }
        }
        for(int i=0;i<m;i++){
            System.out.println(Arrays.toString(dp[i]));
        }

    }
}
