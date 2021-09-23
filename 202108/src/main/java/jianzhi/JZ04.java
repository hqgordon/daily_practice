package jianzhi;

/**
 * @ClassName JZ04
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/810:16
 * @Version 1.0
 */
public class JZ04 {
    public static void main(String[] args) {
        int[][] matrix= {{-5}};
        int target=-55;
        //首先找行 然后列中找

        int row=0;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]>=target){
                row=i+1;
                break;
            }
        }
        for(int i=0;i<row;i++){
            int l=0;
            int r=matrix[0].length-1;
            int m=0;
            while(l<=r){
                m=(l+r)/2;
                if(matrix[i][m]>target) r=m-1;
                else if(matrix[i][m]<target) l=m+1;
                else System.out.println("ss");
            }
        }

    }
}
