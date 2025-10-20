package ar.com.educacionit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.educacionit.model.Producto;
import ar.com.educacionit.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	private ProductoService productoService = ProductoService.getInstancia();

	@GetMapping
	public List<Producto> getAllProductos() {
		return productoService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		return ResponseEntity.ok(producto);
	}
	
	@PostMapping
	public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
		productoService.save(producto);
		return ResponseEntity.ok(producto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
		if (productoService.findById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		productoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
