package bishi;

import java.util.Scanner;

/**
 * @ClassName Ebay2
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2919:48
 * @Version 1.0
 */
public class Ebay2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        System.out.println(check(str));
    }

    //最长 相同 子串 不重叠 初始位置再上一个之后
    static int check(String str) {
        int n = str.length();
        int left = 0;
        int right = n - 1;
        int max = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean flag = isRepeat(str, mid);
            if(flag){
                max=mid;
                left=mid+1;

            }else {
                right=mid-1;
            }
        }
        return max;
    }

    static boolean isRepeat(String str, int mid) {
        for (int i = 0; i < str.length() - mid; i++) {
            for (int j = i + 1; j < str.length() - mid; j++) {
                if (str.substring(i, i + mid).equals(str.substring(j, j + mid))) {
                    return true;
                }
            }
        }
        return false;
    }
}
