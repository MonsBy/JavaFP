public class ListaNaturales {

	private final int CAPACIDAD;
	private int[] elementos;
	private int ocupacion;

	public ListaNaturales(int capacidad){
		CAPACIDAD = capacidad;
		elementos = new int[CAPACIDAD];
		ocupacion = 0;
	}

	public void anadir(int elemento) {
		if (ocupacion < CAPACIDAD) {
			elementos[ocupacion] = elemento;
			ocupacion++;
		}
	}

	public void mostrar() {
		System.out.print("[ ");
		for (int i = 0; i < ocupacion; i++) {
			System.out.print(elementos[i] + " ");
		}
		System.out.println("]");
	}

	public void insertar(int elemento, int posicion) {
		if (posicion < ocupacion && ocupacion < CAPACIDAD) {
			for (int i = ocupacion - 1; i >= posicion; i--) {
				elementos[i + 1] = elementos[i];
			}
			elementos[posicion] = elemento;
			ocupacion++;
		}
	}

	public void eliminar(int posicion) {
		if (posicion < ocupacion) {
			for (int i = posicion + 1; i < ocupacion; i++) {
				elementos[i - 1] = elementos[i];
			}
			ocupacion--;
		}
	}

	public boolean contiene(int elemento) {
		int i = 0;
		while (i < ocupacion && elementos[i] != elemento) {
			i++;
		}
		return i < ocupacion;
	}

}
