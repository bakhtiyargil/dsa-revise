package az.baxtiyargil.datastructuresalgorithms.recursion.utility;

public class RecursionImplUtility {

    public static int linearSum(int[] data, int n) {
        if (n == 0)
            return 0;
        return linearSum(data, n - 1) + data[n - 1];
    }

    public static void reverseArray(int[] data, int low, int high) {
        if (low < high) {
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1);
        }
    }

    public static int power(int x, int power) {
        if (power == 0)
            return 1;
        return x * power(x, power - 1);
    }

    public static int powerOptimized(int x, int power) {
        if (power == 0) {
            return 1;
        } else {
            int partial = powerOptimized(x, power / 2);
            int result = partial * partial;
            if (x % 2 == 1)
                result *= x;
            return result;
        }
    }

}
