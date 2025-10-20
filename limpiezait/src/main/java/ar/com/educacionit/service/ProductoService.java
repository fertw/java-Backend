package ar.com.educacionit.service;

import java.util.List;

import ar.com.educacionit.model.Producto;
import ar.com.educacionit.repository.ProductoRepository;

public class ProductoService {
	
	private static ProductoService instancia = new ProductoService();
	private ProductoRepository productoRepository;
	
	private ProductoService() {
		this.productoRepository = new ProductoRepository();
	}
	
	public static ProductoService getInstancia() {
		return instancia;
	}	
	
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}
	
	public Producto findById(Long id) {
		return productoRepository.findById(id);
	}
	
	public void save(Producto producto) {
		productoRepository.save(producto);
	}
	
	public void deleteById(Long id) {	
		productoRepository.deleteById(id);
	}

}
