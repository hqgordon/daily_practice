package Tree;

import java.io.Console;
import java.util.*;

/**
 * @ClassName TreeMaxDepth
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/109:18
 * @Version 1.0
 */
class TreeMaxDepth {

    public static class TreeNode {


        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        int[] ints = {1, 2};
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.remove();
        iterator.remove();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().intValue());
        }


        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        System.out.println(maxDepth(root));

        int[] ints1 = new int[6];
        Arrays.fill(ints1, 3);
        ints[0] = 3;
        System.arraycopy(ints, 0, ints1, 0, ints.length);
        System.out.println(Arrays.toString(ints));
        Arrays.fill(ints1, 3);

        System.out.println(Arrays.toString(ints1));
        Collections.reverse(new ArrayList(Collections.singleton(ints)));


    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
