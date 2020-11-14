package avl;

/**
 * Nodo
 */
public class Node<T extends Comparable<T>> {

    private T data;
    private int height;
    private Node<T> parent;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
        this.leftChild = this.rightChild = null;
        height = 0;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

}