package az.baxtiyargil.datastructuresalgorithms.tree.btree;

import java.util.ArrayList;
import java.util.List;

public class BranchNode<K extends Comparable<K>, V> extends Node<K, V> {

    List<Node<K, V>> children = new ArrayList<>();

    @Override
    boolean isLeaf() {
        return false;
    }
}
