package lambda;

import java.util.Arrays;
import java.util.Random;

//162:max:1073741805
//        --------------
//        86:max:1073741805
//        ------------
//        87:max:1073741805
//        ------------
//        70:max:1073741805

/**
 * @title: Time
 * @Author hqgordon
 * @Date: 2021/8/27 3:34 下午
 * @Description:
 * @Version 1.0
 */
public class Time {
    public static void main(String[] args) {
        int n=100000000;
        int[] arr=new int[n];
        int up=1<<30;
        Random random=new Random();
        for(int i=0;i<n;i++){
            arr[i]=random.nextInt(up);
        }
        long l,l2;
        int max;
        System.out.println("------Stream并行--------");
         l = System.currentTimeMillis();
         max= Arrays.stream(arr).parallel().max().getAsInt();
         l2 = System.currentTimeMillis();
        System.out.println(l2-l+":max:"+max);

        System.out.println("-----Stream不使用并行---------");
        l = System.currentTimeMillis();
         max= Arrays.stream(arr).max().getAsInt();
        l2 = System.currentTimeMillis();
        System.out.println(l2-l+":max:"+max);

        System.out.println("----增强for循环--------");
         l = System.currentTimeMillis();
          max=Integer.MIN_VALUE;
        for(int i:arr){
            max=Math.max(i,max);
        }
         l2 = System.currentTimeMillis();
        System.out.println(l2-l+":max:"+max);

        System.out.println("--for循环----------");
        l = System.currentTimeMillis();
         max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(arr[i],max);
        }
        l2 = System.currentTimeMillis();
        System.out.println(l2-l+":max:"+max);
    }
}