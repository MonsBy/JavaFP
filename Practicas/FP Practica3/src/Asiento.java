public class Asiento {
    private int fila;
    private int butaca;
    private Pasajero pasajero;

    public Asiento(int fila, int butaca, Pasajero pasajero) {
        // código
        this.fila = fila;
        this.butaca = butaca;
        this.pasajero = pasajero;
    }

    public int getFila() {
        // código
        return fila;
    }

    public int getButaca() {
        // código
        return butaca;
    }

    public Pasajero getPasajero() {
        // código
        return pasajero;
    }

    public String toString() {
        // código
        /* Convierto el numero de butaca a una letra, donde
         0 = A
         1 = B
         2 = C
         3 = D
         */
        char letraButaca = (char) ('A'+butaca);
        return fila + String.valueOf(letraButaca);

    }
}
