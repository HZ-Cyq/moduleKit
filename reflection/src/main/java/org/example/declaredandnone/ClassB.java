package org.example.declaredandnone;

public class ClassB extends ClassA {
    private int a;

    public ClassB(int a) {
        System.out.println("ClassB constructor");

    }
    public int publicMethod() {
        return a;
    }

    int defaultMethod() {
        return a;
    }

    protected int protectedMethod() {
        return a;
    }

    private int privateMethod() {
        return a;
    }

    @Override
    public void fatherPublicMethod() {
        System.out.println("fatherPublicMethod invoke by child");
    }
}
