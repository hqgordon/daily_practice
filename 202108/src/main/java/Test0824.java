import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.time.Duration;

/**
 * @title: Test0824
 * @Author hqgordon
 * @Date: 2021/8/24 2:11 下午
 * @Description:
 * @Version 1.0
 */
public class Test0824 {
    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("#root.val");
        TreeNode order = new TreeNode();
        order.setVal(2);
        System.out.println(expression.getValue(order));
        String s="ssssfasd@sda.ccom";
        System.out.println(s.contains(""));
        Duration duration = Duration.ofHours(1);
        System.out.println(duration);

    }
}
