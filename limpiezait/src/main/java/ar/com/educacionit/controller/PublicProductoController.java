package ar.com.educacionit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.educacionit.dto.ProductoDTO;
import ar.com.educacionit.model.Producto;
import ar.com.educacionit.service.ProductoService;

@RestController
@RequestMapping("/public/productos")
public class PublicProductoController {
	private ProductoService productoService = ProductoService.getInstancia();

	@GetMapping
	public List<Producto> getAllProductos() {
		return productoService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> getProductoById(@PathVariable Long id) {

		ProductoDTO producto = productoService.findById(id);
		return ResponseEntity.ok(producto);
	}

}
