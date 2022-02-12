package gnosoft.springboot.app.mediator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gnosoft.springboot.app.dao.ClienteDao;
import gnosoft.springboot.app.facade.IClienteService;
import gnosoft.springboot.app.vos.Cliente;

@Service
public class ClienteServiceIml implements IClienteService  {
	
	@Autowired
	private ClienteDao clienteDao;

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}

	@Override
	public Cliente findById(String cedula) {
		// TODO Auto-generated method stub
		return clienteDao.findById(cedula);
	}

	@Override
	public List<Cliente> listAll() {
		return clienteDao.listAll();
	}

	@Override
	public Cliente update(Cliente cliente) {
		return clienteDao.update(cliente);
	}

}
