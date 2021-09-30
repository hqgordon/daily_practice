package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Duxiaoman2
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2615:44
 * @Version 1.0
 * 单组输入。 第1行输入两个正整数M和N，分别表示两个电视频道转播的比赛项目（电视节目）的个数，
 * 二者之间用空格隔开，每个电视频道每一天的总节目数不超过30个。
 * 接下来输入M+N行，前M行表示第1个电视频道的节目转播时间表，
 * 后N行表示第2个电视频道的节目转播时间表。
 *
 * 每一个电视节目的开始时间和结束时间用24小时制表示，包含小时和分钟，
 * 格式为：HH:MM-HH:MM，例如：11:30-13:40。每两个比赛项目时间之间用空格隔开。
 * 输出描述
 * 输出这一天小明最多可以观看的完整比赛项目的个数。
 *
 *
 * 样例输入
 * 3 4
 * 08:00-09:00
 * 09:30-11:00
 * 13:00-15:00
 * 07:00-08:00
 * 08:00-11:00
 * 12:00-13:30
 * 14:00-17:00
 * 样例输出
 * 5
 */
public class Duxiaoman2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int m=Integer.parseInt(s[0]);
        int n=Integer.parseInt(s[1]);
        List<int[]> list1=new ArrayList<>();
        List<int[]> list2=new ArrayList<>();
        for(int i=0;i<m;i++){
            //08:00-09:00
            int n1;
            int n2;
            String s1 = sc.nextLine().replace(":","");
            s1 = s1.replace("-", "");
            if(s1.charAt(0)=='0'){
                 n1=Integer.parseInt(s1.substring(1,4));
            }else n1=Integer.parseInt(s1.substring(0,4));
            if (s1.charAt(4)=='0'){
                n2=Integer.parseInt(s1.substring(5,8));
            }else n2=Integer.parseInt(s1.substring(4,8));
            list1.add(new int[]{n1,n2});
        }
        for(int i=0;i<n;i++){
            int n1;
            int n2;
            String s1 = sc.nextLine().replace(":","");
            s1 = s1.replace("-", "");
            if(s1.charAt(0)=='0'){
                n1=Integer.parseInt(s1.substring(1,4));
            }else n1=Integer.parseInt(s1.substring(0,4));
            if (s1.charAt(4)=='0'){
                n2=Integer.parseInt(s1.substring(5,8));
            }else n2=Integer.parseInt(s1.substring(4,8));
            list2.add(new int[]{n1,n2});
        }

        System.out.println(check(list1, list2));

    }
    //怎么算有交集 a，b c,d
    //a<d,and b>c 满足这两个算有交集
    //先假设都不用排序
    //没有交集的区间
    //所有区间 减去有交集的区间 ok？

    static int check( List<int[]> list1, List<int[]> list2){
        int res=list1.size()+list2.size();
        for (int[] ints : list1) {
            for (int[] ints1 : list2) {
                if(ints[0]<ints1[1]&&ints[1]>ints1[0]){
                    if (ints[1]-ints[0]<ints1[1]-ints1[0]){
                        list2.remove(ints1);
                    }else{
                        list1.remove(ints);
                        break;
                    }
                }
            }
        }
        for (int[] ints : list1) {
            for (int[] ints1 : list2) {
                if(ints[0]<ints1[1]&&ints[1]>ints1[0]){
                        res--;
                }
            }
        }
        return res;
    }
}
