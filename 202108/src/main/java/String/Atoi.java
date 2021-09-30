package String;

/**
 * @ClassName Atoi
 * Description 将字符串转化为整数
 * 实现函数 atoi 。函数的功能为将字符串转化为整数
 * 提示：仔细思考所有可能的输入情况。这个问题没有给出输入的限制，你需要自己考虑所有可能的情况。
 *
 *
 * atoi函数位于cpp <stdlib.h>库。该函数舍弃字符串前全部空白符，直至找到一个合法的数字或者正负号后开始读取，
 * 然后尽可能读取多的字符组成合法的整数表示，并返回这个合法的整数，值得注意的是，当读取到一个非法字符后将直接停止读取数字并返回当前已转换结果。
 * 注意，数学中e表示数的幂在该函数定义中是非法字符。当输入数字超出返回数据类型范围是一个未定义行为（undefined behavior），本题保证不会出现这种情况。
 *
 * 数据范围：字符串长度满足
 * 要求：空间复杂度 ，时间复杂度

 * @Author hqgor
 * @Date 2021/9/3017:34
 * @Version 1.0
 */
public class Atoi {

    public static void main(String[] args) {
        int atoi = new Atoi().atoi("      +123e1234214");
        System.out.println(atoi);
    }

    /**
     * @param str string字符串
     * @return int整型
     */
    public int atoi(String str) {
        // write code here
        if (str.length() == 0 || str == null) {
            return 0;
        }
        String res = "";
        int i = 0;
        str = str.trim();
        if (str.equals("")) {
            return 0;
        }
        int t = 1;//标记正数负数
        //判断首字符合法
        if (str.charAt(0) != '-' && str.charAt(0) != '+' && (str.charAt(0) > '9' || str.charAt(0) < '0')) {
            return 0;
            //判断首字符是否为符号
        } else if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            i = 1;
            while (i < str.length() && str.charAt(i) < '9' && str.charAt(i) > '0') {
                i++;
            }
            //为符号如果为负号
            if (i > 1) {
                res = str.substring(1, i);
                if (str.charAt(0) == '-') {
                    t = -1;
                }
            } else {
                return 0;
            }
            //首字符不为符号
        } else {
            i = 0;
            while (i < str.length() && str.charAt(i) < '9' && str.charAt(i) > '0') {
                i++;
            }
            res = str.substring(0,i);
        }
        //去除答案开头的0
        i = 0;
        while (i < str.length() && res.charAt(i) == '0') {
            i++;
        }
        res = res.substring(i);
        if (res.equals("")) {
            return 0;
        }
        //输出正负情况
        if(t==-1){
            return -Integer.parseInt(res);
        }else {
            return Integer.parseInt(res);

        }

    }
}

