package Question1.b;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 8};
        int k = 9;

        // Find and print the subset
        List<Integer> result = FindSubSetSum(array, k);
        if (result != null) {
            System.out.println("Subset found: " + result);
        } else {
            System.out.println("No subset found with sum " + k);
        }
    }

    public static List<Integer> FindSubSetSum(int[] a, int k) {
        if (a == null) {
            return null;
        }

        int n = a.length;
        boolean[][] m = new boolean[n + 1][k + 1];

        // Initialize the matrix: zero sum is possible with an empty subset
        for (int i = 0; i <= n; i++) {
            m[i][0] = true;
        }

        // Populate matrix m
        for (int i = 1; i <= n; i++) {
            for (int s = 0; s <= k; s++) {
                if (s - a[i - 1] >= 0) {
                    m[i][s] = (m[i - 1][s] || a[i - 1] == s || m[i - 1][s - a[i - 1]]);
                } else {
                    m[i][s] = (m[i - 1][s] || a[i - 1] == s);
                }
            }
        }

        // Print matrix (optional for debugging)
        print(m);

        // If no subset exists that adds up to k, return null
        if (!m[n][k]) {
            return null;
        }

        // Backtrack to find the elements that make up the sum
        List<Integer> result = new ArrayList<>();
        int sum = k;
        for (int i = n; i > 0 && sum > 0; i--) {
            // Check if the current element is part of the solution
            if (m[i][sum] && !m[i - 1][sum]) {
                result.add(a[i - 1]);
                sum -= a[i - 1]; // Reduce the sum by the element found
            }
        }

        return result;
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
