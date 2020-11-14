package src;

public abstract class HashTable<K> {

    protected final double MAX_FACTOR_CARGA = 0.66;

    public K[] table;
    public int size;
    public double factorCarga;

    public abstract void insertar(K clave);

    public int quadraticProbe(int hashValue, int c) {
        return (hashValue + (int) Math.pow(c, 2)) % this.size;
    }

    public int linearProbe(int hashValue) {
        return (hashValue + 1) % this.size;
    }

    public double promedioBusquedaExitosa() {
        return ((1 / 2) * (1 + 1 / (1 - this.factorCarga)));
    }

    // Tambien para insertar
    public double promedioBusquedaNoExitosa() {
        return ((1 / 2) * (1 + 1 / Math.pow((1 - this.factorCarga), 2)));
    }

    // Contar la cantidad de elementos en una tabla
    public int numberElements(K[] table) {
        int contadorElem = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                contadorElem++;
            }
        }
        return contadorElem;
    }

    public double getFactorCarga(int espacioOcupado) {
        return (double) (espacioOcupado / this.size);
    }

    public void copiarArreglo(K[] oldTable) {

        for (int i = 0; i < oldTable.length; i++) {
            insertar(oldTable[i]);
        }
    }

    // Aplicar la funcion hash sobre una clave tenemos las 3 formas de hashear
    public int hash1(K clave) {
        return Math.abs(clave.hashCode() % this.size);
    }

    public int hash2(K clave) {
        return 1 + Math.abs(clave.hashCode() % this.size - 1);
    }

    public int dobleHashing(K clave, int c) {
        return (hash1(clave) + c * hash2(clave)) % this.size;
    }

    public double getMAX_FACTOR_CARGA() {
        return MAX_FACTOR_CARGA;
    }

    public int getSize() {
        return size;
    }

    public K[] getTable() {
        return table;
    }

}
