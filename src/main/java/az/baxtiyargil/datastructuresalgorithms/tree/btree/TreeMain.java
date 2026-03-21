package az.baxtiyargil.datastructuresalgorithms.tree.btree;

public class TreeMain {
    public static void main(String[] args) {
        LeafNode<Integer, String> leaf = new LeafNode<>();
        leaf.values.add("a");
        leaf.values.add("b");
        leaf.values.add("c");
        leaf.values.forEach(System.out::println);
    }
}
