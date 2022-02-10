package gnosoft.springboot.app.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gnosoft.springboot.app.dao.ArticuloDao;
import gnosoft.springboot.app.facade.IArticuloService;
import gnosoft.springboot.app.vos.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService{
	
	@Autowired
	private ArticuloDao articuloDao;

	@Override
	public Articulo saveArticulo(Articulo articulo) {
		return articuloDao.saveArticulo(articulo);
	}

	@Override
	public Articulo findArticuloId(Long id) {
		return articuloDao.findById(id);
		
	}

}
