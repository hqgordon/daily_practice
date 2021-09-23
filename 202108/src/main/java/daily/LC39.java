package daily;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LC39
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/711:15
 * @Version 1.0
 */
public class LC39 {
    public static void main(String[] args) {
        int target=7;
        int[] candidates={2,3,6,7};
        List<List<Integer>> res=new ArrayList();
        Deque<Integer> path=new LinkedList();

        dfs(res,path,0,0,target, candidates);
        System.out.println(res);
    }
     static void dfs(List<List<Integer>> res,Deque<Integer> path,int start,int sum,int target,int[] candidates){
         if(sum>target) return;
        if(sum==target){
            res.add(new ArrayList(path));
            return ;
        }
        for(int i=0;i<candidates.length;i++){
            sum+=candidates[i];
            path.addLast(candidates[i]);
            dfs(res,path,i,sum,target,candidates);
            path.removeLast();
            sum-=candidates[i];
        }
    }

}
