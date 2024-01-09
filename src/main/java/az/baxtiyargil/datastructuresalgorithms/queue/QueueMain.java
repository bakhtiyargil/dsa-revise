package az.baxtiyargil.datastructuresalgorithms.queue;

import az.baxtiyargil.datastructuresalgorithms.queue.model.ArrayQueue;

public class QueueMain {

    public static void main(String[] args) {
        arrayQueueTest();
    }

    public static void arrayQueueTest() {
        var arrayQueue = new ArrayQueue<String>();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        var dequeuedElement = arrayQueue.dequeue();
        System.out.println(dequeuedElement);
    }

}