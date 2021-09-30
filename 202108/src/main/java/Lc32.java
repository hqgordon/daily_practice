/**
 * @ClassName Lc32
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2319:24
 * @Version 1.0
 */
public class Lc32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }
    public static int longestValidParentheses(String s) {
        StringBuilder temp=new StringBuilder();
        temp.append("()");
        int res=0;
        while(s.contains(temp)){
            temp.append("()");
            res+=2;
        }
        return res;


    }
}
