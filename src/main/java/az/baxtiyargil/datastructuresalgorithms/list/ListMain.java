package az.baxtiyargil.datastructuresalgorithms.list;

import az.baxtiyargil.datastructuresalgorithms.list.model.CircularlyLinkedList;
import az.baxtiyargil.datastructuresalgorithms.list.model.DoublyLinkedList;
import az.baxtiyargil.datastructuresalgorithms.list.model.SinglyLinkedList;

public class ListMain {

    public static void main(String[] args) {
        testDoublyLinkedList();
        //testCircularlyLinkedList();
        //testSinglyLinkedList();
    }

    public static void testSinglyLinkedList() {
        var list = new SinglyLinkedList<String>();
        list.addFirst("Aaa");
        list.addFirst("Bbb");
        list.addFirst("Ccc");
        System.out.println(list.first());
        list.removeFirst();
        System.out.println(list.first());
    }

    public static void testCircularlyLinkedList() {
        var list = new CircularlyLinkedList<>();
        list.addFirst("Aaa");
        list.addFirst("Bbb");
        list.addFirst("Ccc");
        System.out.println(list.first());
        list.removeFirst();
        System.out.println(list.first());
    }

    public static void testDoublyLinkedList() {
        var list = new DoublyLinkedList<>();
        list.addFirst("Aaa");
        list.addFirst("Bbb");
        list.addFirst("Ccc");
        System.out.println(list.first());
        var removedElement = list.removeFirst();
        System.out.println("Removed element: " + removedElement);
        System.out.println(list.first());
    }

}
