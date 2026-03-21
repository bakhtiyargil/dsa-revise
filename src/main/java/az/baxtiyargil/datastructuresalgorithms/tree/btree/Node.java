package az.baxtiyargil.datastructuresalgorithms.tree.btree;

import java.util.ArrayList;
import java.util.List;

public abstract class Node<K extends Comparable<K>, V> {
    List<K> keys = new ArrayList<>();
    Node<K, V> parent;

    abstract boolean isLeaf();
}
