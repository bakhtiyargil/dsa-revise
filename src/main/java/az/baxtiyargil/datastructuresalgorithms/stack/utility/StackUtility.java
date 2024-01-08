package az.baxtiyargil.datastructuresalgorithms.stack.utility;

import az.baxtiyargil.datastructuresalgorithms.stack.model.ArrayStack;
import az.baxtiyargil.datastructuresalgorithms.stack.model.LinkedStack;
import az.baxtiyargil.datastructuresalgorithms.stack.model.Stack;


public class StackUtility {

    public static <E> void reverse(E[] data) {
        Stack<E> buffer = new ArrayStack<>();
        for (int i = 0; i < data.length; i++) {
            buffer.push(data[i]);
        }
        for (int j = 0; j < data.length; j++) {
            data[j] = buffer.pop();
        }
    }

    public static boolean isMatched(String text) {
        String openingDelimiters = "{[(";
        String closingDelimiters = "}])";
        Stack<Character> buffer = new LinkedStack<>();
        for (char ch : text.toCharArray()) {
            if (openingDelimiters.indexOf(ch) != -1) {
                buffer.push(ch);
            } else if (closingDelimiters.indexOf(ch) != -1) {
                if (buffer.isEmpty()) {
                    return false;
                }
                if (closingDelimiters.indexOf(ch) != openingDelimiters.indexOf(buffer.pop())) {
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }

}
