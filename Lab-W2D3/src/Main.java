import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var arrSizes = new int[] {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};

        for (var size : arrSizes) {
            var arr1 = new int[size];
            var arr2 = new int[size];

            for (var i = 0; i < size; i++)
            {
                var num = randomNumberGenerator(1, 25000);
                arr1[i] = num;
                arr2[i] = num;
            }

            var startTime = System.nanoTime() / 1000;
            quicksort(arr1, 0, arr1.length - 1);
            var endTime = System.nanoTime() / 1000;
            System.out.println("\n");
            System.out.println("Quick sort for size "+ size +" which took " + (endTime - startTime) +" microseconds: ");
            for (var num : arr1)
            {
                System.out.print(num + ", ");
            }

            startTime = System.nanoTime() / 1000;
            newquicksort(arr2, 0, arr1.length - 1);
            endTime = System.nanoTime() / 1000;
            System.out.println("\n");
            System.out.println("New quick sort for size "+ size +" which took " + (endTime - startTime) +" microseconds: ");
            for (var num : arr2)
            {
                System.out.print(num + ", ");
            }
        }

    }

    private static void quicksort(int[] arr, int start, int stop) {
        int i, j;
// these are the moving pointers
        if (stop <= start) return;
        else {
            int pivotPos = medianOfThree(arr, start, stop);
            swap(arr, pivotPos, stop);
            int pivot = arr[stop];
            i = start;
            j = stop - 1;
            while (true) {
                while (i <= j && arr[i] < pivot) i++;
                while (i <= j && arr[j] > pivot) j--;
                if (i <= j) {
                    swap(arr, i++, j--);
                } else break;
            }
            swap(arr, stop, i);
            quicksort(arr, start, i - 1);
            quicksort(arr, i + 1, stop);
        }
    }

    private static int medianOfThree(int[] arr, int start, int stop) {
        var mid = start + (stop - start) / 2;

        var no1 = arr[start];
        var no2 = arr[mid];
        var no3 = arr[stop];
        var medianPos = -1;

        if (no1 > no3) {
            var temp = no1;
            no1 = no3;
            no3 = temp;
        }

        if (no1 > no2) {
            var temp = no1;
            no1 = no2;
            no2 = temp;
        }

        if (no2 > no3) {
            var temp = no2;
            no2 = no3;
            no3 = temp;
        }

        if (no2 == arr[start])
        {
            medianPos = start;
        }
        else if (no2 == arr[mid])
        {
            medianPos = mid;
        }
        else
        {
            medianPos = stop;
        }

        return medianPos;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void newquicksort(int[] arr, int start, int stop) {
        int i, j;
// these are the moving pointers
        if (stop <= start) return;
        else {
            int pivotPos = quickselect(arr, start, stop, start + (stop - start) / 2);
            swap(arr, pivotPos, stop);
            int pivot = arr[stop];
            i = start;
            j = stop - 1;
            while (true) {
                while (i <= j && arr[i] < pivot) i++;
                while (i <= j && arr[j] > pivot) j--;
                if (i <= j) {
                    swap(arr, i++, j--);
                } else break;
            }
            swap(arr, stop, i);
            quicksort(arr, start, i - 1);
            quicksort(arr, i + 1, stop);
        }
    }

    private static int quickselect(int[] arr, int start, int stop, int k) {
        int i, j;

        if (start == stop) {
            return start;  // If the array has only one element, return its index
        }

        int pivotPos = medianOfThree(arr, start, stop);
        swap(arr, pivotPos, stop);
        int pivot = arr[stop];
        i = start;
        j = stop - 1;

        while (true) {
            while (i <= j && arr[i] < pivot) i++;
            while (i <= j && arr[j] > pivot) j--;
            if (i <= j) {
                swap(arr, i++, j--);
            } else {
                break;
            }
        }
        swap(arr, stop, i);  // Place the pivot in its final position

        // Now pivot is at position 'i'. We compare 'i' with 'k' to decide which part to recurse into.
        if (i == k) {
            return i;  // Found the index of the k-th smallest element
        } else if (i > k) {
            return quickselect(arr, start, i - 1, k);  // Recurse into the left part
        } else {
            return quickselect(arr, i + 1, stop, k);  // Recurse into the right part
        }
    }


    private static int randomNumberGenerator(int min, int max)
    {
        return new Random().nextInt(max - min + 1) + min;
    }
}