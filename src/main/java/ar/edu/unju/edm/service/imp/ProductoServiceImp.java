package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.repository.IProductoRepository;
import ar.edu.unju.edm.service.ProductoService;

@Service
@Qualifier("impprodmongo")
public class ProductoServiceImp implements ProductoService{

	@Autowired
	Producto producto;
	
	@Autowired
	private IProductoRepository productoRepo;
	
	@Override
	public void guardarProducto(Producto unProducto) {
		// TODO Auto-generated method stub
		productoRepo.save(unProducto);
	}

	@Override
	public void modificarProducto(Producto productoModificado) {
		// TODO Auto-generated method stub
		//Producto productoAModificar = productoRepo.findById(productoModificado.getCodProducto()).orElseThrow(()->new Exception("El Producto no fue encontrado"));
		
	}

	@Override
	public void eliminarProducto(Producto productoAEliminar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto obtenerUnProducto(Integer idProducto) throws Exception {
		// TODO Auto-generated method stub
		return productoRepo.findById(idProducto).orElseThrow(()->new Exception("El producto NO existe"));
	}

	@Override
	public ArrayList<Producto> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return (ArrayList<Producto>) productoRepo.findAll();
	}

	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return producto;
	}

	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void comprarProducto(Producto productoModificado) throws Exception {
		// TODO Auto-generated method stub
		Producto productoAModificar = productoRepo.findById(productoModificado.getCodProducto()).orElseThrow(()->new Exception("El Producto no fue encontrado"));
		productoAModificar.setCliente(productoModificado.getCliente());
		productoRepo.save(productoAModificar);
		
	}

}
