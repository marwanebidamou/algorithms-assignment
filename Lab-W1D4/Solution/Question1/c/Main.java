package Question1.c;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 8};
        int k = 9;

        // Find and print all subsets
        List<List<Integer>> results = findAllSubsetsWithSum(array, k);
        if (!results.isEmpty()) {
            System.out.println("Subsets found: " + results);
        } else {
            System.out.println("No subsets found with sum " + k);
        }
    }

    public static List<List<Integer>> findAllSubsetsWithSum(int[] a, int k) {
        if (a == null || a.length == 0) {
            return new ArrayList<>(); // Return an empty list if the array is invalid
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

        // If no subset exists that adds up to k, return an empty list
        if (!m[n][k]) {
            return new ArrayList<>();
        }

        // Backtrack to find all subsets that add up to k
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(a, m, n, k, currentSubset, results);

        return results;
    }

    private static void backtrack(int[] a, boolean[][] m, int i, int sum, List<Integer> currentSubset, List<List<Integer>> results) {
        // Base case: if sum becomes 0, we found a valid subset
        if (sum == 0) {
            results.add(new ArrayList<>(currentSubset));
            return;
        }

        // If there are no more elements or sum becomes negative, return
        if (i == 0 || sum < 0) {
            return;
        }

        // Exclude the current element and move to the previous row
        if (m[i - 1][sum]) {
            backtrack(a, m, i - 1, sum, currentSubset, results);
        }

        // Include the current element if it's part of the subset
        if (sum >= a[i - 1] && m[i - 1][sum - a[i - 1]]) {
            currentSubset.add(a[i - 1]);
            backtrack(a, m, i - 1, sum - a[i - 1], currentSubset, results);
            // Remove the current element (backtrack)
            currentSubset.remove(currentSubset.size() - 1);
        }
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
