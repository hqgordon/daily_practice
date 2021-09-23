package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName baidu1
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2219:29
 * @Version 1.0
 */
public class baidu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<List<Integer>> nums = new ArrayList<>();
        if (n % 2 == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                for (String s1 : s.split(" ")) {
                    sum += Integer.parseInt(s1);
                }
            }
            System.out.println(sum);
        } else {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (i != n % 2) {
                    String s = sc.nextLine();
                    String[] s1 = s.split(" ");
                    for (int j = 0; j < n; j++) {
                        if (j != n % 2) {
                            sum += Integer.parseInt(s1[j]);
                        }
                    }
                }

            }
            System.out.println(sum);
        }

    }
}
