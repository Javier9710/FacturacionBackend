package gnosoft.springboot.app.facade;

import gnosoft.springboot.app.vos.Cliente;

public interface IClienteService {
	
	public Cliente save(Cliente cliente);
	
	public Cliente findById(String cedula);

}
