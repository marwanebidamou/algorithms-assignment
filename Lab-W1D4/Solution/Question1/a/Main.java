package Question1.a;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 8};
        int k = 9;

        System.out.println(isSubSetSum(array, k));
    }

    public static boolean isSubSetSum(int[] a, int k) {
        if (a == null) {
            return false;
        }

        // n items in the list
        int n = a.length;
        // create matrix m
        // n + 1 to include 0, k + 1 to include 0
        boolean[][] m = new boolean[n + 1][k + 1];

        // Base case: if sum is 0, the answer is true (empty subset)
        for (int i = 0; i <= n; i++) {
            m[i][0] = true;
        }

        // populate matrix m
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= k; s++) {
                // when it goes left we don't want it to go out of bounds. (logic 4)
                if (s - a[i - 1] >= 0) {
                    m[i][s] = (m[i - 1][s] || a[i - 1] == s || m[i - 1][s - a[i - 1]]);
                } else {
                    m[i][s] = (m[i - 1][s] || a[i - 1] == s);
                }
            }
        }

        // print matrix
        print(m);

        return m[n][k];
    }

    private static void print(boolean[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j]) {
                    System.out.print("T\t");
                } else {
                    System.out.print("F\t");
                }
            }
            System.out.print("\n");
        }
    }
}
