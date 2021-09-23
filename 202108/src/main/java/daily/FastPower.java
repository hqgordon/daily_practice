package daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName FastPower
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/815:24
 * @Version 1.0
 */
public class FastPower {
    public static void main(String[] args) {
        System.out.println(fastpower(2, 100));
        Deque<Integer> path=new ArrayDeque<>();


    }
    static int fastpower(int base,int power){
        int result=1;
        while (power>0){
            if((power&1)==1){
                result=result*base%1000;
            }
            power=power/2;
            base=base*base%1000;

        }
        return  result;
    }
}
