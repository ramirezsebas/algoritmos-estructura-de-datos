/**
 * Ordenamiento
 */
public class Ordenamiento {
    

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        T key;

        int i;

        for (int j = 1; j < arr.length; j++) {
            key = arr[j];

            i = j - 1;

            while (i >= 0 && arr[i].compareTo(key) > 0) {
                arr[i + 1] = arr[i];

                i -= 1;

            }

            arr[i + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        int n = arr.length;
        int salto = n / 2;
        boolean flag = false;

        while (salto > 0) {
            flag = true;
            for (int i = 0; i + salto < n; i++) {
                if (arr[i].compareTo(arr[i + salto]) > 0) {
                    swap(arr, i, i + salto);
                    flag = false;
                }
            }
            if (flag)
                salto /= 2;
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - (i + 1); j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] arr, int ini, int fin) {
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

        T[] l1 = (T[]) new Object[n];

        T[] l2 = (T[]) new Object[m];

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

    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int ini, int fin) {
        if (ini < fin) {
            int pivote = particion(arr, ini, fin);
            quickSort(arr, ini, pivote - 1);
            quickSort(arr, pivote + 1, fin);
        }

    }

    private static <T extends Comparable<T>> int particion(T[] arr, int ini, int fin) {
        T pivote = arr[fin];

        int i = 0;
        int j = fin - 1;

        while (i <= j) {
            if (arr[i].compareTo(pivote) < 0) {
                i++;
            } else if (arr[j].compareTo(pivote) > 0) {
                j--;
            } else {
                swap(arr, i, j);
            }
        }
        swap(arr, i, fin);
        return i;
    }

    public static void countingSort(int[] arr) {
        int max = getMax(arr);

        char[] countArray = new char[max + 1];

        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i]] += 1;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        char[] finalArray = new char[max + 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            // finalArray[arr[i]] = countArray[arr[i]] - 1;
        }

        System.out.println();

    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}