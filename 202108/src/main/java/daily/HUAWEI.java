package daily;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName HUAWEI
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/819:01
 * @Version 1.0
 */
public class HUAWEI {
    public static void main(String[] args) {
        //第一行表示 几个 节点
        //第二行表示 每个节点 的权值
        //先出现的是左节点
        //从某个节点分开 差值最大 相同结果 输出编号小的
        //一个数组的分割差最大？ 如何根据二叉树写出数组和可以分割的种类？
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        while (sc.hasNextLine()){

        }
        String s=sc.nextLine();
        String[] ss=s.split("\\s");
        System.out.println(Arrays.toString(ss));
        System.out.println(Arrays.toString(nums));


    }
}
