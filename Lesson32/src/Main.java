
public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst =
                new BinarySearchTreeImpl<>();
        bst.insert(12);
        bst.insert(15);
        bst.insert(11);
        bst.printAll();
        System.out.println(bst.contains(12));
    }
}
