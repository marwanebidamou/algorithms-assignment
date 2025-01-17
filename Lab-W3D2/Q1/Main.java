package Q1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var inputList = new ArrayList<int[]>();

        inputList.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        inputList.add(new int[]{2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15});
        inputList.add(new int[]{4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15});
        inputList.add(new int[]{5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9});

        for (var input : inputList)
        {
            var output = new int[input.length + 1];
            var comparisionCount = 0;

            for (var i = 0; i < input.length; i++) {
                output[i + 1] = input[i];
                comparisionCount += build_MaxHeap_TopDown(output, i + 1, comparisionCount);
            }
            System.out.println("\nComparision count: " + comparisionCount);
            for (var i : output) {
                System.out.print(i + ", ");
            }
        }
    }

    public static int build_MaxHeap_TopDown(int[] A, int n, int comparisionCount) {
        for (int i = n; i >= 1; i--) {
            upHeap(A, i);
            comparisionCount++;
        }

        return comparisionCount;
    }

    public static int[] upHeap(int[] A, int i) {
        int j = i;

        while (j > 1 && A[j / 2] < A[j]) {
            var temp = A[j / 2];
            A[j / 2] = A[j];
            A[j] = temp;
            j = j / 2;
        }

        return A;
    }
}