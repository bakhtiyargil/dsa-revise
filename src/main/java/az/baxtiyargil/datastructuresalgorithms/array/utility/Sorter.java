package az.baxtiyargil.datastructuresalgorithms.array.utility;

public class Sorter {

    public static void bubbleSort(int[] sample) {
        int hitCounter = 0;
        for (int i = 0; i < sample.length; i++) {
            for (int j = 0; j < sample.length; j++) {
                if (sample[i] < sample[j]) {
                    var temp = sample[i];
                    sample[i] = sample[j];
                    sample[j] = temp;
                }
                hitCounter++;
            }
            hitCounter++;
        }
        System.out.println("Bubble HitCounter: " + hitCounter);
    }

    public static void insertionSort(int[] array) {
        int hitCounter = 0;
        for (int i = 1; i < array.length; i++) {
            int tempI = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > tempI) {
                array[j] = array[j - 1];
                j--;
                hitCounter++;
            }
            array[j] = tempI;
            hitCounter++;
        }
        System.out.println("Insertion HitCounter: " + hitCounter);
    }

}
