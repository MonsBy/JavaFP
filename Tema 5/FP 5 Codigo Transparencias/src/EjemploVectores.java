import java.util.Scanner;

public class EjemploVectores {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Cantidad de notas: ");
        int cantidad = teclado.nextInt();
        double[] notas = new double[cantidad];
        leerNotas(notas, teclado);
        double media = calcularMedia(notas);
        System.out.printf("La nota media es %.2f\n", media);
    }

    public static void leerNotas(double[] notas, Scanner teclado) {
         for (int i = 0; i < notas.length; i++) {
             System.out.print("Nota " + (i + 1) + ": ");
             notas[i] = teclado.nextDouble();
         }
    }

    public static double calcularMedia(double[] notas) {
        double suma = 0.0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        return suma / notas.length;
    }
}
