import java.util.Random;

enum Color {
    ROJO, VERDE, AMARILLO, PURPURA
}


public class Jugada {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final char CUADRADO = '\u25A0';

    private Color[] fichas;

    public Jugada(String cadena) {
    fichas = new Color[cadena.length()];
    for(int i = 0; i < cadena.length(); i++) {
        switch(cadena.charAt(i)) {
            case 'R':
                fichas[i] = Color.ROJO;
                break;
            case 'V':
                fichas[i] = Color.VERDE;
                break;
            case 'A':
                fichas[i] = Color.AMARILLO;
                break;
            case 'P':
                fichas[i] = Color.PURPURA;
                break;
            default:
                throw new IllegalArgumentException("Color no valido: "+ cadena.charAt(i));
        }
    }

    }

    public Jugada(int numFichas) {
    Random random = new Random();
    Color[] colores = Color.values();
    fichas = new Color[numFichas];
    for (int i = 0 ; i < numFichas; i++) {
        fichas[i] = colores[random.nextInt(colores.length)];
    }
    }

    public Pistas comprobar(Jugada oculta) {
    int exactas = 0;
    int descolocadas  = 0;

    boolean[] marcadosActual = new boolean[fichas.length];
    boolean[] marcadosOculta = new boolean[oculta.fichas.length];

    // Calculo las fichas colocadas excatas
    for (int i = 0; i < fichas.length; i++){
        if (fichas[i] == oculta.fichas[i]) {
            exactas++;
            marcadosActual[i] = true; // Marco la ficha actual como utilizada
            marcadosOculta[i] = true; // Marco la ficha de la jugada oculta como utilizada
        }
    }

    //Calculo las fichas decolocadas
    for (int i = 0; i < fichas.length; i++) {
        if (!marcadosActual[i]) {
            for (int j = 0; j < oculta.fichas.length; j++) {
                if (!marcadosOculta[j] && fichas[i] == oculta.fichas[j]) {
                    descolocadas++;
                    marcadosActual[i] = true;
                    marcadosOculta[j] = true;
                }
            }
        }
    }

    return new Pistas(exactas, descolocadas);

    }

    public void visualizar() {
        for (int i = 0; i < fichas.length; i++) {
            switch (fichas[i]) {
                case ROJO:
                    System.out.print(ANSI_RED + CUADRADO + " ");
                    break;
                case VERDE:
                    System.out.print(ANSI_GREEN + CUADRADO + " ");
                    break;
                case AMARILLO:
                    System.out.print(ANSI_YELLOW + CUADRADO + " ");
                    break;
                case PURPURA:
                    System.out.print(ANSI_PURPLE + CUADRADO + " ");
                    break;
            }
        }
        System.out.print(ANSI_BLACK);
    }

    public String toString() {
        String resultado = "";
        for (int i = 0; i < fichas.length; i++) {
            switch (fichas[i]) {
                case ROJO:
                    resultado += "R";
                    break;
                case VERDE:
                    resultado += "V";
                    break;
                case AMARILLO:
                    resultado += "A";
                    break;
                case PURPURA:
                    resultado += "P";
                    break;
            }
        }
        return resultado;
    }

}
