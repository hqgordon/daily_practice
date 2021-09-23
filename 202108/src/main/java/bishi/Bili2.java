package bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Bili2
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1319:50
 * @Version 1.0
 */
public class Bili2 {
    public static void main(String[] args) {
        //把输入转换成二维数组
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        String[] s2 = s.split(" ");
        int n=Integer.parseInt(s2[0]);
        int m=Integer.parseInt(s2[1]);

        int[][] matrix=new int[n][m];
        System.out.println(n+""+m);
        for(int i=0;i<n;i++){
            s = sc.nextLine();
            int j=0;
            for (String s1 : s.split(" ")) {
                matrix[i][j++]=Integer.parseInt(s1);
            }
        }
        StringBuilder res=new StringBuilder();
        //顺时针遍历
        int a=0;
        int b=0;//左边
        int c=matrix.length-1;
        int d=matrix[0].length-1;//右边
        while (true){
            for(int i=b;i<=d;i++){
                res.append(matrix[a][i]).append(",");
            }
            if(++a>c){
                break;
            }
            for (int i=a;i<=c;i++){
                res.append(matrix[i][d]).append(",");
            }
            if(--d<b){
                break;
            }
            for (int i=d;i>=b;i--){
                res.append(matrix[c][i]).append(",");
            }
            if(--c<a){
                break;
            }
            for (int i=c;i>=a;i--){
                res.append(matrix[i][b]).append(",");
            }
            if(++b>d){
                break;
            }
        }
        System.out.println(res.toString());

        }

}
