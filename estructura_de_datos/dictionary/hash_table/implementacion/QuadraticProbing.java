package src.implementacion;

import java.util.Iterator;

import src.HashTable;

/**
 * TablaDispersionCerradaLineal
 */
public class QuadraticProbing<K> extends HashTable<K> implements Iterable<K> {

    @SuppressWarnings("unchecked")
    public QuadraticProbing(int size) {
        this.size = size;
        table = (K[]) new Object[size];
    }

    @SuppressWarnings("unchecked")
    public void insertar(K clave) {
        // Si la tabla llega a su maximo de factor de carga
        if (this.factorCarga >= MAX_FACTOR_CARGA) {
            this.size = 2 * this.size;
            K[] newTable = (K[]) new Object[this.size];
            reHashing(newTable);
            this.table = newTable;
            this.factorCarga = 0.0;
        }

        int hashValue = hash1(clave);
        int c = 1;
        // Mientras que la posicion en el vector este distinto a nulo.
        while (this.table[hashValue] != null) {
            hashValue = quadraticProbe(hashValue, c);
            c++;
        }
        this.table[hashValue] = clave;
        this.factorCarga = (double) numberElements(this.table) / this.size;
    }

    public boolean buscar(K clave) {
        int hashValue = hash1(clave);

        if (this.table[hashValue] == null) {
            return false;
        }

        int contador = 1;

        while (this.table[hashValue] != null) {

            if (contador == this.size) {
                return false;
            }

            if (this.table[hashValue].equals(clave)) {
                return true;
            }

            // Siguiente posicion
            hashValue = (hashValue + 1) % this.size;

            contador++;
        }

        return false;

    }

    public void eliminar(K clave) {
        int hashValue = hash1(clave);
        while (!this.table[hashValue].equals(clave) && this.table[hashValue] != null) {
            hashValue = linearProbe(hashValue);
        }

        if (this.table[hashValue].equals(clave)) {
            this.table[hashValue] = null;
        } else {
            System.out.println("No esta el elemento");
            return;
        }

        for (int i = 0; i < this.table.length; i++) {

            if (this.table[i] == null) {
                break;
            }

            hashValue = hash1(this.table[i]);
            while (this.table[hashValue] != null) {
                if (this.table[hashValue].equals(this.table[i])) {
                    break;
                }
                hashValue = linearProbe(hashValue);
            }
            if (i != hashValue) {
                this.table[hashValue] = this.table[i];
                this.table[i] = null;
            }
        }
    }

    private void reHashing(K[] newTable) {
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] != null) {
                int hashValue = hash1(this.table[i]);
                int c = 1;
                while (newTable[hashValue] != null) {
                    // Si es que esta ocupado se incrementa un intento.
                    hashValue = quadraticProbe(hashValue, c);
                    c++;
                }
                newTable[hashValue] = this.table[i];
            }
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new HashTableQuadraticIterable<K>();
    }
}

class HashTableQuadraticIterable<K> implements Iterator<K> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public K next() {
        return null;
    }

}