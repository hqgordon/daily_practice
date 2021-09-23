package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Bili1
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1319:15
 * @Version 1.0
 */
public class Bili1 {
    public static void main(String[] args) {

        //弹幕 水平或者竖直dfs即可
        //把输入转换成二维数组
        Scanner sc=new Scanner(System.in);
        List<String> stringList=new ArrayList<>();
        while (sc.hasNextLine()){
                stringList.add(sc.nextLine());
        }
        int n=stringList.size();
        String s = stringList.get(0);
        String[] split = s.substring(2, s.length() - 2).split(",");
        int m=split.length;
        int[][] danmu=new int[n][m];
        for(int i=0;i<n;i++){
           split=stringList.get(i).substring(2, s.length() - 2).split(",");
            for (int j=0;j<m;j++){
                danmu[i][j]=Integer.parseInt(split[j]);
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(danmu[i][j]==1){
                    int temp=area(danmu,i,j);
                    res=Math.max(temp,res);
                }
            }
        }
        System.out.println(res);
    }
    private static   int area(int[][] danmu,int i,int j){
        //岛屿问题 判断出界
        if(!inDanmu(danmu,i,j)){
            return 0;
        }
        if(danmu[i][j]!=1){
            return 0;
        }
        //访问过
        danmu[i][j]=2;
        return 1+area(danmu,i-1,j)+area(danmu,i+1,j)+area(danmu,i,j-1)+area(danmu,i,j+1);

    }
    private static boolean inDanmu(int[][] danmu,int i,int j){
        return i>=0&&j>=0&&i<danmu.length&&j<danmu[0].length;
    }

}
