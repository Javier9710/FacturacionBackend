package gnosoft.springboot.app.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gnosoft.springboot.app.dao.DetalleDao;
import gnosoft.springboot.app.vos.DetalleFactura;

@RestController
@RequestMapping("/detalle")
public class DetalleController {
	
	@Autowired
	private DetalleDao detalleDao;
	
	
	@RequestMapping(value ="/save", method = RequestMethod.POST )
	public ResponseEntity<DetalleFactura> save(@RequestBody DetalleFactura detalle){
		detalleDao.save(detalle);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(detalle);
		
	}

}
