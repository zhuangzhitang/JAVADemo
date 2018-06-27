package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author zhitang
 * @date 2018/6/26
 * Java反射之如何判断类或变量、方法的修饰符(Modifier解析)
 *  Java针对类、成员变量、方法，有很多修饰符，例如public、private、static、final、synchronized、abstract等，这些修饰符用来控制访问权限或其他特性
 */
public class MyTest {
    public int a;
    public static int b;
    public static final int c = 0;
    private int d;

    public static void main(String[] args) {
        Class clazz = MyTest.class;
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.print(field.getName() +"->");

            System.out.println(Modifier.toString(field.getModifiers()));
        }
    }
}
