package Q3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var inputList = new ArrayList<int[]>();

        inputList.add(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        inputList.add(new int[]{0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15});
        inputList.add(new int[]{0, 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15});
        inputList.add(new int[]{0, 5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9});

        for (var input : inputList)
        {
            Q2.Main.build_MaxHeap_DownUp(input, input.length - 1);

            heapSortPhaseTwo(input, input.length-1);

            System.out.println();
            for (var i : input) {
                System.out.print(i + ", ");
            }
        }
    }

    public static void heapSortPhaseTwo(int[] A, int n)
    {
        for(var i = n; i > 1; i--)
        {
            var temp = A[1];
            A[1] = A[i];
            A[i] = temp;

            Q2.Main.downHeap(A, 1, i - 1);
        }
    }
}
