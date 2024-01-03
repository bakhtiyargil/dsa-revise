package az.baxtiyargil.datastructuresalgorithms.recursion;

import az.baxtiyargil.datastructuresalgorithms.recursion.implementation.BinarySearch;
import az.baxtiyargil.datastructuresalgorithms.recursion.implementation.EnglishRuler;
import az.baxtiyargil.datastructuresalgorithms.recursion.implementation.Factorial;

public class RecursionMain {

    public static void main(String[] args) {
        binarySearchTesting();
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

}
