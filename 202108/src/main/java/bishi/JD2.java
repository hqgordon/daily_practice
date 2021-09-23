package bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName JD2
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1120:37
 * @Version 1.0
 */
public class JD2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        //1~n范围
        List<int []> services=new ArrayList<>();
        services.add(new int[]{});
        int servicesAlive = 0;
        //从1开始
        for (int i = 1; i <= n; i++) {
            String s = sc.nextLine();
            String[] c = s.substring(1).split("\\s+");
            int size = c.length;
            int[] b = new int[size+1];
            for (int m = 0; m < b.length; m++) {
                b[m] = Integer.parseInt(c[m]);
            }
            //最后一位用于标记是否开启服务
            b[size]=0;
            services.add(b);
        }
        //services里1到n 存储的是1到n关联的服务数组
        int option;
        int serviceNum;
        for (int i = 0; i < q; i++) {
            option = sc.nextInt();
            serviceNum = sc.nextInt();
            servicesAlive=optionService(servicesAlive,option,serviceNum,services);
            System.out.println(servicesAlive);
        }

    }
    //返回正在运行的服务
    //依赖关系：a依赖b a打开 b打开 a关闭 b不关闭 b关闭 a关闭
    private static int optionService(int servicesAlive ,int option,int serviceNum,List<int []> services){
        if(option==1){

        }
        if (option==0){

        }
        return 1;
    }

}
