package EJERCICIO1;

import java.io.IOException;

public class DniInvalido extends IOException{

	
	//Constructor
		public DniInvalido() {
	        
	    }

			@Override
			public String getMessage() {
				return "EL DNI es ivalido, Debe contener SOLO numeros";
			}
		
}
