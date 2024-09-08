package EJERCICIO1;

import java.io.File;

public class Archivo {

	private String ruta;

	//Constructores
	public Archivo() {
		
	}
	
	public Archivo(String ruta) {		
		this.ruta = ruta;
	} 
	
	//Setters	
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	//METODO QUE CHEQUEA QUE EXISTA EL FILE
		public boolean Existe() {
			
			File archivo = new File(ruta);
			if(archivo.exists()) 
			{
				return true;
			}
			return false;
		}
	
	
	
}
