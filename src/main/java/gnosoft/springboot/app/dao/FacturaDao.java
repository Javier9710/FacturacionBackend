package gnosoft.springboot.app.dao;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import gnosoft.springboot.app.vos.Factura;

@Repository
public class FacturaDao {
	
	@Autowired
	private JdbcTemplate template;
	
	
	
	public Long generaId() {
		Long id=0L;
		String sqlQuery = "SELECT MAX(id_factura)" +
		                  " FROM facturas";
		id = (template.queryForObject(sqlQuery, Long.class)+1);
		return id; 
	}
	
	public Factura save(Factura factura) {
		
		Long id = this.generaId();
		 String sqlQuery = "insert into facturas(id_factura, fecha, iva, sub_total, total, id_cliente) " +
                 "values (?, ?, ?, ?, ?, ?)";
		 		   template.update(sqlQuery, 
		 		   id,   
                   new Date(), 
                   factura.getIva(),
                   factura.getSubTotal(),
                   factura.getTotal(),
                   factura.getCliente().getCedula());
		factura.setId(id);
		return factura;
		
	}

}
