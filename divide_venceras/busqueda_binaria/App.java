/**
 * App
 */
public class App {

    public static void main(String[] args) {

    }

    public static <T extends Comparable<T>> int busquedaBinaria(T[] arr, T k) {
        return busquedaBinaria(arr, 0, arr.length - 1, k);
    }

    private static <T extends Comparable<T>> int busquedaBinaria(T[] arr, int ini, int fin, T k) {
        // Caso base: En caso que no quede mas elementos que comparar, retornar -1
        if (ini >= fin) {
            return -1;
        }

        // Obtenemos el elemento del medio
        int med = (ini + fin) / 2;

        // Si el elemento es igual entonces retornar su posicion
        if (k.compareTo(arr[med]) == 0) {
            return med;

        }
        // Si es que el elemento es menor partimos y buscamos en la otra mitad
        else if (k.compareTo(arr[med]) < 0) {
            return busquedaBinaria(arr, ini, med, k);
        }
        // Sino debemos partir y buscar en laotra mitad
        else {
            return busquedaBinaria(arr, med + 1, fin, k);
        }

    }
}