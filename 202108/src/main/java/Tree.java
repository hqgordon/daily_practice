import org.springframework.core.annotation.Order;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @title: Tree
 * @Author hqgordon
 * @Date: 2021/8/14 12:05 下午
 * @Description:
 * @Version 1.0
 */
public class Tree {
    public static int TreeNodeNum(String[] args) {

        TreeNode root = new TreeNode(1);
        int res = 0;
        Deque<TreeNode> deque = new LinkedList();
        if (root == null) {
            return 0;
        }
        deque.add(root);
        res++;
        while (!deque.isEmpty()) {
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = deque.pollFirst();
                assert poll != null;
                if (poll.left != null) {
                    deque.add(poll.left);
                    res++;
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                    res++;
                }
            }
        }
        return res;
    }
}
