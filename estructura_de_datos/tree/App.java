import avl.AvlTree;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insertar(5);
        avl.insertar(3);
        avl.insertar(4);
        avl.insertar(9);
        avl.insertar(10);
        avl.insertar(2);
        avl.insertar(1);
        avl.insertar(1135);
        avl.insertar(6115);
        avl.insertar(7115);
    }
}