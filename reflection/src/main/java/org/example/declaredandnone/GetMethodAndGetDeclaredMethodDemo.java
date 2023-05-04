package org.example.declaredandnone;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetMethodAndGetDeclaredMethodDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        System.out.println("getMethods: ");
        for (Method method : ClassB.class.getMethods()) {
            System.out.println(method.getName());
        }

        System.out.println("getDeclaredMethods:");
        for (Method declaredMethod : ClassB.class.getDeclaredMethods()) {
            System.out.println(declaredMethod.getName());
        }

        Method fatherPublicMethod = ClassB.class.getMethod("fatherPublicMethod");
        ClassB clasB = new ClassB(1);
        fatherPublicMethod.invoke(clasB);

        Constructor<ClassB> constructor = ClassB.class.getConstructor(int.class);
        ClassB classB = constructor.newInstance(1);
    }
}
