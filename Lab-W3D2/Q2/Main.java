package Q2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var inputList = new ArrayList<int[]>();

        inputList.add(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        inputList.add(new int[]{0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15});
        inputList.add(new int[]{0, 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15});
        inputList.add(new int[]{0, 5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9});

        for (var input : inputList) {
            var comparisonCount = build_MaxHeap_DownUp(input, input.length-1);

            System.out.println("\nComparison count: " + comparisonCount);
            for (var i : input) {
                System.out.print(i + ", ");
            }
        }
    }

    public static int build_MaxHeap_DownUp(int[] A, int n) {
        var comparisonCount = 0;

        for (var i = n/2; i >= 1; i-- ) {
            downHeap(A, i, n);
            comparisonCount++;
        }

        return comparisonCount;
    }

    public static void downHeap(int[] A, int i, int n) {
        var j = i;
        var k = maxChildIndex(A, j, n);
        while (k !=0)
        {
            var temp = A[j];
            A[j] = A[k];
            A[k] = temp;
            j = k;
            k = maxChildIndex(A, j, n);
        }
    }

    public static int maxChildIndex(int[] A, int j, int n)
    {
        var k = j;
        if (2*j <= n && A[2*j] > A[k]) k = 2*j;
        if (2*j + 1 <= n && A[2*j + 1] > A[k]) k = 2*j + 1;
        if (k == j)
            return 0;
        else
            return k;
    }
}
