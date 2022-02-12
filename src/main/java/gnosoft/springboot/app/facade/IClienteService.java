package gnosoft.springboot.app.facade;

import java.util.List;

import gnosoft.springboot.app.vos.Cliente;

public interface IClienteService {
	
	public Cliente save(Cliente cliente);
	
	public Cliente findById(String cedula);
	
	public List<Cliente> listAll();
	
	public Cliente update(Cliente cliente);

}
