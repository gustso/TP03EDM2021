package ar.edu.unju.edm.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.model.Venta;
import ar.edu.unju.edm.service.IClienteService;
import ar.edu.unju.edm.service.ProductoService;

@Controller
public class ProductoController {
	private static final Log GUSTAVO = LogFactory.getLog(ProductoController.class);
	
	@Autowired
	@Qualifier("impprodmongo")
	ProductoService iProductoService;
	
	@Autowired
	@Qualifier("otroImp")
	IClienteService clienteService;
	
	@GetMapping("/producto/mostrar")
	public String cargarProducto(Model model) {
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return("producto");
	}
	
	@PostMapping("/producto/guardar")
	public String guardarNuevoProducto(@ModelAttribute("unProducto") Producto nuevoProducto, Model model) {
	//public String guardarNuevoProducto(@RequestParam("file") MultipartFile file, @ModelAttribute("unProducto") Producto nuevoProducto, Model model) throws IOException {
		//byte[] content = file.getBytes();
		//String base64 = Base64.getEncoder().encodeToString(content);
		//nuevoProducto.setImagen(base64);
		//nuevoProducto.setCodProducto(3);
		GUSTAVO.error("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		iProductoService.guardarProducto(nuevoProducto);
		//mostrar el listado de producto luego de la carga de un producto		
		GUSTAVO.error("solo de prueba");
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return "redirect:/producto/mostrar";
	}
	
	@GetMapping("/ultimo")
	public String cargarUltimoProducto(Model model) {
		model.addAttribute("ultimoProducto", iProductoService.obtenerUltimoProducto());
		return("mostrar-ultimo");
	}
	
	@GetMapping("/volver")
	public String cargarNuevoProducto(Model model) {
		//model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		return("redirect:/producto");
	}
	
	@GetMapping("/producto/vender")
	public String cargarProductoVender(Model model) {		
		GUSTAVO.error("solo de prueba: xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return("venta");
	}
	
	@GetMapping("/producto/vender/{id}")	
	public String editarProductoVender(Model model, @PathVariable(name="id") String id) throws Exception {
		
		Producto productoSeleccionado = new Producto();		
		try {		
			productoSeleccionado = iProductoService.obtenerUnProducto(id);		
			model.addAttribute("productoSeleccionado",productoSeleccionado);
			model.addAttribute("clientes",clienteService.obtenerTodosClientes());
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());		
		}		
		return "venta-modal";
	}
	
	@PostMapping("/producto/confirmarVender")
	public String confirmarProductoVender(@ModelAttribute("productoSeleccionado") Producto prodComprado, Model model) throws Exception {		
		GUSTAVO.error("solo de prueba: bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		iProductoService.comprarProducto(prodComprado);
		GUSTAVO.error("solo de prueba: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		clienteService.guardarCompra(prodComprado);		
		return("redirect:/producto/vender");
	}
}
