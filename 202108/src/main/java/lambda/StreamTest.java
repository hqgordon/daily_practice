package lambda;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @title: StreamTest
 * @Author hqgordon
 * @Date: 2021/8/26 2:52 下午
 * @Description:
 * @Version 1.0
 */
public class StreamTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        stream.forEach(System.out::println);
        Stream.generate(Math::random).limit(2).map((o1) -> o1 + o1).forEach(System.out::println);
        Stream.iterate(0, t -> t + 2).limit(20).forEach(System.out::println);
        //实现了Supplier接口 会不断的调用里面的get方法
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(20).forEach(System.out::println);
        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5);
        Function<Integer,Integer> stringStringFunction=n1->n1+n1;
        Stream<Integer> s2 = s.map(stringStringFunction);




// 将int[]数组变为IntStream:
        IntStream is = Arrays.stream(new int[]{1, 2, 3});
// 将Stream<String>转换为LongStream:
        LongStream ls = Stream.of("1", "2", "3").mapToLong(Long::parseLong);
        Stream.of("  Apple ", " pear ", " ORANGE", " BaNaNa ")
                .map(String::trim) // 去空格
                .map(String::toLowerCase) // 变小写
                .forEach(System.out::println); //

        Optional<Integer> sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(Integer::sum);
        System.out.println(true); // 45
    }


    static class NatualSupplier implements Supplier<Integer> {
        int n = 0;
        int t=1;

        public Integer get() {
            int tmp = n;
            n = t;
            t += tmp;
            return n;
        }
    }
}