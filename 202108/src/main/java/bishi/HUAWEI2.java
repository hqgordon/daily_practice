package bishi;

import java.util.*;

/**
 * @ClassName HUAWEI2
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1519:24
 * @Version 1.0
 */
public class HUAWEI2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] workstations=new int[s1.length];
        for(int i=0;i<s1.length;i++){
            workstations[i]=Integer.valueOf(s1[i]);
        }
        int averageScore=workstations[0];
        int n=workstations[1];
        String s3 = sc.nextLine();
        Integer[] jifeng=new Integer[2*n];

        int i=0;
        for (String s2 : s3.split(" ")) {
            jifeng[i++]=Integer.valueOf(s2);
        }
        //积分数组的组合 每个组合满足两个两个的是可以被averageScore整除
        // 回溯算法解决 剪枝也就是两个
        List<List<Integer>> res=new ArrayList<>();
        Comparator cmp=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2) return  1;
                else if(o1>o2) return -1;
                else return 0;
            }
        };
        Arrays.sort(jifeng,cmp);
        //避免重复积分
        boolean[] used=new boolean[2*n];
        Deque<Integer> path=new ArrayDeque<>();
        dfs(res,path,used,jifeng,averageScore,0);
        if(res.size()==0){
            System.out.print(0);
            return;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (Integer i1: res.get(0)) {
            stringBuilder.append(i1+" ");
        }
        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));

    }
    private  static void dfs(List<List<Integer>> res,Deque<Integer> path,boolean[] used
    ,Integer[] jifeng,int averageScore,int depth){
        if(path.size()%2==0&&!average(path,averageScore)){
            return;
        }

        if(depth==jifeng.length){
            res.add(new ArrayList<>(path));
        }
        for(int i=0;i<jifeng.length;i++){
            //重复积分去重
            if(used[i]){
                continue;
            }
            if(i>0&&jifeng[i]==jifeng[i-1]&&!used[i-1]){
                continue;
            }
            path.addLast(jifeng[i]);
            used[i]=true;
            dfs(res,path,used,jifeng,averageScore,depth+1);
            used[i]=false;
            path.removeLast();
        }
    }
    //检验函数
    private  static boolean average(Deque<Integer> path,int averageScore){
        Integer[] objects = path.toArray(new Integer[0]);
        for(int i=0;i<path.size();i=i+2){
            if((objects[i]+objects[i+1])%averageScore!=0)
                return false;
        }
        return  true;
    }
}
