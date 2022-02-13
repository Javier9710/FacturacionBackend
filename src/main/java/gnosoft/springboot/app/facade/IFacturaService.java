package gnosoft.springboot.app.facade;

import java.util.List;

import gnosoft.springboot.app.vos.Factura;
import gnosoft.springboot.app.vos.FacturaDto;

public interface IFacturaService {
	
	public Factura save(Factura factura, FacturaDto facturaData);
	
	public Factura setFactura(FacturaDto facturaData);
	
	public Factura findById(Long id);
	
	public List<Factura> listAll();
	
	public boolean delete(Long id);

}
