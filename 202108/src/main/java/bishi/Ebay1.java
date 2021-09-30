package bishi;

import java.util.Scanner;

/**
 * @ClassName Ebay1
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2919:38
 * @Version 1.0
 */
public class Ebay1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int m=Integer.parseInt(s[0]);
        int n=Integer.parseInt(s[1]);
        System.out.println(lucky(m,n));
    }
    static int lucky(int m,int n){
        int res=0;
        for(int i=m;m<=n;i++){
            if(isLucky(i)) res++;
        }
        return res;
    }
    static boolean isLucky(int i){
        String str= String.valueOf(i);
        if(str.contains("6")||str.contains("17")){
            return true;
        }
        return false;
    }
}
