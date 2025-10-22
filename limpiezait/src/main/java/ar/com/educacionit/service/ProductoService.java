package ar.com.educacionit.service;

import java.util.List;

import ar.com.educacionit.dto.ProductoDTO;
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
	
	public ProductoDTO findById(Long id) {
		Producto producto =  productoRepository.findById(id);
		if (producto == null) {
			return null;
		}
		ProductoDTO productoDTO = new ProductoDTO();
		productoDTO.setId(producto.getId());
		productoDTO.setNombre(producto.getNombre());
		productoDTO.setPrecio(producto.getPrecio());
		return productoDTO;
	}
	
	public void save(ProductoDTO producto) {
		Producto prod = new Producto();
		prod.setId(producto.getId());
		prod.setNombre(producto.getNombre());
		prod.setPrecio(producto.getPrecio());
		
		productoRepository.save(prod);
	}
	
	public void deleteById(Long id) {	
		productoRepository.deleteById(id);
	}

}
