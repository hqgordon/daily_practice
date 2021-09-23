package bishi;

import java.util.*;

/**
 * @ClassName JD1
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1118:29
 * @Version 1.0
 */
public class JD1 {
    public int test() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] c = s.split("\\s+");
        int size = c.length;
        int[] b = new int[size];
        for (int m = 0; m < b.length; m++) {
            b[m] = Integer.parseInt(c[m]);
        }
        //读取n行的矩阵
        int n = b[0];
        int m = b[1];
        char[][] keys = new char[n][m];
        for (int i = 0; i < b[0]; i++) {
            s = sc.nextLine();
            keys[i] = s.toCharArray();
        }
        Map<Character, List<Integer>> chars=new HashMap<>();
        for(int i=0;i<keys.length;i++){
            for (int j=0;j<keys[0].length;j++){
                List<Integer> list=new ArrayList<>();
                list.add(i);
                list.add(j);
                chars.put(keys[i][j],list);
            }
        }
        int x=b[2];
        int y=b[3];
        int z=b[4];
        String path= sc.nextLine();
        int sum=0;
        sum+=cost(keys[0][0],path.charAt(0),chars,x,y,z);
        //左上角开始 到起点
        for (int i=0;i<path.length()-1;i++) {
            sum+=cost(path.charAt(i),path.charAt(i+1),chars,x,y,z);
        }
        return sum;
    }
    //每一次移动的耗时 每次只能上下左右
    private static int cost(char start,char end,Map<Character, List<Integer>> chars,int cost1,int cost2,int cost3){
        int sum=0;
        List<Integer> list = chars.get(start);
        List<Integer> list1 = chars.get(end);
        int startx=list.get(0);
        int starty=list.get(1);
        int endx=list1.get(0);
        int endy=list1.get(1);
        //只要i,j 都不一样 那就一定有一次转向
        if(startx!=endx&&starty!=endy){
            sum+=cost2;
        }
        //点击键盘
        sum+=cost3;
        //移动 只能上下左右 那么就是直接 相减绝对值
        int x=Math.abs(startx-endx);
        int y=Math.abs(starty-endy);
        sum=sum+x+y;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new JD1().test());
    }
}
