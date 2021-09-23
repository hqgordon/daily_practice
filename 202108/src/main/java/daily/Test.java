package daily;

import java.util.*;

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
        List<String> res=new ArrayList();
        Deque<Character> path = new LinkedList();
        path.add('2');
        path.add('3');
        String s1 = Arrays.toString(path.toArray());
        String s = new String(String.valueOf(path));
        System.out.println(s);
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};


        List<Integer> res1=new ArrayList<>();
        list2.forEach(list3->{
            list3 = Arrays.asList(1, 2, 3, 4);
            list.add(list3);

        });
        list.forEach(System.out::println);
        list2.forEach(System.out::println);
    }
}

