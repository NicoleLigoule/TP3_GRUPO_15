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
		return  Nombre + "-" + Apellido + "-" + Dni ;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Dni == null) ? 0 : Dni.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (Apellido == null) {
			if (other.Apellido != null)
				return false;
		} else if (!Apellido.equals(other.Apellido))
			return false;
		if (Dni == null) {
			if (other.Dni != null)
				return false;
		} else if (!Dni.equals(other.Dni))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
	
	
	public String GuardarDatos() {
		return  Nombre + "," + Apellido + "," + Dni ;
	}


}
