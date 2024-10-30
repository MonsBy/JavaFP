public class PruebaListaNaturales {
    public static void main(String[] args) {
        // Creacion de la lista -----------------------------------------------
        ListaNaturales lista = new ListaNaturales(20);
        System.out.print("Lista inicial: ");
        lista.mostrar();
        // Anadir elementos al final de la lista --------------------------------
        lista.anadir(2);
        lista.anadir(3);
        lista.anadir(4);
        lista.anadir(7);
        lista.anadir(10);
        System.out.print("Tras añadir 5 elementos: ");
        lista.mostrar();

        // Insertar un elemento -------------------------------------------------
        lista.insertar(8, 3);
        System.out.print("Tras insertar el elemento 8 en la posicion 3: ");
        lista.mostrar();

        // Eliminar un elemento -----------------------------------------------------
        lista.eliminar(3);
        System.out.print("Tras eliminar el elemento de la posicion 3: ");
        lista.mostrar();

        // Buscar un elemento --------------------------------------------------------
        boolean encontrado = lista.contiene(10);
        System.out.println("El elemento 10 está en la lista: " + encontrado);
    }
}
