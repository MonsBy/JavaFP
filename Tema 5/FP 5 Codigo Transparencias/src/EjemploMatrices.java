import java.util.Scanner;

public class EjemploMatrices {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dimension de la matriz: ");
		final int N = teclado.nextInt();
		int[][] identidad = new int[N][N];
		crearIdentidad(identidad);
		escribirMatriz(identidad);
	}

	public static void crearIdentidad(int[][] matriz) {
		final int N = matriz.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					matriz[i][j] = 1;
				} else {
					matriz[i][j] = 0;
				}
			}
		}
	}

	public static void escribirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(" " + matriz[i][j]);
			}
			System.out.println();
		}
	}
}
