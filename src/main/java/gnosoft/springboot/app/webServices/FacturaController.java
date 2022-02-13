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

import gnosoft.springboot.app.facade.IDetalleService;
import gnosoft.springboot.app.facade.IFacturaService;
import gnosoft.springboot.app.vos.Factura;
import gnosoft.springboot.app.vos.FacturaDto;

@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = {"http://localhost:8080/"})
public class FacturaController {
	
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired 
	private IDetalleService detalleService;
	
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ResponseEntity<Factura> save(@RequestBody FacturaDto facturaData){
		Factura facturaSet = facturaService.setFactura(facturaData);
		Factura facturaResp = facturaService.save(facturaSet,facturaData);
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaResp);
		
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<Factura>> listAll(){
		List<Factura> facturasDB = facturaService.listAll();
		return ResponseEntity.status(HttpStatus.OK).body(facturasDB);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id){
		detalleService.Delete(id);
		boolean res = facturaService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Factura> findById(@PathVariable Long id){
		Factura facturaDB = facturaService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(facturaDB);
	}

}
