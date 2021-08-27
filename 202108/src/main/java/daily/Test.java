package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title: Test
 * @Author hqgordon
 * @Date: 2021/8/26 5:48 下午
 * @Description:
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        List<List<Integer>> list=new ArrayList<>();
        List<List<Integer>> list2=new ArrayList<>();
        List<Integer> tmp = Arrays.asList(1,2,3);
        list2.add(tmp);
        list2.add(tmp);

        list2.add(tmp);

        List<Integer> res=new ArrayList<>();
        list2.forEach(list3->{
            list3 = Arrays.asList(1, 2, 3, 4);
            list.add(list3);

        });
        list.forEach(System.out::println);
        list2.forEach(System.out::println);
    }
}