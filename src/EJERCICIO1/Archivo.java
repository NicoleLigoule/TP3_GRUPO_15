package EJERCICIO1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Comparator;



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
		//METODO QUE CREA EL ARCHIVO
		public boolean creaArchivo()
		{
			FileWriter escritura;
			try {
				escritura = new FileWriter(ruta, true);
				escritura.write("");
				escritura.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
				
		}
		//METODO QUE GUARDA EN UN ARCHIVO LOS DATOS DE UN TREESET DE OBJ PERSONAS
		public boolean GuardarPersonasEnArchivo(TreeSet<Persona> Personas) {
		    if (!Existe()) {
		        creaArchivo();
		    }
		    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
		        for (Persona person : Personas) {
		            try {
		                verificarDniInvalido(person.getDni());

		                bw.write(person.GuardarDatos());
		                bw.newLine();
		            } catch (DniInvalido e) {
		          
		                System.err.println("DNI inválido para la persona: " + person.getNombre() + " " + person.getApellido() + ". No se guardará.");
		            }
		        }
		        return true;
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
			return false;
		  
		}
		
	
	///metodo para leer clase personas guardadas 
		  public TreeSet<Persona> leerPersonasGuardada() {
		        
			  TreeSet<Persona> personas = new TreeSet<>(new Comparator<Persona>() {
			  @Override
	          public int compare(Persona p1, Persona p2) {
	            int apellidoComparison = p1.getApellido().compareTo(p2.getApellido());
	            if (apellidoComparison != 0) {
	                return apellidoComparison;
	            }
	            return p1.getNombre().compareTo(p2.getNombre());
	         }
	      });

	      try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
	           String linea;

	           while ((linea = br.readLine()) != null) {
	              String[] datos = linea.split("-");

	              String nombre = datos[0];
	              String apellido = datos[1];
	              String dni = datos[2];

	       try {	              
	                verificarDniInvalido(dni);

	                Persona persona = new Persona(nombre, apellido, dni);
	                personas.add(persona);

	            } catch (DniInvalido e) {

	                System.err.println(e.getMessage()+ "la persona: " + nombre + " " + apellido + ": " + dni+" NO se agregara a la lista ");
	            }
	         }
	       } catch (IOException e) {
	        e.printStackTrace();
	     }

	     return personas;
		         
	  }
		  
		  
			public static boolean verificarDniInvalido(String dni) throws DniInvalido {
			    boolean esNumerico = true; 
			    for (int i = 0; i < dni.length(); i++) {
			        char c = dni.charAt(i);

			        if (!Character.isDigit(c)) {
			        	DniInvalido ecxiondniInvalido = new DniInvalido();
			        	throw ecxiondniInvalido;
			           // esNumerico = false;
			            //break;
			        }
			    }
			    return esNumerico;

				
			}
	
}
