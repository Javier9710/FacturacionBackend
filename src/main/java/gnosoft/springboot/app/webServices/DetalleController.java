package gnosoft.springboot.app.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gnosoft.springboot.app.dao.DetalleDao;
import gnosoft.springboot.app.vos.DetalleFactura;

@RestController
@RequestMapping("/detalle")
@CrossOrigin(origins = "http://localhost:8080/")
public class DetalleController {
	
	@Autowired
	private DetalleDao detalleDao;
	
	/*
	@RequestMapping(value ="/save", method = RequestMethod.POST )
	public ResponseEntity<DetalleFactura> save(@RequestBody DetalleFactura detalle){
		detalleDao.save(detalle);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(detalle);
		
	}*/
	
	@RequestMapping(value = "/factura/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<DetalleFactura>> listDetalleFactura(@PathVariable Long id){
		
		List<DetalleFactura> detallesDB = detalleDao.listDetallesFactura(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(detallesDB);
		
	}

}
