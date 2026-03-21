package az.baxtiyargil.datastructuresalgorithms.tree.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BPlusTree<K extends Comparable<K>, V> {

    private Node<K, V> root;
    private final int order;

    public BPlusTree(int order) {
        this.order = order;
        this.root = new LeafNode<>();
    }

    public V search(K key) {
        LeafNode<K, V> leaf = findLeaf(key);
        for (int i = 0; i < leaf.keys.size(); i++) {
            if (leaf.keys.get(i).compareTo(key) == 0) {
                return leaf.values.get(i);
            }
        }
        return null;
    }

    public List<V> rangeSearch(K from, K to) {
        List<V> result = new ArrayList<>();
        LeafNode<K, V> leaf = findLeaf(from);

        while (leaf != null) {
            for (int i = 0; i < leaf.keys.size(); i++) {
                K k = leaf.keys.get(i);
                if (k.compareTo(to) > 0) {
                    return result;
                }
                if (k.compareTo(from) >= 0) {
                    result.add(leaf.values.get(i));
                }
            }
            leaf = leaf.next;
        }
        return result;
    }

    public void insert(K key, V value) {
        LeafNode<K, V> leaf = findLeaf(key);
        insertIntoLeaf(leaf, key, value);
        if (leaf.keys.size() > order) {
            splitLeaf(leaf);
        }
    }

    private LeafNode<K, V> findLeaf(K key) {
        Node<K, V> node = root;
        while (!node.isLeaf()) {
            BranchNode<K, V> branch = (BranchNode<K, V>) node;
            int i;
            for (i = 0; i < branch.keys.size(); i++) {
                if (key.compareTo(branch.keys.get(i)) < 0) {
                    break;
                }
            }
            node = branch.children.get(i);
        }
        return (LeafNode<K, V>) node;
    }

    private void insertIntoLeaf(LeafNode<K, V> leaf, K key, V value) {
        int i = 0;
        while (i < leaf.keys.size() && key.compareTo(leaf.keys.get(i)) > 0) {
            i++;
        }
        leaf.keys.add(i, key);
        leaf.values.add(i, value);
    }

    private void splitLeaf(LeafNode<K, V> leaf) {
        int mid = leaf.keys.size() / 2;
        LeafNode<K, V> newLeaf = new LeafNode<>();

        newLeaf.keys.addAll(leaf.keys.subList(mid, leaf.keys.size()));
        newLeaf.values.addAll(leaf.values.subList(mid, leaf.values.size()));

        leaf.keys = new ArrayList<>(leaf.keys.subList(0, mid));
        leaf.values = new ArrayList<>(leaf.values.subList(0, mid));

        newLeaf.next = leaf.next;
        if (leaf.next != null) {
            leaf.next.prev = newLeaf;
        }
        leaf.next = newLeaf;
        newLeaf.prev = leaf;

        if (leaf.parent == null) {
            BranchNode<K, V> newRoot = new BranchNode<>();
            newRoot.keys.add(newLeaf.keys.get(0));
            newRoot.children.add(leaf);
            newRoot.children.add(newLeaf);
            root = newRoot;
            leaf.parent = newRoot;
            newLeaf.parent = newRoot;
        } else {
            insertIntoParent(leaf, newLeaf.keys.get(0), newLeaf);
        }
    }

    private void insertIntoParent(Node<K, V> left, K key, Node<K, V> right) {
        BranchNode<K, V> parent = (BranchNode<K, V>) left.parent;
        int idx = parent.children.indexOf(left) + 1;
        parent.keys.add(idx - 1, key);
        parent.children.add(idx, right);
        right.parent = parent;

        if (parent.keys.size() > order) {
            splitBranch(parent);
        }
    }

    private void splitBranch(BranchNode<K, V> branch) {
        int mid = branch.keys.size() / 2;

        BranchNode<K, V> newBranch = new BranchNode<>();
        K upKey = branch.keys.get(mid);

        newBranch.keys.addAll(branch.keys.subList(mid + 1, branch.keys.size()));
        newBranch.children.addAll(branch.children.subList(mid + 1, branch.children.size()));

        for (Node<K, V> child : newBranch.children) {
            child.parent = newBranch;
        }

        branch.keys = new ArrayList<>(branch.keys.subList(0, mid));
        branch.children = new ArrayList<>(branch.children.subList(0, mid + 1));

        if (branch.parent == null) {
            BranchNode<K, V> newRoot = new BranchNode<>();
            newRoot.keys.add(upKey);
            newRoot.children.add(branch);
            newRoot.children.add(newBranch);
            branch.parent = newRoot;
            newBranch.parent = newRoot;
            root = newRoot;
        } else {
            insertIntoParent(branch, upKey, newBranch);
        }
    }

    public void printTree() {
        Queue<Node<K, V>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node<K, V> node = q.poll();
                System.out.print(node.keys + " ");
                if (!node.isLeaf()) {
                    q.addAll(((BranchNode<K, V>) node).children);
                }
            }
            System.out.println();
        }
    }
}
