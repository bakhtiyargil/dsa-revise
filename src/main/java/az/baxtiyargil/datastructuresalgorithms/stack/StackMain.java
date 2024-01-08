package az.baxtiyargil.datastructuresalgorithms.stack;

import az.baxtiyargil.datastructuresalgorithms.stack.model.ArrayStack;
import az.baxtiyargil.datastructuresalgorithms.stack.utility.StackUtility;

import java.util.Arrays;

public class StackMain {

    public static void main(String[] args) {
        isMatchedTest();
        //arrayReverseWithStackTest();
        //arrayStackTest();
    }

    public static void arrayReverseWithStackTest() {
        Integer[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
        StackUtility.reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void arrayStackTest() {
        var arrStack = new ArrayStack<String>();
        arrStack.push("A");
        arrStack.push("B");
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());
    }

    public static void isMatchedTest() {
        var is = StackUtility.isMatched("{alba{neymar(suarez)messi}alves}");
        System.out.println(is);
    }

}
