/**
 * @ClassName StringAdd
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2815:18
 * @Version 1.0
 */
public class StringAdd {
    public static void main(String[] args) {
        System.out.println(add2("1232112321421", "3214124"));
        System.out.println(add("1232112321421", "3214124"));

    }

    public static String add2(String n1, String n2) {
        StringBuffer result = new StringBuffer();
        //1、反转字符串 才是从小到大
        n1 = new StringBuffer(n1).reverse().toString();
        n2 = new StringBuffer(n2).reverse().toString();

        int len1 = n1.length();
        int len2 = n2.length();
        int maxLen = len1 > len2 ? len1 : len2;
        boolean nOverFlow = false; //是否越界
        int nTakeOver = 0; //溢出数量

        //2.把两个字符串补齐，即短字符串的高位用0补齐
        if (len1 < len2) {
            for (int i = len1; i < len2; i++) {
                n1 += "0";
            }
        } else if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                n2 += "0";
            }
        }
        //3.把两个正整数相加，一位一位的加并加上进位
        for (int i = 0; i < maxLen; i++) {
            int nSum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "");

            if (nSum >= 10) {
                if (i == (maxLen - 1)) {
                    nOverFlow = true;
                }
                nTakeOver = 1;
                result.append(nSum - 10);
            } else {
                nTakeOver = 0;
                result.append(nSum);
            }
        }
        //如果溢出的话表示位增加了
        if (nOverFlow) {
            result.append(nTakeOver);
        }
        return result.reverse().toString();
    }

    public static String add(String... params) {
        int maxLeng = 0;
        //获取最大长度
        for (String s : params) {
            if (s.length() > maxLeng) maxLeng = s.length();
        }

        StringBuffer result = new StringBuffer();
        //进位 数
        int high = 0;
        //将每个待加参数每一位相加 进位
        for (int i = 0; i < maxLeng; i++) {
            int charInt = 0;
            for (String s : params) {
                //高位不够用0代替
                charInt += s.length() - 1 < i ?
                        0 : Integer.parseInt(s.charAt(s.length() - 1 - i) + "");
            }
            charInt += high;
            //进位
            high = charInt / 10;
            //当前位的值 为charInt 余数
            int remainder = charInt % 10;
            result.append(remainder);
        }
        //最后一次进位
        if (high > 0) {
            result.append(high);
        }
        //反转 输出结果
        return result.reverse().toString();
    }
}
