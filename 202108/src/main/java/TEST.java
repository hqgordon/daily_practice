import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TEST
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1721:44
 * @Version 1.0
 */
public class TEST {
    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
        synchronized (lock){
            lock.wait();
            System.out.println(BigDecimal.valueOf(Math.pow(3, 19)).toString());

        }

    }
}
