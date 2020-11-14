package bst;

/**
 * BST
 */

public class BST<T extends Comparable<T>> {

    Node<T> root;

    // Creamos un arbol vacioo
    public BST() {
        this.root = null;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node<T> root) {
        if (root == null) {
            return;
        }
        inorder(root.getLeftChild());
        System.out.println(root.getData());
        inorder(root.getRightChild());
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node<T> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        preorder(root.getLeftChild());
        preorder(root.getRightChild());
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node<T> root) {
        if (root == null) {
            return;
        }
        postorder(root.getLeftChild());
        postorder(root.getRightChild());
        System.out.println(root.getData());

    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> minimum(Node<T> node) {
        Node<T> temp = node;

        while (temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }
        return temp;
    }

    public void minimumTree() {
        Node<T> temp = minimum(root);
        if (temp == null) {
            System.out.println("No tiene un valor minimo el arbol");
        } else {
            System.out.println("El minimo valor del arbol es: " + temp.getData());
        }
    }

    private Node<T> maximun(Node<T> node) {
        Node<T> temp = node;

        while (temp.getRightChild() != null) {
            temp = temp.getRightChild();
        }
        return temp;

    }

    public void maximumTree() {
        Node<T> temp = maximun(root);
        if (temp == null) {
            System.out.println("No tiene un valor maximo el arbol");
        } else {
            System.out.println("El maximo valor del arbol es: " + temp.getData());
        }
    }

    private Node<T> insert(Node<T> root, T data) {
        if (root == null) {
            return new Node<T>(data);
        }

        Node<T> temp = root;
        if (data.compareTo(temp.getData()) > 0) {
            temp.setRightChild(insert(temp.getRightChild(), data));
        } else {
            temp.setLeftChild(insert(temp.getLeftChild(), data));
        }
        return temp;
    }

    public void search(T data) {
        if (search(root, data)) {
            System.out.println(data + " existe en el arbol.");
        } else {
            System.out.println(data + " no existe en el arbol.");
        }
    }

    private boolean search(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.getData()) > 0) {
            return search(node.getRightChild(), data);
        } else if (data.compareTo(node.getData()) < 0) {
            return search(node.getLeftChild(), data);
        } else {
            return true;
        }

    }

    public void succesor(T data) {
        // Node<T> nodo = search(root, data);
        // if (!search(root, data)) {
        // System.out.println(data + " no existe en el arbol.");
        // return;
        // }
        // Node<T> temp = succesor(root, data);
        // if (temp == null) {
        // System.out.println(data + " no tiene sucesor");
        // } else {
        // System.out.println("El succesor de " + data + " es " + temp.getData());
        // }
    }

    private Node<T> succesor(Node<T> node, T data) {
        if (node.getRightChild() != null)
            return minimum(node.getRightChild());

        Node<T> succesor = null;
        Node<T> x = root;
        while (node.getData() != x.getData() && x != null) {
            succesor = x;
            if (data.compareTo(x.getData()) > 0) {
                x = x.getRightChild();
            } else {
                x = x.getLeftChild();
            }
        }
        return succesor;
    }

}