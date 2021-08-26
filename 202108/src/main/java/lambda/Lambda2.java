package lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @title: Lambda2
 * @Author hqgordon
 * @Date: 2021/8/26 11:00 上午
 * @Description:
 * @Version 1.0
 */
public class Lambda2 {
    public static void main(String[] args) {
        String[] array = {"s","s"};
        Comparator<String> stringComparator = String::compareTo;
        Arrays.sort(array, String::compareTo);
    }

}