package src.implementacion;

import java.util.Iterator;
import java.util.LinkedList;

import src.HashTable;

/**
 * TablaDispersionAbierta
 */
public class Chaining<K> extends HashTable<K> implements Iterable<K> {

    private LinkedList<K>[] tabla;

    @SuppressWarnings("unchecked")
    public Chaining(int size) {
        this.size = size;
        this.tabla = new LinkedList[size];
    }

    public LinkedList<K>[] getTabla() {
        return tabla;
    }

    public void insertar(K clave) {
        int hashValue = hash1(clave);
        if (this.tabla[hashValue] == null)
            this.tabla[hashValue] = new LinkedList<>();

        this.tabla[hashValue].addFirst(clave);
    }

    public void eliminar(K clave) {
        int hashValue = hash1(clave);
        if (this.tabla[hashValue] == null) {
            System.out.println("No existe");
            return;
        }
        this.tabla[hashValue].remove(clave);
        if (this.tabla[hashValue].size() == 0) {
            this.tabla[hashValue] = null;
        }
    }

    public boolean busqueda(K clave) {

        int hashValue = hash1(clave);
        if (this.tabla[hashValue] == null) {
            System.out.println("No existe");
            return false;
        }
        return this.tabla[hashValue].contains(clave);
    }

    @Override
    public Iterator<K> iterator() {
        return new HashTableChainIterator<K>();
    }

}

class HashTableChainIterator<K> implements Iterator<K> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public K next() {
        return null;
    }

}