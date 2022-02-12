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

import gnosoft.springboot.app.facade.IArticuloService;
import gnosoft.springboot.app.vos.Articulo;

@RestController
@RequestMapping("/articulo")
@CrossOrigin(origins = {"http://localhost:8080"})
public class ArticuloController {
	
	@Autowired
	private IArticuloService articuloService;
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public ResponseEntity<Articulo> saveArticulo(@RequestBody Articulo articulo){
		articuloService.save(articulo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(articulo);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Articulo> findArticuloId(@PathVariable Long id){
		
		Articulo articuloDB = articuloService.findById(id);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(articuloDB);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<Articulo>> listAll(){
		
		List<Articulo> articulosDB = articuloService.listAll();
		
		
		return ResponseEntity.status(HttpStatus.OK).body(articulosDB);
	}
	
	@RequestMapping(value = "/up", method = RequestMethod.PUT)
	public ResponseEntity<Articulo> update(@RequestBody Articulo articulo){

		Articulo ArticuloUpdate = articuloService.update(articulo);
		
		return ResponseEntity.status(HttpStatus.OK).body(ArticuloUpdate);
		
	}

}
