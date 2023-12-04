package az.baxtiyargil.datastructuresalgorithms.list;

import az.baxtiyargil.datastructuresalgorithms.list.model.SinglyLinkedList;

public class ListMain {

    public static void main(String[] args) {
        testSinglyLinkedList();
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

}
