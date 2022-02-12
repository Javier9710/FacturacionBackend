package gnosoft.springboot.app.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gnosoft.springboot.app.dao.ClienteDao;
import gnosoft.springboot.app.dao.FacturaDao;
import gnosoft.springboot.app.facade.IFacturaService;
import gnosoft.springboot.app.vos.Cliente;
import gnosoft.springboot.app.vos.Factura;
import gnosoft.springboot.app.vos.FacturaDto;

@Service
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired 
	private FacturaDao facturaDao;
	
	@Autowired
	private ClienteDao clienteDao;

	@Override
	public Factura save(Factura facturaSet, FacturaDto facturaData) {
		
		Factura facturaResp = null;
	
		System.out.println("-------:" + facturaData.getCedula());
		
		
        Cliente cliente = clienteDao.findById(facturaData.getCedula());
        System.out.println("-------:..---" + facturaSet.getIva());
        facturaSet.setCliente(cliente);
        facturaResp = facturaDao.save(facturaSet);
		
		return facturaResp;
	}

	@Override
	public Factura setFactura(FacturaDto facturaData) {
		 Factura facturaSet = new Factura();
		 
		 facturaSet.setSubTotal(facturaData.getSubtotal());
		 facturaSet.setIva(facturaData.getIva());
		 facturaSet.setTotal(facturaData.getTotal());
		 
		return facturaSet;
	}

}
