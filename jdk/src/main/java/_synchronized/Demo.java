package _synchronized;

public class Demo {

    private int a;

    private int b;

    private int c;

    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread thread = new Thread(() -> demo.method(1,2));
        thread.start();
    }

    public void method(int a, int b) {
        set(a, b);
    }

    public void set(int a, int b) {
        this.c = a * b;
        System.out.println("enter monitor");
        synchronized (this) {
            this.a = a;
            this.b = b;
        }
        System.out.println("exit monitor");
    }
}
