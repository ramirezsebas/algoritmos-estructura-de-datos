/**
 * StringMatching
 */
public class StringMatching {

    public static int bruteForce(String texto, String patron) {
        int n = texto.length();
        int m = patron.length();

        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(texto.charAt(i + j) + "  ,  " + patron.charAt(j));
                if (texto.charAt(i + j) != patron.charAt(j))
                    break;

                if (j == m - 1)
                    return i;

            }
        }
        return -1;
    }

    public static void kmpMatcher(String texto, String patron) {
        int n = texto.length();
        int m = patron.length();
        int[] lps = preprocesamiento(patron);

    }

    private static int[] preprocesamiento(String patron) {
        int m = patron.length(); // O(1)

        int[] lps = new int[m]; // O(1)

        int i = 0; // O(1)
        int j = 1;

        while (j < m) {
            if (patron.charAt(i) == patron.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = lps[i - 1];
                } else {
                    lps[j] = 0;
                    j++;
                }
            }

        }

        return lps;
    }


    
}