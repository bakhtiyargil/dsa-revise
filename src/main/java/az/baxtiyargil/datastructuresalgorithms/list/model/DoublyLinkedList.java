package az.baxtiyargil.datastructuresalgorithms.list.model;

import lombok.Getter;
import lombok.Setter;

public class DoublyLinkedList<E> {

    private final Node<E> header;
    private final Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return trailer.getPrev().getElement();
    }

    public void addFirst(E element) {
        addBetween(element, header, header.getNext());
    }

    public void addLast(E element) {
        addBetween(element, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty())
            return null;
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty())
            return null;
        return remove(trailer.getPrev());
    }

    private void addBetween(E element, Node<E> predecessor, Node<E> successor) {
        var newNode = new Node<>(element, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }

    private E remove(Node<E> node) {
        var predecessor = node.getPrev();
        var successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    @Getter
    private static class Node<E> {

        private final E element;

        @Setter
        private Node<E> prev;

        @Setter
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

    }

}