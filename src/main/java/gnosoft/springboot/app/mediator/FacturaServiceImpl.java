package gnosoft.springboot.app.mediator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gnosoft.springboot.app.dao.ArticuloDao;
import gnosoft.springboot.app.dao.ClienteDao;
import gnosoft.springboot.app.dao.DetalleDao;
import gnosoft.springboot.app.dao.FacturaDao;
import gnosoft.springboot.app.facade.IFacturaService;
import gnosoft.springboot.app.vos.Articulo;
import gnosoft.springboot.app.vos.Cliente;
import gnosoft.springboot.app.vos.DetalleFactura;
import gnosoft.springboot.app.vos.Factura;
import gnosoft.springboot.app.vos.FacturaDto;

@Service
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired 
	private FacturaDao facturaDao;
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private ArticuloDao articuloDao;
	
	@Autowired
	private DetalleDao detalleDao;

	@Override
	public Factura save(Factura facturaSet, FacturaDto facturaData) {
		
		Factura facturaResp = null;
        Cliente cliente = clienteDao.findById(facturaData.getCedula());
        facturaSet.setCliente(cliente);
        facturaResp = facturaDao.save(facturaSet);
        for (int i = 0; i < facturaData.getItemId().length; i++) {
            Articulo articulo = articuloDao.findById(facturaData.getItemId()[i]);
            DetalleFactura linea = new DetalleFactura();
            linea.setCantidad(facturaData.getCantidad()[i]);
            linea.setArticulo(articulo);
            linea.setTotal(facturaData.getCantidad()[i] * articulo.getPrecio());
            linea.setFactura(facturaResp.getId());
            facturaResp.agregarDetalle(linea);
            detalleDao.save(linea);

        }
		
		return facturaResp;
	}

	@Override
	public Factura setFactura(FacturaDto facturaData) {
		 Factura facturaSet = new Factura();
		 facturaSet.setId(facturaData.getId());
		 facturaSet.setSubTotal(facturaData.getSubtotal());
		 facturaSet.setIva(facturaData.getIva());
		 facturaSet.setTotal(facturaData.getTotal());
		 
		return facturaSet;
	}

	@Override
	public Factura findById(Long id) {
		return facturaDao.findById(id);
	}

	@Override
	public List<Factura> listAll() {
		return facturaDao.listAll();
	}

	@Override
	public boolean delete(Long id) {
		return facturaDao.delete(id);
	}

}
