package gnosoft.springboot.app.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import gnosoft.springboot.app.vos.DetalleFactura;

@Repository
public class DetalleDao {
	
	@Autowired
	private JdbcTemplate template;
	
	
	public void delete(Long id) {
		  String sqlQuery = "delete from detalles where id_factura = ?";
		  template.update(sqlQuery, id);
		}
	
	public DetalleFactura save(DetalleFactura detalle) {
		
		 String sqlQuery = "insert into detalles(cantidad, total, id_articulo, id_factura) " +
                 "values (?, ?, ?, ?)";
		 			template.update(sqlQuery, 
                   detalle.getCantidad(),
                   detalle.getTotal(),
                   detalle.getArticulo().getId(),
                   detalle.getFactura());
		
		return detalle;
	}

}
