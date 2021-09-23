package bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Lazada2
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1620:32
 * @Version 1.0
 */
public class Lazada2 {
    public static void main(String[] args) {
        //每个范围内质数的个数 注意是个数
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s.length()>1){
                String[] s1 = s.split(" ");
                System.out.println(find(Integer.parseInt(s1[1]))-find(Integer.parseInt(s1[0])-1));
            }
        }
    }
    //闭区间
    //筛选法求
    private static int find(int r) {
        if(r==0) return 0;
        int res = r-1;
        boolean[] booleans = new boolean[r+1];
        booleans[1]=false;
        Arrays.fill(booleans, 2, booleans.length, true);
        int n = (int) Math.sqrt(r);
        for (int i = 1; i < r; i++) {
            if (booleans[i]) {
                for (int j = 2 * i; j <= r; j += i) {
                    if(booleans[j]) {
                        booleans[j] = false;
                        res--;
                    }
                }
            }
        }
        return res;
    }
}
