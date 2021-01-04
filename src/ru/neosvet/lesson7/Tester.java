package ru.neosvet.lesson7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        List<Method> m = new ArrayList<>();
        indexes.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(item -> m.add(item.getKey()));
        for (int i = m.size() - 1; i > -1; i--) {
            m.get(i).invoke(object);
        }

        if (indexAfter > -1)
            methods[indexAfter].invoke(object);
    }
}
