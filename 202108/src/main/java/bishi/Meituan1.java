package bishi;

import java.util.Scanner;

/**
 * @ClassName Meituan1
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2515:57
 * @Version 1.0
 */
public class Meituan1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int g=Integer.parseInt(sc.nextLine().trim());
        for(int i=0;i<g;i++){
            int[] nums=new int[3];
            int t=0;
            for (String s : sc.nextLine().split(" ")) {
                nums[t++]=Integer.parseInt(s);
            }
            int n=nums[0];
            int m=nums[1];
            int k=nums[2];
            int[][] roads=new int[n][n];
            for(int j=0;j<m;j++){
                String[] s = sc.nextLine().split(" ");
                roads[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1]=1;
                roads[Integer.parseInt(s[1])-1][Integer.parseInt(s[0])-1]=1;
            }
            int[] record=new int[k];
            t=0;
            for (String s : sc.nextLine().split(" ")) {
                record[t++]=Integer.parseInt(s)-1;
            }
            System.out.println(check(roads, record));
        }
    }
    static String check(int[][] roads,int[] record){
        for(int i=0;i<record.length-1;i++){
            if(roads[record[i]][record[i+1]]!=1){
                return "NO";
            }
        }
        return "YES";
    }

}
