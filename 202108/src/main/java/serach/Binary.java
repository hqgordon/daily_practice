package serach;

/**
 * @title: Binary
 * @Author hqgordon
 * @Date: 2021/8/30 9:49 上午
 * @Description:
 * @Version 1.0
 */
public class Binary {
    public static void main(String[] args) {
        int[] pre={1,3,6};
        System.out.println(search(pre, 1));
        System.out.println(search(pre, 2));
        System.out.println(search(pre, 3));
        System.out.println(search(pre, 4));
        System.out.println(search(pre, 5));
        System.out.println(search(pre, 6));
        System.out.println(search(pre, 7));

    }
    public static int search(int[] pre, int x) {
        int low = 0, high = pre.length-1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // if(pre[low]!=x) return -1;
        return low;
    }
}