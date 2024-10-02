package Q1;

public class Main {
    public static void main(String[] args) {
        int[] arr = {7, 20, 18, 4, 20, 20, 19, 3};
        int[] result = MaxValues.getMaxValues(arr);

        if (result != null) {
            System.out.println("First Max: " + result[0]);
            System.out.println("Second Max: " + result[1]);
            System.out.println("Third Max: " + result[2]);
        } else {
            System.out.println("Array is empty");
        }
    }
}
