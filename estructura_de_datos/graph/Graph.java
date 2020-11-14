import java.util.LinkedList;
import java.util.Queue;

/**
 * Creamos un grafo en la cual la estructura utilizado serian dos listas que nos
 * permite a nosotros en uno guardar keys y e la otra una lista de las aristas
 * de ese nodo.
 *
 * Obs: La lista de keys, cada uno tiene un indice y ese indice mapea al indice
 * de la lista de las aristas.
 */

public class Graph<T> {
    private LinkedList<T> keys;
    private LinkedList<LinkedList<AdjacenyNode<T>>> adjacenyList;

    private int numVertexes;

    public Graph(int numVertexes) {
        this.numVertexes = numVertexes;
        keys = new LinkedList<>();
        adjacenyList = new LinkedList<>();
    }

    public Graph() {
        keys = new LinkedList<>();
        adjacenyList = new LinkedList<>();
        numVertexes = 0;
    }

    public int getNumVertexes() {
        return numVertexes;
    }

    public void put(T src, T destination, int weight) {
        AdjacenyNode<T> temp = new AdjacenyNode<>(weight, src);
        AdjacenyNode<T> temp1 = new AdjacenyNode<>(weight, destination);

        // Si la key que queremos ingresar no existe agregamos a la lista de keys
        if (!keys.contains(src) && !keys.contains(destination)) {
            addNode(src, destination, weight);
            // Si deseamos un grafo dirigido debemos comentar la sgnt. linea
            addNode(destination, src, weight);
        } else if (keys.contains(src) && !keys.contains(destination)) {
            // Si la key ya existe solo agregamos un elemento a la lista de adjacencia
            adjacenyList.get(keys.indexOf(src)).add(temp1);
            addNode(destination, src, weight);
            // adjacenyList.get(keys.indexOf(destination)).add(src);
        } else if (!keys.contains(src) && keys.contains(destination)) {
            adjacenyList.get(keys.indexOf(destination)).add(temp);
            addNode(src, destination, weight);
        } else {
            adjacenyList.get(keys.indexOf(src)).add(temp1);
            adjacenyList.get(keys.indexOf(destination)).add(temp);
        }

    }

    private void addNode(T src, T destination, int weight) {
        AdjacenyNode<T> temp = new AdjacenyNode<>(weight, destination);
        keys.add(src);

        LinkedList<AdjacenyNode<T>> list = new LinkedList<>();
        list.add(temp);
        adjacenyList.add(list);
        numVertexes++;
    }
    

    public void bfs(T key) {
        // Recorrido bfs
        if (numVertexes > 0) {
            Queue<T> cola = new LinkedList<>();
            boolean[] visitedNodes = new boolean[numVertexes];
            cola.add(key);

            visitedNodes[keys.indexOf(key)] = true;

            while (!cola.isEmpty()) {
                T visitedNode = cola.remove();
                System.out.print(visitedNode + " -> ");
                for (AdjacenyNode<T> node : adjacenyList.get(keys.indexOf(visitedNode))) {
                    if (!visitedNodes[keys.indexOf(node.getData())]) {
                        cola.add(node.getData());
                        visitedNodes[keys.indexOf(node.getData())] = true;
                    }
                }

            }
        }

    }

    public void dfs(T key) {
        // Recorrido dfs
        System.out.println();
        if (numVertexes > 0) {
            boolean[] visitedNodes = new boolean[numVertexes];
            dfsExplore(key, visitedNodes);
        }
    }

    private void dfsExplore(T key, boolean[] visitedNodes) {
        // System.out.print(key + " -> " + +" -> ");
        visitedNodes[keys.indexOf(key)] = true;
        for (AdjacenyNode<T> data : adjacenyList.get(keys.indexOf(key))) {
            if (!visitedNodes[keys.indexOf(data.getData())]) {
                dfsExplore(data.getData(), visitedNodes);
            }
        }
    }

}