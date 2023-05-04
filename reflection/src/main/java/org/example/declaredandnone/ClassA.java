package org.example.declaredandnone;

public class ClassA {

    public ClassA(int a) {
        System.out.println(a + "classA constructor");
    }

    public ClassA() {
    }

    public void fatherPublicMethod() {
        System.out.println("fatherPublicMethod invoke by father");
    }

    void fatherDefaultMethod() {

    }

    protected void fatherProtectedMethod() {
    }

    private void fatherPrivateMethod() {

    }
}
