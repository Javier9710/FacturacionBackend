package gnosoft.springboot.app.facade;

import java.util.List;

import gnosoft.springboot.app.vos.DetalleFactura;

public interface IDetalleService {
	
	public DetalleFactura save(DetalleFactura detalle);
	
	public void Delete(Long id);
	
	public List<DetalleFactura> listDetallesFactura(Long id); 

}
