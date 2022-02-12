package gnosoft.springboot.app.facade;

import java.util.List;

import gnosoft.springboot.app.vos.Articulo;

public interface IArticuloService {
	
	public Articulo save(Articulo articulo);
	
	
	
	public Articulo findById(Long id);
	
	
	public List<Articulo> listAll();
	
	public Articulo update(Articulo articulo);

}
