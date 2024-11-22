public class Tablero {
    private final static int MAX_JUGADAS = 10;

    private Jugada[] jugadas;
    private Pistas[] pistas;
    private int numJugadas;

    public Tablero() {
    this.jugadas = new Jugada[MAX_JUGADAS];
    this.pistas = new Pistas[MAX_JUGADAS];
    this.numJugadas = 0;
    }

    public int getNumJugadas() {
    return numJugadas;
    }

    public Jugada[] getJugadas() {
    return jugadas;
    }

    public Pistas[] getResultados() {
    return pistas;
    }

    public void insertar(Jugada jugada, Pistas pista) {
    if(numJugadas < MAX_JUGADAS) {
        jugadas[numJugadas] = jugada;
        pistas[numJugadas] = pista;
        numJugadas++;
    } else {
        throw new IllegalStateException("El tablero ya esta completo. No se puede meter mas");
    }
    }

    public boolean completo() {
    return numJugadas >= MAX_JUGADAS;
    }

    public void visualizar() {
        System.out.println("Estado del tablero");
        for (int i = 0; i < numJugadas; i++) {
            System.out.print("Jugada "+(i+1)+": ");
            jugadas[i].visualizar();
            System.out.println(" -> ");
            pistas[i].visualizar();
            System.out.println();
        }
        if(numJugadas == 0) {
            System.out.println("No hay jugadas");
        }
    }


}
