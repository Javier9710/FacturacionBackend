package gnosoft.springboot.app.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gnosoft.springboot.app.facade.IFacturaService;
import gnosoft.springboot.app.vos.Factura;
import gnosoft.springboot.app.vos.FacturaDto;

@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = {"http://localhost:8080"})
public class FacturaController {
	
	@Autowired
	private IFacturaService facturaService;

	
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ResponseEntity<Factura> save(@RequestBody FacturaDto facturaData){
		
		Factura facturaSet = facturaService.setFactura(facturaData);
		
		Factura facturaResp = facturaService.save(facturaSet,facturaData);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaResp);
		
	}

}
