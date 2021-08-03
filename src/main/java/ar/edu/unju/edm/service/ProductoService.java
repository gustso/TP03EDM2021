package ar.edu.unju.edm.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;

@Service
public interface ProductoService {
	//qué hace con Producto
	
	public void guardarProducto(Producto unProducto);
	public void comprarProducto(Producto unProducto) throws Exception;
	public void modificarProducto(Producto productoAModificar);
	public void eliminarProducto(Producto productoAEliminar);
	public Producto obtenerUnProducto(Integer idProducto) throws Exception;
	public ArrayList<Producto> obtenerTodosProductos();
	public Producto obtenerProductoNuevo();
	public Producto obtenerUltimoProducto();
}
