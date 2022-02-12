package gnosoft.springboot.app.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gnosoft.springboot.app.facade.IClienteService;
import gnosoft.springboot.app.vos.Cliente;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:8080/")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		clienteService.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
		
	}
	
	@RequestMapping(value = "/{cedula}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable String cedula){

		Cliente clienteDB = clienteService.findById(cedula);
		return ResponseEntity.status(HttpStatus.OK).body(clienteDB);
		
		
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listAll(){
		List<Cliente> clientesDB = clienteService.listAll();
		return ResponseEntity.status(HttpStatus.OK).body(clientesDB);
		
	}
	
	@RequestMapping(value = "/up", method = RequestMethod.PUT)
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
		
		Cliente clienteNew= clienteService.update(cliente);
		
		return ResponseEntity.status(HttpStatus.OK).body(clienteNew);
		
	}

}
