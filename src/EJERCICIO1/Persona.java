package EJERCICIO1;

public class Persona {
	
	private String Nombre; 
	private String Apellido; 
    private String  Dni ;
    


	///geters seters
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	
	public String toString() {
		return "Nombre: " + Nombre + ", Apellido: " + Apellido + ", Dni: " + Dni ;
	}
	public String DatosPersona() {
		return  Nombre + "," + Apellido + "," + Dni ;
	}
}
