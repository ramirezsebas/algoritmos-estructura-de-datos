package direct_access_table;

/**
 * Table
 */
public class Table<T> {
    private T[] table;
    private int dimention;
    private int size;

    @SuppressWarnings("unchecked")
    public Table(int dimention) {
        this.size = 0;
        this.dimention = dimention;
        table = (T[]) new Object[dimention];
    }

    public int getDimention() {
        return dimention;
    }

    public int getSize() {
        return size;
    }

    public T[] getTable() {
        return table;
    }

    public void setDimention(int dimention) {
        this.dimention = dimention;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTable(T[] table) {
        this.table = table;
    }

    public void add(int key, T element) {
        table[key] = element;
        size++;
    }

    public void delete(int key) {
        table[key] = null;
        size--;
    }

    public boolean search(int key, T element) {
        if (table[key] == element) {
            return true;
        }
        return false;
    }
}