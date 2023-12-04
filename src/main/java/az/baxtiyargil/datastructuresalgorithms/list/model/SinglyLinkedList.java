package az.baxtiyargil.datastructuresalgorithms.list.model;

public class SinglyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public void addFirst(E element) {
        head = new Node<>(element, head);
        if (isEmpty())
            head = tail;
        size++;
    }

    public void addLast(E element) {
        var newNode = new Node<>(element, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public E removeFirst() {
        if (isEmpty())
            return null;
        var removedElement = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty())       //because the list contains only one element, that element serves as both head and tail
            tail = null;
        return removedElement;
    }

    public E first() {
        if (isEmpty())
            return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<E> {

        private final E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElement() {
            return element;
        }

    }

}
