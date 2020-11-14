import java.util.Arrays;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        int n = 40;
        int[] moneda = { 1, 3, 5, 8, 10 };
        System.out.println(coinChangeMemo(n, moneda, new int[n + 1]));
    }

    private static int coinChangeTab(int n, int[] moneda) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, (int) Double.POSITIVE_INFINITY);
        return 0;
    }

    private static int coinChangeMemo(int n, int[] moneda, int[] memo) {
        int result = (int) Double.POSITIVE_INFINITY;
        if (n == 0) {
            return 0;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        for (int j = 0; j < moneda.length; j++) {
            if (n - moneda[j] >= 0) {
                result = Math.min(result, 1 + coinChange(n - moneda[j], moneda));
            }
        }
        memo[n] = result;
        return memo[n];
    }

    private static int coinChange(int n, int[] moneda) {
        int result = (int) Double.POSITIVE_INFINITY;
        if (n == 0) {
            return 0;
        }
        for (int j = 0; j < moneda.length; j++) {
            if (n - moneda[j] >= 0) {
                result = Math.min(result, 1 + coinChange(n - moneda[j], moneda));
            }
        }
        return result;
    }
}