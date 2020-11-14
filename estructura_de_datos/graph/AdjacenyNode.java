
/**
 * AdjacenyNode
 */
public class AdjacenyNode<T> {
    private int weight;
    private T parent;
    private T data;
    private int level;

    public AdjacenyNode() {
        weight = 1;
        parent = null;
        level = 0;
    }

    public AdjacenyNode(int weight, T data) {
        this.weight = weight;
        parent = null;
        this.data = data;
        level = 0;
    }

    public T getData() {
        return data;
    }

    public int getLevel() {
        return level;
    }

    public T getParent() {
        return parent;
    }

    public int getWeight() {
        return weight;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}