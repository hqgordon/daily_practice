package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Duxiaoman1
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2615:17
 * @Version 1.0
 * 题目描述：
 * 这是一个约瑟夫问题的变形： 有n个人围成一圈进行报数，这n个人的编号分别为1、2、3、......、n。
 * 从编号为1的人开始从1开始报数：编号为1的人报数1，编号为2的人报数2，......，
 * 第n个人报完之后第1个人又接着报。
 * 现在给出两个大于1的正整数a和b。报数为a的人首先出局；
 * 然后下一个人又从1开始报数，报数为b的人出局；下一个人再从1开始，报数为a的人出局，......，
 * 如此循环。第奇数个出局者为报数为a的人，第偶数个出局者为报数为b的人，直到只留下一人为止。
 * 现在给出n、a和b，请问最后留下的那个人的编号是多少？
 */
public class Duxiaoman1 {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String[] s = sc.nextLine().trim().split(" ");
//        int n=Integer.parseInt(s[0]);//编号设置为1-n
//        int a=Integer.parseInt(s[1]);
//        int b=Integer.parseInt(s[2]);
        // 6 3 5   3 2 6 4 5 1

        System.out.println(check(6, 3, 5));
    }
    static int check(int n,int a,int b){
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int flag=0;
        int index=0;//要删除的位置
        while(list.size()>0){
            //要删除a的位置
            if(flag==0){
                index=(index+a)%list.size();
                flag=1;
            } else if(flag==1){
                index=(index+b)%list.size();
                flag=0;
            }
            if(index!=0){
                System.out.println(list.get(index-1));
                list.remove(index-1);
                index--;
            }else {
                System.out.println(list.get(list.size()-1));

                list.remove(list.size()-1);
            }

        }
        return list.get(0);
    }
}
