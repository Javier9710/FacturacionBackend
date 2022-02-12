package gnosoft.springboot.app.mediator;

import java.util.List;

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
	public Articulo save(Articulo articulo) {
		return articuloDao.save(articulo);
	}

	@Override
	public Articulo findById(Long id) {
		return articuloDao.findById(id);
		
	}

	@Override
	public List<Articulo> listAll() {
		// TODO Auto-generated method stub
		List<Articulo> listAll = (List<Articulo>) articuloDao.listAll();
		return listAll;
	}

	@Override
	public Articulo update(Articulo articulo) {
		return articuloDao.update(articulo);
	}

}
