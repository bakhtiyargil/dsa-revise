package az.baxtiyargil.datastructuresalgorithms.stack.model;

import az.baxtiyargil.datastructuresalgorithms.list.model.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {

    private final SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedStack() {
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

}
