package az.baxtiyargil.datastructuresalgorithms.recursion;

import az.baxtiyargil.datastructuresalgorithms.recursion.implementation.BinarySearch;
import az.baxtiyargil.datastructuresalgorithms.recursion.implementation.EnglishRuler;
import az.baxtiyargil.datastructuresalgorithms.recursion.implementation.Factorial;
import az.baxtiyargil.datastructuresalgorithms.recursion.utility.RecursionImplUtility;

import java.util.Arrays;

public class RecursionMain {

    public static void main(String[] args) {
        //binarySumTesting();
        //powerOptimizedTesting();
        //powerTesting();
        //reverseArrayTesting();
        //linearSumTesting();
        //binarySearchTesting();
        //englishRulerTesting();
        //factorialTesting();
    }

    public static void factorialTesting() {
        var fact5 = Factorial.factorial(5);
        System.out.println(fact5);
    }

    public static void englishRulerTesting() {
        EnglishRuler.drawRuler(1, 5);
    }

    public static void binarySearchTesting() {
        int[] data = {1, 2, 3, 4, 5, 6};
        System.out.println(data.length);
        var exists = BinarySearch.search(data, 7, 0, data.length - 1);
        System.out.println(exists);
    }

    public static void linearSumTesting() {
        int[] data = {1, 1, 2, 3};
        var sum = RecursionImplUtility.linearSum(data, data.length);
        System.out.println("Sum: " + sum);
    }

    public static void binarySumTesting() {
        int[] data = {1, 1, 2, 3};
        var sum = RecursionImplUtility.binarySum(data, 0, data.length - 1);
        System.out.println("Sum: " + sum);
    }

    public static void reverseArrayTesting() {
        int[] data = {1, 1, 2, 3};
        RecursionImplUtility.reverseArray(data, 0, data.length - 1);
        System.out.println("Data: " + Arrays.toString(data));
    }

    public static void powerTesting() {
        var power = RecursionImplUtility.power(5, 3);
        System.out.println("Power: " + power);
    }

    public static void powerOptimizedTesting() {
        var power = RecursionImplUtility.powerOptimized(5, 3);
        System.out.println("Power: " + power);
    }

}
