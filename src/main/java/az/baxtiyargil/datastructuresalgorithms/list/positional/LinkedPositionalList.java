package az.baxtiyargil.datastructuresalgorithms.list.positional;

import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E>, Iterable<E> {

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        this.header = new Node<>(null, null, null);
        this.trailer = new Node<>(null, header, null);
        this.header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> first() {
        return position(header.getNext());
    }

    public Position<E> last() {
        return position(trailer.getPrev());
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        return answer;
    }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newNode = new Node<>(e, pred, succ);
        pred.setNext(newNode);
        succ.setPrev(newNode);
        size++;
        return newNode;
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer)
            return null;
        return node;
    }

    @Getter
    @Setter
    private static class Node<E> implements Position<E> {

        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            this.element = e;
            this.prev = p;
            this.next = n;
        }

        @Override
        public E getElement() {
            if (next == null)
                throw new IllegalStateException("Position no longer valid");
            return element;
        }

    }

    private class PositionIterator implements Iterator<Position<E>> {

        private Position<E> cursor = first();
        private Position<E> recent = null;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Position<E> next() {
            if (cursor == null)
                throw new NoSuchElementException("nothing left");
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }

        @Override
        public void remove() {
            if (recent == null)
                throw new IllegalStateException("nothing to remove");
            LinkedPositionalList.this.remove(recent);
            recent = null;
        }

    }

    private class PositionIterable implements Iterable<Position<E>> {

        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }

    }

    private class ElementIterator implements Iterator<E> {

        Iterator<Position<E>> positionIterator = new PositionIterator();

        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        public E next() {
            return positionIterator.next().getElement();
        }

        public void remove() {
            positionIterator.remove();
        }
    }

    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    }

}
