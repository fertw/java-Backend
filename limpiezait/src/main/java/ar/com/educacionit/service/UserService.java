package ar.com.educacionit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ar.com.educacionit.model.Usuario;

@Service
public class UserService {
	
	public Usuario fetchRandomUser() {
		String url = "https://randomuser.me/api/";
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(url, String.class);

		// Procesar la respuesta con Gson
		JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
		JsonObject userObject = jsonObject.getAsJsonArray("results").get(0).getAsJsonObject();
		JsonObject nameObject = userObject.getAsJsonObject("name");
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nameObject.get("first").getAsString());
		usuario.setApellido(nameObject.get("last").getAsString());
		usuario.setEmail(userObject.get("email").getAsString());		
		return usuario;
		
	}

	


	

}
