package az.baxtiyargil.datastructuresalgorithms.recursion;

import az.baxtiyargil.datastructuresalgorithms.recursion.implementation.EnglishRuler;
import az.baxtiyargil.datastructuresalgorithms.recursion.implementation.Factorial;

public class RecursionMain {

    public static void main(String[] args) {
        englishRulerTesting();
        //factorialTesting();
    }

    public static void factorialTesting() {
        var fact5 = Factorial.factorial(5);
        System.out.println(fact5);
    }

    public static void englishRulerTesting() {
        EnglishRuler.drawRuler(1, 5);
    }

}
