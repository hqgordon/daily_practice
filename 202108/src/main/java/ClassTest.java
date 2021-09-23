import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ClassTest
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2311:16
 * @Version 1.0
 */
public class ClassTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        System.out.println(TEST.class.getName());
        Class<TEST> testClass = TEST.class;
        TEST test = testClass.newInstance();
        Constructor<TEST> constructor = testClass.getConstructor();
        for (Constructor<?> testClassConstructor : testClass.getConstructors()) {
            testClassConstructor.newInstance();
        }

        TEST test1 = constructor.newInstance();


    }
}
