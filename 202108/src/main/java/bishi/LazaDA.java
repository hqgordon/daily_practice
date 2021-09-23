package bishi;

import java.util.*;

/**
 * @ClassName LazaDA
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1620:16
 * @Version 1.0
 */
public class LazaDA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(depress(sc.nextLine()));
        }

    }
    private static String depress(String str){
        StringBuilder sb=new StringBuilder();
        char temp=str.charAt(0);//当前字符
        int n=1;//次数
        for(int i=1;i<str.length();i++){
            if(temp==str.charAt(i)) n++;
            else {
                if (n != 1) sb.append(n).append(temp);
                else sb.append(temp);
                temp = str.charAt(i);
                n = 1;
            }
        }
        return sb.append(n).append(temp).toString();
    }
}

