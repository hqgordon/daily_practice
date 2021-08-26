package lambda;

import java.util.*;
import java.util.stream.*;


/**
 * @title: Lambda3
 * @Author hqgordon
 * @Date: 2021/8/26 2:37 下午
 * @Description:
 * @Version 1.0
 */
public class Lambda3 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bob", "Alice", "Tim");
        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons);
    }
}

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    public String toString() {
        return "Person:" + this.name;
    }
}
