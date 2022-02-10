package gnosoft.springboot.app.facade;

import gnosoft.springboot.app.vos.Articulo;

public interface IArticuloService {
	
	public Articulo saveArticulo(Articulo articulo);
	
	
	
	public Articulo findArticuloId(Long id);

}
