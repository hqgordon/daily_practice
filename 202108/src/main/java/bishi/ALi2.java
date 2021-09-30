package bishi;

import java.util.Scanner;

/**
 * @ClassName ALi2
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2419:17
 * @Version 1.0
 */
public class ALi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }
}
