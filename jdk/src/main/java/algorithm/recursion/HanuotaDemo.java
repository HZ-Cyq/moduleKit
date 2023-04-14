package algorithm.recursion;

public class HanuotaDemo {
    public static void main(String[] args) {
        // f(n) = min(f(i) * 2 + f(n - i)), f(1) = 1;
        for (int i = 1; i < 12; i++) {
            System.out.println(findN(i));
        }
    }
    private static int findN(int n) {
        if(n == 1) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i ++) {
            int temp = findN(i) * 2 + findN(n - i);
            if(temp < min) {
                min = temp;
            }
        }
        return min;
    }
}
