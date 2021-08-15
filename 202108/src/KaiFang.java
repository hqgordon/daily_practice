/**
 * @title: KaiFang
 * @Author hqgordon
 * @Date: 2021/8/15 5:02 下午
 * @Description:
 * @Version 1.0
 */
public class KaiFang {
    public static void main(String[] args) {
        System.out.println(Sqrt(6));
        System.out.println(Cube(12));
    }
    public static double Sqrt(int num){
        //使用二分法进行检测 肯定是正数
        double low=0,high=num,accury=1e-5;
        double middle=(low+high)/2;
        while (Math.abs(middle*middle-num)>accury){
            if(middle*middle>num){
                high=middle;
            }else {
                low=middle;
            }
            middle=(low+high)/2;
        }
        return middle;
    }
    public static double Cube(int tmp){
        //使用二分法进行检测 三次方
        int num;
        num=tmp>0?tmp:-tmp;
        double low=0,high=num,accury=1e-5;
        double middle=(low+high)/2;
        double x=middle*middle*middle;
        while (Math.abs(x-num)>accury){
            if(x>num){
                high=middle;
            }else {
                low=middle;
            }
            middle=(low+high)/2;
            x=middle*middle*middle;
        }
        middle=tmp>0?middle:-middle;
        System.out.printf("%.6f\n",middle);
        System.out.printf("%.2f\n", middle);
        System.out.printf("%.2f%n", middle);

        return middle;
    }
}