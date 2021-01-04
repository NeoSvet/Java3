package ru.neosvet.lesson7;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Tester {
    private Class<?> classType;
    private int indexBefore = -1;
    private int indexAfter = -1;

    public Tester(Class<?> classType) {
        this.classType = classType;
    }

    public void checkMethods() throws RuntimeException {
        Method[] methods = classType.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                if (indexBefore == -1) {
                    indexBefore = i;
                } else {
                    throw new RuntimeException("The class '" + classType.getName()
                            + "' has methods with more than one 'BeforeSuite'.");
                }
            }
            if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                if (indexAfter == -1) {
                    indexAfter = i;
                } else {
                    throw new RuntimeException("The class '" + classType.getName()
                            + "' has methods with more than one 'AfterSuite'.");
                }
            }
        }
    }


    public void start() throws Exception {
        ITest object = (ITest) classType.newInstance();
        Method[] methods = classType.getMethods();

        if (indexBefore > -1)
            methods[indexBefore].invoke(object);

        HashMap<Method, Integer> indexes = new HashMap<>();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(Test.class)) {
                indexes.put(methods[i], methods[i].getAnnotation(Test.class).priority());
            }
        }

        Object[] m = indexes.entrySet().stream().sorted(Map.Entry.comparingByValue()).toArray();
        for (int i = m.length - 1; i > -1; i--) {
            ((Map.Entry<Method, Integer>)m[i]).getKey().invoke(object);
        }

        if (indexAfter > -1)
            methods[indexAfter].invoke(object);
    }
}
