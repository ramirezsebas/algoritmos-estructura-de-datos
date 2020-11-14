/**
 * SumatoriaN
 */
public class SumatoriaN {

    public static void main(String[] args) {
        System.out.println(suma(5));
        System.out.println(sumaCte(5));
    }

    public static int sumaCte(int n) {
        return (n * (n + 1)) / 2;
    }

    public static int suma(int n) {
        if (n == 0)
            return 0;
        return suma(n - 1) + n;
    }
}