package daily;

import java.util.*;

/**
 * @ClassName LC17
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/710:39
 * @Version 1.0
 */
public class LC17 {
    public static void main(String[] args) {
        String digits = "23";
        List<String> res = new ArrayList();
        StringBuilder path = new StringBuilder();
        int n = digits.length();
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(digits, n, 0, phoneMap, path, res);
        System.out.println(res.toString());
    }

    static void dfs(String digits, int n, int start, Map<Character, String> phoneMap, StringBuilder path, List<String> res) {
        if (path.length() == n) {
            res.add(String.valueOf(path));
            return;
        }
        Character num = digits.charAt(start);
        String letters = phoneMap.get(num);
        StringBuilder path1=new StringBuilder();



        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i)); // 处理
            dfs(digits, n, start + 1, phoneMap, path, res); // 递归，注意index+1，⼀下层要处理下⼀个数字了
            path.deleteCharAt(path.length()-1);
        }
    }
}

