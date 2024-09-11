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
	
	@Override
	public String toString() {
		return "Nombre: " + Nombre + ", Apellido: " + Apellido + ", Dni: " + Dni ;
	}
	public String DatosPersona() {
		return  Nombre + "," + Apellido + "," + Dni ;
	}
	
	public Persona() {

		Nombre = "sin nombre";
		Apellido =  "sin Apellido";
		Dni = "Sin Dni";
	}
    public Persona(String nombre, String apellido, String dni) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Dni = dni;
	}
	
}
