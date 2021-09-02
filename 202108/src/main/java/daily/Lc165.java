package daily;

import java.util.Arrays;

/**
 * @title: Lc165
 * @Author hqgordon
 * @Date: 2021/9/1 9:12 上午
 * @Description:
 * @Version 1.0
 */
public class Lc165 {
    public static void main(String[] args) {

        System.out.println(compareVersion("1.0", "1.0.0"));

    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length1=v1.length;
        int length2=v2.length;
        for(int i=v1.length-1; i>=0;i--){
            if(Integer.valueOf(v1[i])==0) length1--;
        }

        for(int i=v2.length-1; i>=0;i--){
            if(Integer.valueOf(v2[i])==0) length2--;
        }
        int flag = 0;
        if(v1.length>v2.length) flag = 1;
        if(v1.length<v2.length) flag = -1;
        for (int i = 0, j = 0; i < length1 && j < length2; i++, j++) {
            if(Integer.valueOf(v1[i])>Integer.valueOf(v2[j])) return 1;
            else if(Integer.valueOf(v1[i])<Integer.valueOf(v2[j])) return -1;
            else if(Integer.valueOf(v1[i])==Integer.valueOf(v2[j]) && (v1.length==i+1||v2.length==j+1))  return flag  ;
            else continue;
        }
        return 0;
    }
}