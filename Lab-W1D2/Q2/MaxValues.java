package Q2;

class MaxValues {
    public static int[] getMaxValues(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int preMax = Integer.MIN_VALUE;
        int prePreMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                prePreMax = preMax;
                preMax = max;
                max = num;
            } else if (num > preMax) {
                prePreMax = preMax;
                preMax = num;
            } else if (num > prePreMax) {
                prePreMax = num;
            }
        }

        if (preMax == Integer.MIN_VALUE) preMax = max;
        if (prePreMax == Integer.MIN_VALUE) prePreMax = preMax;

        return new int[]{max, preMax, prePreMax};
    }
}
