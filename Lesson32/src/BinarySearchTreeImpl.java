
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

    private boolean contains = false;

    private class TreeNode {
        T value;
        TreeNode left;
        TreeNode right;

        public TreeNode(T value) {
            this.value = value;
        }
    }

    private TreeNode root;

    @Override
    public void insert(T elem) {
        root = insert(root, elem);
    }

    private TreeNode insert(TreeNode root, T elem) {
        if (root == null) {
            root = new TreeNode(elem);
        } else {
            if (root.value.compareTo(elem) >= 0) {
                root.left = insert(root.left, elem);
            } else {
                root.right = insert(root.right, elem);
            }
        }
        return root;
    }

    @Override
    public void remove(T elem) {
        if (contains(elem)) {
            if (root.value.compareTo(elem) > 0) {
                root = root.left;
            } else if (root.value.compareTo(elem) < 0) {
                root = root.right;
            } else if (root.value.compareTo(elem) == 0) {
                root.value = null;
            }
            remove(elem);

        }
        else System.out.println("No such element");
    }

    @Override
    public boolean contains(T elem) {
        if (root == null) {
            return false;
        } else if (root.value.compareTo(elem) > 0) {
            root = root.left;
        } else if (root.value.compareTo(elem) < 0) {
            root = root.right;
        } else if (root.value.compareTo(elem) == 0) {
            contains = true;
            return true;
        }
        contains(elem);
        return contains;
    }

    @Override
    public void printAll() {
        printAll(root);
    }

    private void printAll(TreeNode root) {
        if (root != null) {
            printAll(root.left);
            System.out.println(root.value);
            printAll(root.right);
        }
    }

    @Override
    public void printAllByLevels() {
        if (root == null) {
            System.out.println("Nothing in the tree");
        }
        else {
            System.out.println(root);
            

        }
    }
}
