package bishi;

import java.util.Scanner;

/**
 * @ClassName guanglianda1
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2220:46
 * @Version 1.0
 */
public class guanglianda1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        int n=Integer.parseInt(s);
        String s1 = sc.nextLine();
        String[] s2 = s1.split(" ");
        int a1=Integer.parseInt(s2[0]);
        int b1=Integer.parseInt(s2[1]);
         s1 = sc.nextLine();
         s2 = s1.split(" ");
        int a2=Integer.parseInt(s2[0]);
        int b2=Integer.parseInt(s2[1]);
        int sum=0;//总口碑
        if((a1*a1+b1*b1)>(a2*a2+b2*b2)){
            System.out.println(n+" "+0);
        }else {
            System.out.println(0+" "+n);
        }




    }
}
