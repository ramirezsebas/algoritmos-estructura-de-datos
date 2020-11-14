package avl;

/**
 * AvlTree
 */
public class AvlTree<T extends Comparable<T>> {
    private Node<T> root;

    // Creamos un arbol vacio
    public AvlTree() {
        this.root = null;
    }

    // Balanceado, y el costo seria O(log n)
    public void insertar(T data) {
        Node<T> nuevoNodo = new Node<T>(data);
        // Si la root esta vacio(Arbol vacio) el nuevo nodo creado le volvemos la root
        if (root == null) {
            root = nuevoNodo;
        } else {
            root = insertar(root, data);
        }
    }

    private Node<T> insertar(Node<T> nodoActual, T data) {
        if (nodoActual == null) {
            return new Node<T>(data);
        }

        if (data.compareTo(nodoActual.getData()) > 0) {
            nodoActual.setRightChild(insertar(nodoActual.getRightChild(), data));
        } else {
            nodoActual.setLeftChild(insertar(nodoActual.getLeftChild(), data));
        }

        // Como debemos mantener el arbol balanceado, actualizamos la altura para
        // verificar
        nodoActual = actualizarAltura(nodoActual);

        // Obtenemos un factor de balanceo que seria la resta de la altura del hijo
        // derecho menos la altura del hijos izquierdo y no debe superar 1 en valor
        // absoluto
        int factorBalanceo = getFactorBalanceo(nodoActual);

        // Esta desbalanceado en el lado derecho ademas solo requiere una rotacion hacia
        // la izquierda
        if (factorBalanceo > 1 && data.compareTo(nodoActual.getRightChild().getData()) > 0) {
            return rotacionIzquierda(nodoActual);
        }

        // Esta desbalanceado en el lado derecho ademas requiere doble rotacion
        if (factorBalanceo > 1 && data.compareTo(nodoActual.getRightChild().getData()) < 0) {
            return rotacionDobleIzquierda(nodoActual);
        }

        // Esta desbalanceado en el lado izquierdo ademas requiere una rotacion
        if (factorBalanceo < -1 && data.compareTo(nodoActual.getLeftChild().getData()) < 0) {
            return rotacionDerecha(nodoActual);
        }

        // Esta desbalanceado en el lado izquierdo ademas requiere doble rotacion
        if (factorBalanceo < -1 && data.compareTo(nodoActual.getLeftChild().getData()) > 0) {
            return rotacionDobleDerecha(nodoActual);
        }

        return nodoActual;

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

    public void search(T data) {
        if (search(root, data)) {
            System.out.println(data + " existe en el arbol.");
        } else {
            System.out.println(data + " no existe en el arbol.");
        }
    }

    // Permite rotar el arbol si esta desbalanceado
    // Solo usamos variables y movemos punteros -> O(1)
    private Node<T> rotacionDerecha(Node<T> nodoDesbalanceado) {
        Node<T> temp = nodoDesbalanceado.getLeftChild();

        nodoDesbalanceado.setLeftChild(temp.getRightChild());

        temp.setRightChild(nodoDesbalanceado);

        nodoDesbalanceado = actualizarAltura(nodoDesbalanceado);

        temp = actualizarAltura(temp);

        return temp;
    }

    private Node<T> rotacionIzquierda(Node<T> nodoDesbalanceado) {
        Node<T> temp = nodoDesbalanceado.getRightChild();
        nodoDesbalanceado.setRightChild(temp.getLeftChild());
        temp.setLeftChild(nodoDesbalanceado);
        nodoDesbalanceado = actualizarAltura(nodoDesbalanceado);
        temp = actualizarAltura(temp);
        return temp;
    }

    private Node<T> rotacionDobleIzquierda(Node<T> nodoDesbalanceado) {
        nodoDesbalanceado.setRightChild(rotacionDerecha(nodoDesbalanceado.getRightChild()));
        return rotacionIzquierda(nodoDesbalanceado);
    }

    private Node<T> rotacionDobleDerecha(Node<T> nodoDesbalanceado) {
        nodoDesbalanceado.setLeftChild(rotacionIzquierda(nodoDesbalanceado.getLeftChild()));
        return rotacionDerecha(nodoDesbalanceado);
    }

    // Actualizar el arbol O(1)
    private Node<T> actualizarAltura(Node<T> nodoActual) {
        // Sabemos que la altura de un subarbol es:
        // Altura del subarbol izquierdo menos la altura del subarbol derecho

        nodoActual.setHeight(Math.max(getAltura(nodoActual.getLeftChild()), getAltura(nodoActual.getRightChild())) + 1);
        return nodoActual;
    }

    // Obtener la altura -> O(1)
    private int getAltura(Node<T> nodo) {
        return nodo == null ? -1 : nodo.getHeight();
    }

    // Obtener el factor de balanceo -> O(1)
    private int getFactorBalanceo(Node<T> nodoActual) {
        return getAltura(nodoActual.getRightChild()) - getAltura(nodoActual.getLeftChild());
    }

}