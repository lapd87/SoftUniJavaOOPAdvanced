package _002GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.7.2018 г.
 * Time: 10:51 ч.
 */
public class Main {
    public static void main(String[] args) {

        Class<Reflection> aClass = Reflection.class;

        Method[] methods = aClass.getDeclaredMethods();

        Set<Method> getters = new TreeSet<>(Comparator
                .comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator
                .comparing(Method::getName));

        for (Method method : methods) {
            if (method.getName().startsWith("get")
                    && method.getParameterCount() == 0) {
                getters.add(method);
            } else if (method.getName().startsWith("set")
                    && method.getParameterCount() == 1) {
                setters.add(method);
            }
        }

        for (Method getter : getters) {
            System.out.printf("%s will return %s%n",
                    getter.getName(),
                    getter.getReturnType());
        }


        for (Method setter : setters) {
            System.out.printf("%s and will set field of %s%n",
                    setter.getName(),
                    setter.getParameterTypes()[0]);
        }
    }
}