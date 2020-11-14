import arboles.bst.*;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        BST<Integer> bst1 = new BST<>();

        bst1.insert(30);
        bst1.insert(3);
        bst1.insert(39);
        bst1.insert(1);
        bst1.insert(4);
        bst1.inorder();
        bst1.maximumTree();
        bst1.minimumTree();
        bst1.search(4);
        bst1.succesor(4);
    }
}