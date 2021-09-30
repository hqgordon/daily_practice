package TopK;

import java.util.*;

/**
 * @ClassName Big
 * Description 最大k个 小根堆实现 优先队列
 * @Author hqgor
 * @Date 2021/9/309:25
 * @Version 1.0
 */
public class Big {
    public static void main(String[] args) {

        ArrayList<Integer> integers = GetLeastNumbers(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 2);
        System.out.println(integers);

        int[] num={66,7,23,45,12,43,65,8,18,28,20,44,123,6,94,67,5,27,89,111,35};
        int k=7;
        int[] result=creatHeap(num,k);
        for(int i=k;i<num.length;i++)
        {
            if(num[i]>result[0])
            {
                result[0]=num[i];
                heapAdjust(result,0);
            }
        }
//        Arrays.sort(result);
        System.out.println(Arrays.toString(result));


    }
    public static ArrayList<Integer> GetLeastNumbers(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // [4,5,1,6,2,7,3,8],0
        if (input == null || k > input.length || k <= 0)    return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int len = input.length;
        for (int i = 0; i < len; ++i) {
            if (queue.size() < k) {
                queue.offer(input[i]);
                //与k个最大值中的最小值比较 大于就弹出最小
                // 并把这个数添加进来
            } else if (queue.peek() < input[i]) {
                queue.poll();
                queue.offer(input[i]);
            }
        }
        list.addAll(queue);
        return list;
    }


        public static int[] creatHeap(int[] num,int k)
        {
            int[] result=new int[k];
            for(int i=0;i<k;i++)
                result[i]=num[i];
            for(int i=result.length/2;i>=0;i--)
                heapAdjust(result,i);
            return result;

        }
        public static void heapAdjust(int[] num,int i)
        {
            int left=2*i+1;
            int right=2*(i+1);
            int min=i;
            if(i<num.length/2)
            {
                if(left<num.length&&num[left]<num[min])
                    min=left;
                if(right<num.length&&num[right]<num[min])
                    min=right;
                if(i!=min)
                {
                    int tmp=num[i];
                    num[i]=num[min];
                    num[min]=tmp;
                    heapAdjust(num,min);
                }
            }
        }
    }

