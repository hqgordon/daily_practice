package TopK;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Matrix
 * Description 排序矩阵的第k大
 * @Author hqgor
 * @Date 2021/9/309:25
 * @Version 1.0
 */
public class Matrix {
    public static void main(String[] args) {
        int[][] matrix={{1,5,7},{3,7,8},{4,8,9}};
        int i = new Matrix().kthSmallest(matrix, 3);
        System.out.println(i);
    }

        public int kthSmallest(final int[][] matrix, int k) {
            boolean[][] visited = new boolean[matrix.length][matrix[0].length];
            PriorityQueue<int[]> heap = new PriorityQueue<int[]>(k, new Comparator<int[]>(){
                public int compare(int[] a, int[] b) {
                    return Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]);
                }
            });
            heap.add(new int[]{0,0});
            visited[0][0] = true;
            while (k > 1) {
                int[] res = heap.remove();
                int x = res[0];
                int y = res[1];


                if (x+1 < matrix.length && visited[x+1][y] == false) {
                    visited[x+1][y] = true;
                    heap.add(new int[]{x+1, y});
                }
                if (y+1 < matrix[0].length && visited[x][y+1] == false) {
                    visited[x][y+1] = true;
                    heap.add(new int[]{x, y+1});
                }
                k--;
            }
            int[] res = heap.remove();
            return matrix[res[0]][res[1]];
        }

}
