package gnosoft.springboot.app.facade;

import gnosoft.springboot.app.vos.Articulo;

public interface IArticuloService {
	
	public Articulo save(Articulo articulo);
	
	
	
	public Articulo findById(Long id);

}
