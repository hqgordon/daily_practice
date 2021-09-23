package jianzhi;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

/**
 * @ClassName JZ85
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1114:36
 * @Version 1.0
 */
public class JZ85 {
    String[] kuohao={"(",")"};
    public List<String> generateParenthesis(int n){
        List<String> res=new ArrayList<>();
        Deque<String> path=new ArrayDeque<>();
        dfs(n,path,res,0,0);
        System.out.println(res.getClass().getName());
        return res;

    }
    private void dfs(int n, Deque<String> path, List<String> res, int left, int right){
        if(left>n||left<right) return;
        if(path.size()==n*2){
            res.add(con(path.toString()));
            return;
        }
        //如何去掉错误答案？ 记录左括号和右括号的个数
        for(int i=0;i<2;i++){
            path.addLast(kuohao[i]);
            if(i==0){
                dfs(n,path,res,left+1,right);
            }else dfs(n,path,res,left,right+1);
            path.removeLast();
        }
    }
    private String con(String str){
        StringBuilder res=new StringBuilder();
        for (char c : str.toCharArray()) {
            if(c=='('||c==')') res.append(c);
        }
        return res.toString();
    }



        public static void main(String[] args) {
        System.out.println(new JZ85().generateParenthesis(3));
    }
}
