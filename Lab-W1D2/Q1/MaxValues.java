package Q1;

class MaxValues {
    public static int[] getMaxValues(int[] arr) {
        var startTime = System.nanoTime();

        if (arr == null || arr.length == 0) {
            return null;
        }

        int max1 = Integer.MIN_VALUE;
        int indexMax1 = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max1 = arr[i];
                indexMax1 = i;
            }
        }

        int max2 = Integer.MIN_VALUE;
        int indexMax2 = -1;

        for (int i = 0; i < arr.length; i++) {
            if (indexMax1 != i && arr[i] >= max2) {
                max2 = arr[i];
                indexMax2 = i;
            }
        }

        int max3 = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (indexMax1 != i && indexMax2 != i && arr[i] >= max3) {
                max3 = arr[i];
            }
        }

        var endTime = System.nanoTime();

        var empericalTime = endTime - startTime;
        System.out.println("Emperical Time in nano seconds: " + empericalTime);

        return new int[]{max1, max2, max3};
    }
}
