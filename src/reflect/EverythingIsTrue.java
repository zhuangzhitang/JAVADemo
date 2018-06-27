package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author zhitang
 * @date 2018/6/27
 */
public class EverythingIsTrue {

    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        System.out.println(field.getModifiers());
        System.out.println(Modifier.toString(field.getModifiers()));
        System.out.println(~Modifier.FINAL);
        System.out.println(field.getModifiers() & ~Modifier.FINAL);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }
    public static void main(String args[]) throws Exception {
        setFinalStatic(Boolean.class.getField("FALSE"), true);

        System.out.format("Everything is %s", false); // "Everything is true"
    }
}
