package jianzhi;

/**
 * @ClassName JZ03
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/89:31
 * @Version 1.0
 */
public class JZ03 {
    public static void main(String[] args) {
        int[] nums={2, 3, 1, 0, 2, 5, 3};
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            //效果 把每个数字放到每个位置上 2就在2的位置
            if(nums[nums[i]] == nums[i]) System.out.println(nums[i]);
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }

    }
}
