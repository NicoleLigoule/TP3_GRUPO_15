package EJERCICIO1;

import java.io.IOException;

public class DniInvalido extends IOException{

	
	//Constructor
	public DniInvalido(String message) {
        super(message);
    }

		@Override
		public String getMessage() {
			return super.getMessage();
		}
		
		public static void verificarDniInvalido(String dni) throws DniInvalido {
	        
		}
		
}
