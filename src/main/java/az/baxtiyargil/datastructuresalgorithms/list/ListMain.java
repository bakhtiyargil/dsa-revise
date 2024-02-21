package az.baxtiyargil.datastructuresalgorithms.list;

import az.baxtiyargil.datastructuresalgorithms.list.model.CircularlyLinkedList;
import az.baxtiyargil.datastructuresalgorithms.list.model.DoublyLinkedList;
import az.baxtiyargil.datastructuresalgorithms.list.model.SinglyLinkedList;
import az.baxtiyargil.datastructuresalgorithms.list.positional.LinkedPositionalList;
import az.baxtiyargil.datastructuresalgorithms.list.utility.Sorter;

public class ListMain {

    public static void main(String[] args) {
        testLinkedPositionalList();
        //testDoublyLinkedList();
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

    public static void testLinkedPositionalList() {
        var list = new LinkedPositionalList<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.iterator().forEachRemaining(System.out::println);
        Sorter.insertionSort(list);
        System.out.println("--after sorting--");
        list.iterator().forEachRemaining(System.out::println);
    }

}
