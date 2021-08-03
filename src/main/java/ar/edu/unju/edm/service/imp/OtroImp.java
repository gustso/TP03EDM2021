package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.repository.ClienteRepository;
import ar.edu.unju.edm.repository.IClienteRepository;
import ar.edu.unju.edm.service.IClienteService;

@Service
@Qualifier("otroImp")
public class OtroImp implements IClienteService{
	
	@Autowired
	Cliente cliente;
	
	@Autowired
	private ClienteRepository clienteRepo;
	//IClienteRepository clienteRepo;
	

	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		//puedo implementar guardar en una BD y no en un listado			
		clienteRepo.save(unCliente);
	}

	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return cliente;
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		// TODO Auto-generated method stub
		return clienteRepo.findAll();
	}

	@Override
	public void guardarCompra(Producto productoComprado) throws Exception {
		// TODO Auto-generated method stub	
		Cliente clienteAModificar = clienteRepo.findById(productoComprado.getCliente().getNroDocumento()).orElseThrow(()->new Exception("El Cliente no fue encontrado"));
		//if (productoComprado.getCliente().getProductosComprados() == null) {
		//	productoComprado.getCliente().getProductosComprados() new ArrayList<Producto>();
		//}
		clienteAModificar.getProductosComprados().add(productoComprado);
		clienteRepo.save(clienteAModificar);
		//System.out.println("a ver si guardaaaaaaa: " + clienteRepo.findById(clienteAModificar.getNroDocumento()).get().getProductosComprados().get(0).getNombreProducto());
	}
	
	

}
