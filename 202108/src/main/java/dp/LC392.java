package dp;

/**
 * @ClassName LC392
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/259:23
 * @Version 1.0
 */
public class LC392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        if (s.equals("")) return true;
        if (s.length() > t.length()) return false;
        int start = 0;
        for (int i = 0; i < s.length(); ) {
            for (int j = start; j < t.length(); ) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    start = ++j;
                    //表示t遍历完了 并且i没到终点 返回false 虽然找到了但是在最后已经没法找下一个了
                    if (j == t.length() && i != s.length()) return false;
                    //表示s遍历完了 并且成功
                    if (i == s.length()) return true;
                    break;
                } else {
                    j++;
                    //表示t遍历完了都没找到
                    if (j == t.length()) return false;
                }
            }
        }

        return false;
    }
}
