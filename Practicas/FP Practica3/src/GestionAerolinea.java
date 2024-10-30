import java.util.Scanner;

public class GestionAerolinea {
    // Precio de un asiento de la clase turista
    private final int PRECIO_BILLETE_TURISTA = 350;
    // Precio de un asiento de la clase business
    private final int PRECIO_BILLETE_BUSINESS = 1500;
    // Se aplica un 15% de descuento a los menores de 15 años (<15)
    private final float DESCUENTO_INFANTIL = 15f;
    // Número de aviones de la aerolínea
    private final int NUM_AVIONES = 3;
    // Lista de aviones de la aerolínea
    private Avion[] aviones;
    private final int NUM_VUELOS = NUM_AVIONES;
    // Lista de vuelos
    private Vuelo[] vuelos;
    // Variable que indica si se han inicializado los datos de aviones y vuelos

    public static void main(String[] args) {
        // Creamos un objeto para ejecutar el programa
        GestionAerolinea obj = new GestionAerolinea();
    }

    public GestionAerolinea() {
        // Constructor de la clase que inicia el programa
        int opcion;
        do {
            opcion = menu();
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }

    public void ejecutarOpcion(int opcion) {
        // Ejecuta el código asociado a la opción
        switch (opcion) {
            case 1: // Inicializar aviones y vuelos
                // Código
                iniciarAvionesYVuelos();
                System.out.println("Aviones y vuelos inicializados");
                break;
            case 2: // Reservar asiento en un vuelo
                // Código
                Vuelo vuelo = preguntarVuelo();
                Clase clase = preguntarClase();
                reservarAsiento(vuelo.getAvion(), clase);
                break;
            case 3: // Mostrar el mapa de asientos
                // Código
                vuelo = preguntarVuelo();
                vuelo.getAvion().mostrarMapaDeAsientos();
                break;
            case 4: // Mostrar la lista de pasajeros
                // Código
                vuelo = preguntarVuelo();
                mostrarPasajeros(vuelo.getAvion());
                break;
            case 5: // Mostrar pasajeros menores de 15 años
                // Código
                vuelo = preguntarVuelo();
                int edad = leerNumero(0,100,"Ingrese la edad maxima");
                mostrarPasajeros(vuelo.getAvion(),edad);
                break;
            case 6: // Mostrar ingresos del vuelo
                // Código
                vuelo = preguntarVuelo();
                mostrarIngresos(vuelo.getAvion());
                break;
            default: // Finalizar
                System.out.println("Fin de la ejecución.");
        }
    }

    public void iniciarAvionesYVuelos() {
        // Se inicializan las listas de aviones y vuelos
        aviones = new Avion[NUM_AVIONES];
        aviones[0] = new Avion("Airbus A330", 40, 120);
        aviones[1] = new Avion("Airbus A310", 20, 100);
        aviones[2] = new Avion("Airbus A350", 48, 180);
        vuelos = new Vuelo[NUM_VUELOS];
        vuelos[0] = new Vuelo("Madrid", "La Habana", "01/12/2024", aviones[0]);
        vuelos[1] = new Vuelo("Madrid", "Cancún", "01/12/2024", aviones[1]);
        vuelos[2] = new Vuelo("Madrid", "Punta Cana", "01/12/2024", aviones[2]);
    }

    public int menu() {
        // Muestra el menú de opciones
        Scanner sc = new Scanner(System.in);
        int opcion;
        // Código
        System.out.println("Menu de gestion de aerolinea");
        System.out.println("1. Inicializar aviones y vuelos");
        System.out.println("2. Reservar asientos en un vuelo");
        System.out.println("3. Mostrar mapa de asientos");
        System.out.println("4. Mostrar lista de pasajeros");
        System.out.println("5. Mostrar pasajeros menos de cierta edad");
        System.out.println("6. Mostrar ingreso del vuelo");
        System.out.println("0. salir");
        System.out.print("Seleccione una opcion: ");
        opcion = sc.nextInt();
        return opcion;
    }

    public int leerNumero(int minimo, int maximo, String mensaje) {
        Scanner teclado = new Scanner(System.in);
        int numero;
        do {
            System.out.print(mensaje);
            numero = teclado.nextInt();
        } while (numero < minimo || numero > maximo);
        return numero;
    }

    public Vuelo preguntarVuelo() {
        int numero;
        numero = leerNumero(0, 2, "Elija el vuelo (0: La Habana, 1: Cancún, 2: Punta Cana) ");
        return vuelos[numero];
    }

    public Clase preguntarClase() {
        Clase clase;
        int numero = leerNumero(0, 1, "Elija la clase (0: Business, 1: Turista) ");
        clase = numero == 0 ? Clase.BUSINESS : Clase.TURISTA;
        return clase;
    }
    public void reservarAsiento(Avion avion, Clase clase) {
        // Código
        for (int i = 0; i < avion.getNumeroFilas(clase);i++){
            for (int j = 0; j <avion.getButacasPorFila(); j++){
                if (avion.getPasajero(i+1,j+1,clase)==null){
                    Pasajero pasajero = Azar.generaPasajero();
                    Asiento asiento = avion.reservarAsiento(i+1,j+1,clase,pasajero);
                    System.out.println("Reservado el asiento "+asiento + " de clase" + clase + " al pasajero "+ pasajero);
                    return;
                }
            }
        }
    }

    public void mostrarPasajeros(Avion avion) {
        // Código
        System.out.println("Avion "+avion.getModelo());
        System.out.println("Lista de pasajeros de la clase Business");

        for (int i = 0; i<avion.getNumeroFilas(Clase.BUSINESS);i++){
            System.out.println("Fila "+avion.getNumeroFilas(Clase.BUSINESS));
            for (int j = 0; j<avion.getButacasPorFila();j++){
                Pasajero pasajero = Azar.generaPasajero();
                System.out.printf("%-15s  %9s %2d años",pasajero.getNombre(),pasajero.getPasaporte(),pasajero.getEdad());
                System.out.println();
            }
        }


    }

    public void mostrarPasajeros(Avion avion, int edad) {
        // Código
    }

    public void mostrarIngresos(Avion avion) {
        // Código
        int ingresos;
        ingresos = 20;

        System.out.printf("El avion %10s proporciona ingresos de %6f ", avion.getModelo(),ingresos);

    }
}
