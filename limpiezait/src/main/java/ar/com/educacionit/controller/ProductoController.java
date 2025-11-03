package ar.com.educacionit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.educacionit.dto.ProductoDTO;
import ar.com.educacionit.model.Producto;
import ar.com.educacionit.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	private ProductoService productoService = ProductoService.getInstancia();

	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@GetMapping
	@Tag(name="Productos")
	public List<Producto> getAllProductos() {
		return productoService.findAll();
	}

	@GetMapping("/{id}")
	@Tag(name="Productos")
	@Operation(summary = "Obtener producto por ID", description = "Devuelve un producto específico según su ID")
	@Parameter(name = "id", description = "ID del producto a obtener", required = true)
	public ResponseEntity<ProductoDTO> getProductoById(@PathVariable Long id) {
		ProductoDTO producto = productoService.findById(id);
		return ResponseEntity.ok(producto);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO producto) {
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
