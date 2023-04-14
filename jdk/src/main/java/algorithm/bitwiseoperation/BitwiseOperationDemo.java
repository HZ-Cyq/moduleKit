package algorithm.bitwiseoperation;

public class BitwiseOperationDemo {
    public static void main(String[] args) {
//        int a = -9;
//        System.out.println(a >> 2);
//        int a = 10;
//        a >>= 1;
//        System.out.println(a);
        for (int i = 0; i < 100; i++) {
            double pow = Math.pow(3, i);
            if(pow < Integer.MAX_VALUE) {
                System.out.println(pow);
            }
        }
    }
}
