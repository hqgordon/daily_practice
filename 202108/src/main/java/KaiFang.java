/**
 * @title: KaiFang
 * @Author hqgordon
 * @Date: 2021/8/15 5:02 下午
 * @Description:
 * @Version 1.0
 */
public class KaiFang {
    public static void main(String[] args) {
//        System.out.println(Sqrt(6));
//        System.out.println(Cube(12));
        System.out.println(sqrt1(7));
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
    public static int sqrt1(int x){
        double r=x>>1;
        double l=1;
        double mid=(l+r)/2;
        double res=mid*mid;
        while(Math.abs((res-x))>1){
            if(res>x){
                r=mid;
            }else{
                l=mid;
            }
            mid=(l+r)/2;
            res=mid*mid;
        }
        return (int)r;
    }
}