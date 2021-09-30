package TopK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @ClassName Small
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2921:23
 * @Version 1.0
 */
public class Small {
    public static void main(String[] args) {

        ArrayList<Integer> integers = GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 2);
        System.out.println(integers);

    }
        public static ArrayList<Integer> GetLeastNumbers(int [] input, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            // [4,5,1,6,2,7,3,8],0
            if (input == null || k > input.length || k <= 0)    return list;
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            int len = input.length;
            for (int i = 0; i < len; ++i) {
                if (queue.size() < k) {
                    queue.offer(input[i]);
                    //与k个最大值中的最小值比较 大于就弹出最小
                    // 并把这个数添加进来
                } else if (queue.peek() > input[i]) {
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
            list.addAll(queue);
            return list;
        }


    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // [4,5,1,6,2,7,3,8],0
        if (input == null || k > input.length || k <= 0)
            return list;
        int[] target = new int[k];
        int len = input.length;
        for (int i = 0; i < len; ++i) {
            if (i < k) {
                target[i] = input[i];
                heapInsertSiftUp(target, i, target[i]);
            } else {
                if (target[0] > input[i]) { // 最大堆下沉
                    target[0] = input[i];
                    siftDown(target, 0, target[0]);
                    // 相比优先级队列，这里不会offer操作(里面有上浮)，少了一步上浮调整，效率高了不止一丁点
                }
            }
        }
        for (int i = 0; i < k; ++i) {
            list.add(target[i]);
        }
        return list;
    }

    private static void heapInsertSiftUp(int[] target, int index, int x) {
        while (index > 0) {
            int parent = (index - 1) >>> 1;
            if (x > target[parent]) {
                target[index] = target[parent]; // 往下拉，避免直接上浮覆盖前面的值
                index = parent;
            } else {
                break;
            }
        }
        target[index] = x;
    }



    private static void siftDown(int[] target, int k, int x) {
        int half = target.length >>> 1;
        while (k < half) {
            int child = (k << 1) + 1; // 默认先左孩子
            int big = target[child];
            int right = child + 1;
            if (right < target.length && target[right]>big) {
                big = target[right];
                child = right; // 可以直接一步big = target[child = right];
            }
            if (x>big) // x比子节点中的最大值还大，已经是大顶堆了
                break; // 往上拉不动了，准备退出把最初堆顶的结点赋值到上一个结点
            target[k] = big; // 往上拉
            k = child;
        }
        target[k] = x;
    }

}
