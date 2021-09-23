package bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName baidu2
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2219:39
 * @Version 1.0
 */
public class baidu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s2 = s.split(" ");
        System.out.println(Arrays.toString(s2));
        int n=Integer.parseInt(s2[0]);
        int k=Integer.parseInt(s2[1])-1;
        String[] s1 = sc.nextLine().split(" ");
        int[] coins=new int[s1.length];
        for(int i=0;i< s1.length;i++){
            coins[i]=Integer.parseInt(s1[i]);
        }
        if(coins[k]==0) {
            System.out.println(0);
            return;
        }
        int[] sum=new int[n+1];
        sum[0]=0;
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+coins[i-1];
        }
        int left=-1;
        int right=-1;
        int flag=0;
        for(int i=0;i<n;i++){
            if(coins[i]==1&&flag==0) {
                left=i;
                flag++;
            }
            if(coins[i]==1&&flag==1) {
                right=i;
                flag++;
            }
        }
        if(left!=-1&&right!=-1&&k<=right&&k>=left){
            System.out.println(sum[right]-sum[left]);
        }
        if(right==-1&&left>k){
            System.out.println(sum[left+1]-sum[k]);
        }
        if(left==-1){
            System.out.println(sum[n]-sum[0]);
        }
        if(left!=-1&&right!=-1&&right<=k){
            System.out.println(sum[left+1]-sum[k]);
        }
        if(left!=-1&&right!=-1&&left>k){
            System.out.println(sum[left+1]-sum[0]);
        }
    }
}
