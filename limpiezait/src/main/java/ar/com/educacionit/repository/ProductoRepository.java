package ar.com.educacionit.repository;

import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.model.Producto;

public class ProductoRepository {
	
	private ArrayList<Producto> productos = new ArrayList<>();
	
	public List<Producto> findAll() {
		return productos;
	}
	
	public Producto findById(Long id) {
		for (Producto producto : productos) {
			if (producto.getId().equals(id)) {
				return producto;
			}
		}
		return null;
	}
	
	public void save(Producto producto) {
		productos.add(producto);
	}
	
	public void deleteById(Long id) {
		Producto producto = findById(id);
		if (producto != null) {
			productos.remove(producto);
		}
	}
	

}
