package ru.neosvet.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Tester {
    private Class<?> classType;
    private ITest object;
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
        object = (ITest) classType.newInstance();
        Method[] methods = classType.getMethods();

        if (indexBefore > -1)
            methods[indexBefore].invoke(object);

        HashMap<Method, Integer> indexes = new HashMap<>();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(Test.class)) {
                indexes.put(methods[i], methods[i].getAnnotation(Test.class).priority());
            }
        }

        indexes.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(this::invokeIt);

        if (indexAfter > -1)
            methods[indexAfter].invoke(object);
    }

    private void invokeIt(Map.Entry<Method, Integer> item) {
        try {
            item.getKey().invoke(object);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
