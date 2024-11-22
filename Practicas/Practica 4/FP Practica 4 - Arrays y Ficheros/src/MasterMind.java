import java.io.*;
import java.util.Random;

public class MasterMind {
    private Tablero tablero;
    private Jugada jugadaOculta;
    private int numFichas;

    // Constructor para una partida nueva
    public MasterMind(int numFichas) {
        this.numFichas = numFichas;
        this.jugadaOculta = generarJugadaOculta(numFichas);
        this.tablero = new Tablero();
    }

    // Constructor para cargar una partida desde un archivo
    public MasterMind(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            // Leer la jugada oculta
            String jugadaOcultaStr = br.readLine().trim();
            this.jugadaOculta = new Jugada(jugadaOcultaStr);
            this.numFichas = jugadaOcultaStr.length();
            this.tablero = new Tablero();

            // Leer jugadas y pistas del archivo
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                String jugada = partes[0];
                int aciertos = Integer.parseInt(partes[1]);
                int descolocados = Integer.parseInt(partes[2]);

                Jugada j = new Jugada(jugada);
                Pistas p = new Pistas(aciertos, descolocados);
                tablero.insertar(j, p);
            }
        } catch (IOException e) {
            System.out.println("ERROR AL RECUPERAR LA PARTIDA");
        }
    }

    // Generar una jugada oculta aleatoria
    private Jugada generarJugadaOculta(int numFichas) {
        char[] colores = {'R', 'V', 'A', 'P'};
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numFichas; i++) {
            sb.append(colores[random.nextInt(colores.length)]);
        }
        return new Jugada(sb.toString());
    }

    // Guardar el estado de la partida en un archivo
    private void guardarPartida(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Guardar jugada oculta
            bw.write(jugadaOculta.toString());
            bw.newLine();

            // Guardar jugadas y pistas
            Jugada[] jugadas = tablero.getJugadas();
            Pistas[] pistas = tablero.getResultados();
            int numJugadas = tablero.getNumJugadas();

            for (int i = 0; i < numJugadas; i++) {
                bw.write(jugadas[i].toString() + " " + pistas[i].getAciertos() + " " + pistas[i].getDescolocados());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR AL GUARDAR LA PARTIDA");
        }
    }

    // Lógica principal del juego
    public void jugar() {
        while (true) {
            System.out.print("Introduce jugada o G (guardar la partida): ");
            String entrada = Teclado.leerJugadaGuardar();

            if (entrada.equalsIgnoreCase("G")) {
                String nombreArchivo = Teclado.leerString("Nombre del archivo: ");
                guardarPartida(nombreArchivo);
                System.out.println("Partida guardada. Fin del juego.");
                break;
            } else {
                Jugada jugada = new Jugada(entrada);
                Pistas pistas = jugada.comprobar(jugadaOculta);

                tablero.insertar(jugada, pistas);
                tablero.visualizar();

                if (pistas.getAciertos() == numFichas) {
                    System.out.println("ACERTASTE LA JUGADA");
                    break;
                } else if (tablero.completo()) {
                    System.out.println("FIN DE LOS INTENTOS, NO CONSEGUISTE ACERTAR");
                    System.out.println("La jugada oculta era: " + jugadaOculta);
                    break;
                }
            }
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    // Método main
    public static void main(String[] args) {
        MasterMind masterMind;
        if (Teclado.leerSiNo("¿Quieres recuperar una partida? (S/N): ") == 'S') {
            String nombreArchivo = Teclado.leerString("Nombre del archivo: ");
            masterMind = new MasterMind(nombreArchivo);
            masterMind.getTablero().visualizar();
        } else {
            int fichas = Teclado.leerEntero(4, 6, "Número de fichas de las jugadas (4 - 6): ");
            masterMind = new MasterMind(fichas);
        }
        masterMind.jugar();
    }
}

