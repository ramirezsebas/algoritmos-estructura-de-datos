import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		int x = 1111;
		int y = 1111;

		int x1 = 999;
		int y1 = 999;

		int x2 = 122341;
		int y2 = 758211;

		BigInteger p1 = new BigInteger(Integer.toString(x2));
		BigInteger p2 = new BigInteger(Integer.toString(y2));

		long timer1 = System.nanoTime();
		int solucionLenta = slowMultiplication(x, y);
		long timer1Final = System.nanoTime();
		long dur1 = timer1Final - timer1;

		long timer2 = System.nanoTime();
		int solucionRapido = karatsubaMultiplication(x, y);
		long timer2Final = System.nanoTime();
		long dur2 = timer2Final - timer2;

		System.out.println("La multiplicacion de " + x + " por " + y + " es " + solucionLenta);
		System.out.println("La multiplicacion de " + x + " por " + y + " es " + solucionRapido);

		System.out.println("La solucion de multiplicacion clasica lleva " + (dur1 / 1000000000.0) + " segundos");
		System.out.println("La solucion de multiplicacion con karatsuba lleva " + (dur2 / 1000000000.0) + " segundos");

	}

	// Costo final es de O(n^2)
	public static int slowMultiplication(int x, int y) {
		return slowMultiplication(Integer.toString(x), Integer.toString(y));
	}

	public static int slowMultiplication(BigInteger x, BigInteger y) {
		return slowMultiplication(x.toString(), y.toString());
	}

	private static int slowMultiplication(String x, String y) {
		// Lista donde guardaremos las sumas
		List<Integer> list = new ArrayList<>();
		// El salto de cada linea en las sumas
		int salto = 0;

		// Costo O(n^2)
		multiplicacion(x, y, list, salto);

		// Costo O(n)
		int finalSum = sumaFinal(list);

		return finalSum;
	}

	private static int sumaFinal(List<Integer> list) {
		int finalSum = 0;
		for (Integer integer : list) {
			finalSum += integer;
		}
		return finalSum;
	}

	private static void multiplicacion(String x, String y, List<Integer> list, int salto) {
		for (int i = x.length() - 1; i >= 0; i--) {
			int sum = 0;
			int div = 0;
			int resto = 0;
			for (int j = y.length() - 1; j >= 0; j--) {
				int digitoX = Character.getNumericValue(x.charAt(j));
				int digitoY = Character.getNumericValue(y.charAt(i));

				int partialSum = digitoX * digitoY + resto;

				if (partialSum > 9) {
					if (j != 0) {
						resto = partialSum / 10;
						partialSum = partialSum % 10;
					}
				}
				sum = sum + (partialSum * (int) (Math.pow(10, div++)));
			}
			sum *= (int) (Math.pow(10, salto));
			salto++;
			list.add(sum);
		}

	}

	public static int karatsubaMultiplication(int x, int y) {
		if (x < 10 || y < 10)
			return x * y;

		int n = Integer.toString(x).length();

		int split = (int) Math.ceil(n / 2.0);

		int b = x % (int) Math.pow(10, split);

		int a = (x - b) / (int) Math.pow(10, split);

		int d = y % (int) Math.pow(10, split);

		int c = (y - d) / (int) Math.pow(10, split);

		int s1 = karatsubaMultiplication(a, c);

		int s2 = karatsubaMultiplication(b, d);

		int s3 = karatsubaMultiplication(a + b, c + d);

		int s4 = s3 - s2 - s1;
		if (n % 2 == 0)
			return (int) Math.pow(10, n) * s1 + (s4 * (int) Math.pow(10, split)) + s2;

		return (int) Math.pow(10, (n + 1)) * s1 + (s4 * (int) Math.pow(10, split)) + s2;
	}

}
