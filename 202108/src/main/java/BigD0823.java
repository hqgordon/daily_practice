import java.math.BigDecimal;

/**
 * @title: BigD0823
 * @Author hqgordon
 * @Date: 2021/8/23 2:24 下午
 * @Description:
 * @Version 1.0
 */
public class BigD0823 {
    public static void main(String[] args) {
        BigDecimal totalAmount = new BigDecimal("123");
        double v = totalAmount == null ? 0d : new Double(totalAmount.toString());
        System.out.println(v);


    }
}