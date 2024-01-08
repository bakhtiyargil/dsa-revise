package az.baxtiyargil.datastructuresalgorithms.list.model;

public class SinglyLinkedList<E> implements Cloneable {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public void addFirst(E element) {
        head = new Node<>(element, head);
        if (isEmpty())
            tail = head;
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

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        // There is subtlety involving the treatment of Java’s generics framework.
        // Although our SinglyLinkedList class has a declared formal type parameter <E>,
        // we cannot detect at runtime whether the other list has a matching type.
        // (For those interested, look online for a discussion of erasure in Java.)
        // So we revert to using a more classic approach with nonparameterized type SinglyLinkedList.
        SinglyLinkedList other = (SinglyLinkedList) o;
        if (size != other.size)
            return false;

        Node walkA = head;
        Node walkB = other.head;
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement()))
                return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }

    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
        if (size > 0) {
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();
            Node<E> otherTail = other.head;
            while (walk != null) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
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
