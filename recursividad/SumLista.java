/**
 * SumLista
 */
public class SumLista {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        System.out.println(suma(a, a.length));
    }

    public static int suma(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        int sum = suma(arr, n - 1) + arr[n - 1];
        return sum;
    }

}