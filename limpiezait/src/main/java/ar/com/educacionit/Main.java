package ar.com.educacionit;

import ar.com.educacionit.model.Usuario;
import ar.com.educacionit.service.UserService;

public class Main {
	
	public static void main(String[] args) {
	Usuario usuario = new UserService().fetchRandomUser();	
	
	System.out.println("Nombre: " + usuario.getNombre());
	System.out.println("Apellido: " + usuario.getApellido());
	System.out.println("Email: " + usuario.getEmail());
		
	}

}
