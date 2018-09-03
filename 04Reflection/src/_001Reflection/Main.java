package _001Reflection;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.7.2018 г.
 * Time: 10:51 ч.
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Class<Reflection> aClass = Reflection.class;

        System.out.println(aClass);
        System.out.println(aClass.getSuperclass());

        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection ref = aClass.getDeclaredConstructor()
                .newInstance();

        System.out.println(ref);
    }
}