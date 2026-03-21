package az.baxtiyargil.datastructuresalgorithms.tree.btree;

import java.util.ArrayList;
import java.util.List;

public class LeafNode<K extends Comparable<K>, V> extends Node<K, V> {
    List<V> values = new ArrayList<>();
    LeafNode<K, V> next;
    LeafNode<K, V> prev;

    @Override
    boolean isLeaf() {
        return true;
    }
}
