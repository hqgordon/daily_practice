package jvm;

/**
 * @ClassName Wraper
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1417:04
 * @Version 1.0
 */
public class Wraper {
    public static void main(String[] args) {
        Character c='2';
        char c1 = c;
        System.out.println(c1);
        System.out.println(test(c));
    }
    private static int test(char c){
        return 1;
    }
}
