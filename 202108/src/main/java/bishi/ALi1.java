package bishi;

import java.util.Scanner;

/**
 * @ClassName ALi1
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2419:01
 * @Version 1.0
 */
public class ALi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String s1 = in.nextLine();
        int n = Integer.parseInt(s);
        //首先 连着的都算一个
        char[] chars = s1.toCharArray();
        int b = 1;
        int r = 1;
        if (chars[0] == 'B') b++;
        else r++;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                if (chars[i] == 'B') b++;
                else r++;
            }
        }
        //不同的最小个数+1
        System.out.println(Math.min(r, b));


    }
}
