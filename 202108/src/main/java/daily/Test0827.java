package daily;

import java.util.*;

/**
 * @title: Test0827
 * @Author hqgordon
 * @Date: 2021/8/27 2:51 下午
 * @Description:
 * @Version 1.0
 */
public class Test0827 {
    public static class Solution {

        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            // 使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            boolean[] used = new boolean[len];
            Deque<Integer> path = new ArrayDeque<>(len);

            dfs(nums, len, 0, path, used, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth,
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

                    System.out.println("  递归之前 => " + path);
                    System.out.println("  递归之前used => " + Arrays.toString(used));
                    dfs(nums, len, depth + 1, path, used, res);

                    used[i] = false;
                    path.removeLast();
                    System.out.println("递归之后 => " + path);
                    System.out.println("  递归之后used => " + Arrays.toString(used));

                }
            }
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 3};
            Solution solution = new Solution();
            List<List<Integer>> lists = solution.permute(nums);
            System.out.println(lists);
        }
    }


}