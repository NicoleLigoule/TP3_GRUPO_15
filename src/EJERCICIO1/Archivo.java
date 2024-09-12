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

	private static String ruta;

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
			
			///Metodo inicializacion de archivo persona
		    public static void cargarPersonasIniciales() {
		        File archivo = new File(ruta);

		        if (!archivo.exists()) {
		            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

		                Persona[] personas = new Persona[27];

		                personas[0] = new Persona("Pablo", "Ramirez", "11111112");
		                personas[1] = new Persona("Alejandro", "Flores", "11111126");
		                personas[2] = new Persona("Maria", "Rodriguez", "11111121");
		                personas[3] = new Persona("Alejandro", "Flores", "11111126");
		                personas[4] = new Persona("Daniel", "Torres", "11111115");
		                personas[5] = new Persona("Diego", "Alvarez", "11111119");
		                personas[6] = new Persona("Pablo", "Ramirez", "11111112");
		                personas[7] = new Persona("Maria", "Ornelas", "245sffga");
		                personas[8] = new Persona("Daniela", "Sanchez", "11111122");
		                personas[9] = new Persona("Alejandro", "Herrera", "11111129");
		                personas[10] = new Persona("Alvaro", "Ruiz", "11111113");
		                personas[11] = new Persona("Sofia", "Sosa", "11111123");
		                personas[12] = new Persona("Pablo", "Ramirez", "11111112");
		                personas[13] = new Persona("Cristian", "Gorosito", "yiqeytu");
		                personas[14] = new Persona("Lucia", "Romero", "11111120");
		                personas[15] = new Persona("Carla", "Martinez", "11111125");
		                personas[16] = new Persona("Pablo", "Ramirez", "11111112");
		                personas[17] = new Persona("Carla", "Martinez", "11111125");
		                personas[18] = new Persona("David", "Garcia", "11111114");
		                personas[19] = new Persona("Alba", "Gonzalez", "11111128");
		                personas[20] = new Persona("Hugo", "Perez", "11111116");
		                personas[21] = new Persona("Pablo", "Ramirez", "11111112");
		                personas[22] = new Persona("Alba", "Gonzalez", "11111128");
		                personas[23] = new Persona("Lucia", "Romero", "11111120");
		                personas[24] = new Persona("Maria", "Rodriguez", "11111121");
		                personas[25] = new Persona("Sofia", "Sosa", "11111123");
		                personas[26] = new Persona("Adrian", "Lopez", "11111117");


		                for (Persona persona : personas) {
		                    bw.write(persona.GuardarDatos());
		                    bw.newLine();
		                }

		                System.out.println("Archivo creado y personas iniciales cargadas.");

		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        } else {
		            System.out.println("El archivo ya existe. No se sobrescribió.");
		        }
		    }
}
	

