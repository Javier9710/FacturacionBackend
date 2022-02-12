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
		// TODO Auto-generated method stub
		return detalleDao.save(detalle);
	}

}
