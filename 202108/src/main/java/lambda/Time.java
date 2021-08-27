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
        int max,max2,max3;
        System.out.println("--------------");
         l = System.currentTimeMillis();
         max= Arrays.stream(arr).parallel().max().getAsInt();
         l2 = System.currentTimeMillis();
        System.out.println(l2-l+":max:"+max);

        System.out.println("--------------");
        l = System.currentTimeMillis();
         max= Arrays.stream(arr).max().getAsInt();
        l2 = System.currentTimeMillis();
        System.out.println(l2-l+":max:"+max);


        System.out.println("------------");
         l = System.currentTimeMillis();
          max2=Integer.MIN_VALUE;
        for(int i:arr){
            max2=Math.max(i,max2);
        }
         l2 = System.currentTimeMillis();
        System.out.println(l2-l+":max:"+max2);

        System.out.println("------------");
        l = System.currentTimeMillis();
         max3=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max3=Math.max(arr[i],max3);
        }
        l2 = System.currentTimeMillis();
        System.out.println(l2-l+":max:"+max3);

    }
}