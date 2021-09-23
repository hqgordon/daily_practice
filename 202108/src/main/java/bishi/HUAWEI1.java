package bishi;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * @ClassName HUAWEI1
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1518:58
 * @Version 1.0
 */
public class HUAWEI1 {
    //消毒器械的半径都一样 摆放位置不同

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] workstations=new int[s1.length];
        for(int i=0;i<s1.length;i++){
            workstations[i]=Integer.valueOf(s1[i]);
        }
        String s3 = sc.nextLine();
        String[] s2 = s3.split(" ");
        int[] sterilizers=new int[s2.length];
        for(int i=0;i<s2.length;i++){
            sterilizers[i]=Integer.valueOf(s2[i]);
        }
        int wl=workstations.length;
        int sl=sterilizers.length-1;
        while(sterilizers[sl]>workstations[wl-1]){
            if(sterilizers[sl-1]>workstations[wl-1]&&sl>=1){
                sl=sl-1;
            }else break;
        }
        int res=Math.abs(sterilizers[sl]-workstations[wl-1]);
        int flag=1;

        int right=sterilizers[0]+res;//记录上一个消毒器到的位置
        //从前往后进行
        //要满足 sterilizers+= 包含

        for(int i=wl-1;i>=0;){
            for(int j=sl;j>=0;j--){
                if(workstations[i]<=sterilizers[j]+res&&(workstations[i]>=sterilizers[j]-res)){
                    flag=1;
                    break;
                } else {
                    flag=0;

                }
            }
            if(flag==0){
                res++;
            }else  i--;

        }
        System.out.println(res);













        for (int i=0;i<sterilizers.length;i++){
            res=Math.max(sterilizers[i]-right,res);
            right=sterilizers[i]+res;
            if(i==sterilizers.length-1){
                res=Math.max(workstations[workstations.length-1]-sterilizers[sterilizers.length-1],res);
            }
        }
        System.out.println(res);


    }
}
