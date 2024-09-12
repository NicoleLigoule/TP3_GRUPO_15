package EJERCICIO1;

import java.util.TreeSet;



public class Principal {

	public static void main(String[] args) {
		///Inicializacion del Archivo persona, no queda muy enclaro si lo iban a agregar al probar el 
		/// proyecto asi q preestablecimos por las dudas el archivo ya q presta aconfucion :)
		Archivo arch = new Archivo("Personas.txt");
		arch.cargarPersonasIniciales();
		///punto B
		TreeSet<Persona> persona = new TreeSet<>();

    	persona=arch.leerPersonasGuardada();
        for (Persona persone : persona) {
            System.out.println(persone);
        }
        

	}

}
