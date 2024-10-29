public class Vuelo {
    private String paisOrigen;
    private String paisDestino;
    private String fecha;
    private Avion avion;

    public Vuelo(String paisOrigen, String paisDestino, String fecha, Avion avion) {
        // código
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.fecha = fecha;
        this.avion = avion;


    }

    public String getPaisOrigen() {
        // codigo
        return paisOrigen;
    }

    public String getPaisDestino() {
        // código

        return paisDestino;
    }

    public String getFecha() {
        // código
        return fecha;
    }

    public Avion getAvion() {
        // código
        return avion;
    }
}
