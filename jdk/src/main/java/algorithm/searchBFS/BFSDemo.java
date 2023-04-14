package algorithm.searchBFS;

import java.util.*;

public class BFSDemo {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2},{3,4}};
        System.out.println(a);
    }

    public void assignBoolean(boolean a) {
        a = false;
    }
    private static void fullChar(char[][] char1, boolean[][] booleans) {
        char1[1][1] = 'a';
        booleans[1][1] = true;
        int[][] steps = new int[][]{{1,2},{3,4}};
    }
    public static class Node {
        int x;

        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }
}
