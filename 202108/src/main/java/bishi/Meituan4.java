package bishi;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @ClassName Meituan4
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2516:42
 * @Version 1.0
 */
public class Meituan4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] high = new int[n];
        int k = 0;
        for (String s1 : sc.nextLine().trim().split(" ")) {
            high[k++] = Integer.parseInt(s1);
        }
//        int[] high = {5, 1, 2};
//        int m = 2;
        System.out.println(check(high, m));
    }

    static int check(int[] high, int m) {
        //要求 分组连续 不跳过人
        //最好的情况 都一个人一组答案为0
        //思考 如果5个人 分两组
        //1 4/  2 3/    4 1/  3 2四种情况
        if (m == 1) return 0;
        int n = high.length;
        int[][] dp = new int[n][m + 1];
        //求最小值 赋予最大值
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int k = 2; k <= m; k++) {
            for (int i = k - 1; i < n; i++) {
                for (int j = k - 2; j < i; j++) {
                    dp[i][k] = Math.min(dp[i][k], Math.min(max_min(high, i + 1, j + 1), dp[j][k - 1]));
                }
            }
        }
        return dp[n - 1][m];
    }

    //得到一段数组里i到j的极差 包括j
    static int max_min(int[] high, int i, int j) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int t = i; i <= j; t++) {
            if (high[t] > max) max = high[t];
            if (high[t] < min) min = high[t];
        }
        return max - min;
    }
}
