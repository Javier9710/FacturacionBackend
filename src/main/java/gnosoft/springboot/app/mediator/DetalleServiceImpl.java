package gnosoft.springboot.app.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gnosoft.springboot.app.dao.DetalleDao;
import gnosoft.springboot.app.facade.IDetalleService;
import gnosoft.springboot.app.vos.DetalleFactura;

@Service
public class DetalleServiceImpl implements IDetalleService {

	@Autowired
	private DetalleDao detalleDao;
	
	@Override
	public DetalleFactura save(DetalleFactura detalle) {
		return detalleDao.save(detalle);
	}

	@Override
	public void Delete(Long id) {
		detalleDao.delete(id);
		
	}

}
