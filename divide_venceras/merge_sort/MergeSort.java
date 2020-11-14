/**
 * MergeSort
 */
public class MergeSort {
    public static void main(String[] args) {
        Integer[] arr = {4,5,3,1,6,2};
        mergeSort(arr);

    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length-1);
        System.out.println();
    }
    private static <T extends Comparable<T>> void mergeSort(T[] arr, int ini, int fin) {
        //Caso base
        if (ini >= fin)
            return;
        int med = (ini + fin) / 2;
        mergeSort(arr, ini, med);
        mergeSort(arr, med + 1, fin);
        merge(arr, ini, med, fin);

    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] arr, int ini, int med, int fin) {
        int n = (med - ini) + 1;
        int m = fin - med;
        T[] l1 = (T[]) new Comparable[n];
        T[] l2 = (T[]) new Comparable[m];

        for (int i = 0; i < l1.length; i++)
            l1[i] = arr[ini + i];

        for (int i = 0; i < l2.length; i++)
            l2[i] = arr[med + i + 1];

        int pointer1 = 0;
        int pointer2 = 0;
        int originalIndex = ini;

        while (pointer1 < n && pointer2 < m) {
            if (l1[pointer1].compareTo(l2[pointer2]) < 0) {
                arr[originalIndex] = l1[pointer1];
                pointer1++;
            } else {
                arr[originalIndex] = l2[pointer2];
                pointer2++;

            }
            originalIndex++;
        }

        for (int i = pointer1; i < l1.length; i++) {
            arr[originalIndex] = l1[i];
            originalIndex++;
        }

        for (int i = pointer2; i < l2.length; i++) {
            arr[originalIndex] = l2[i];
            originalIndex++;
        }

    }

}
