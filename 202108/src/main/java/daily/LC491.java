package daily;

import java.util.*;

/**
 * @ClassName LC491
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/716:12
 * @Version 1.0
 */
public class LC491 {
    public static void main(String[] args) {
        int[] nums={4,6,7,7};
        List<List<Integer>> res = new ArrayList();

        Deque<Integer> path = new LinkedList();
        Deque<Integer> used = new LinkedList();
        dfs(used,res, path, nums, 0);
        System.out.println(res);

    }

    static void dfs(Deque<Integer> used,List<List<Integer>> res, Deque<Integer> path, int[] nums, int start) {
        //收集元素大于等于2的叶子
        if (path.size() > 1) {
            res.add(new ArrayList(path));
            Arrays.sort(nums);

        }
        for (int i = start; i < nums.length; i++) {
            if (!used.isEmpty()) {
                if ((!path.isEmpty() && nums[i] < used.getLast())
                        || used.getLast() != nums[i]) {
                    continue;

                }
            }
            used.addLast(nums[i]);
            path.addLast(nums[i]);
            dfs(used,res, path, nums, start + 1);
            path.removeLast();
        }

    }
}

