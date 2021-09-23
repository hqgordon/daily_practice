package jvm;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ObjectSpace
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/1410:15
 * @Version 1.0
 */
public class ObjectSpace {
    public static void main(String[] args) {
        List i1=new ArrayList();
        i1.add(1);


//        System.out.println(i1.hashCode());
        System.out.println(ClassLayout.parseInstance(i1).toPrintable());


    }
}
