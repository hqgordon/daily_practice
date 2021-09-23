package daily;

import java.util.*;

/**
 * @ClassName LC46
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/715:44
 * @Version 1.0
 */
public class LC46 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();


        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);


        dfs(nums, len, 0, path, used, res);
        System.out.println(res);

    }
    static private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));

            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                System.out.println("1：i="+i+"  "+"depth="+depth);
                dfs(nums, len, depth + 1, path, used, res);
                System.out.println("2：i="+i+"  "+"depth="+depth);


                used[i] = false;
                path.removeLast();

            }
        }
    }
    }

