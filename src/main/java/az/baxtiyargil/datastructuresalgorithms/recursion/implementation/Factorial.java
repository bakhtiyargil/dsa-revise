package az.baxtiyargil.datastructuresalgorithms.recursion.implementation;

public class Factorial {

    public static int factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Must be greater than zero");
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

}
