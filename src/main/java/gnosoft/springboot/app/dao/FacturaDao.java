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
	
	public Factura save(Factura factura) {
		
		 String sqlQuery = "insert into facturas(fecha, iva, sub_total, total, id_cliente) " +
                 "values (?, ?, ?, ?, ?)";
		 			template.update(sqlQuery, 
                   new Date(), 
                   factura.getIva(),
                   factura.getSubTotal(),
                   factura.getTotal(),
                   factura.getCliente().getCedula());
		
		return factura;
		
	}

}
