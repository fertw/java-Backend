package ar.com.educacionit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI SwaggerConfig() {
		// Configuraciones de Swagger pueden ir aquí
		return new OpenAPI()
				.info(new io.swagger.v3.oas.models.info.Info()
						.title("Limpieza IT API")
						.version("1.0")
						.description("API para la gestión de servicios de limpieza"));
	}

}
