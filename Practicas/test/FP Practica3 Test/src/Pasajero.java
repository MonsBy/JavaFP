public class Pasajero {
	private String nombre;
	private String pasaporte;
	private String telefono;
	private int edad;
	private Maleta maleta;

	public Pasajero(String nombre, String pasaporte, String telefono, int edad, Maleta maleta) {
		// código
		this.nombre = nombre;
		this.pasaporte = pasaporte;
		this.telefono = telefono;
		this.edad = edad;
		this.maleta = maleta;
	}
	
	public String getNombre() {
		// código
		return nombre;
	}
	
	public String getPasaporte() {
		// código
		return pasaporte;
	}
	
	public String getTelefono() {
		// código
		return telefono;
	}
	
	public int getEdad() {
		// código
		return edad;
	}

	public Maleta getMaleta() {
		// código
		return maleta;
	}
}
