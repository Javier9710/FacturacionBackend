package gnosoft.springboot.app.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gnosoft.springboot.app.facade.IArticuloService;
import gnosoft.springboot.app.vos.Articulo;
import gnosoft.springboot.app.vos.Cliente;
import gnosoft.springboot.app.vos.DetalleFactura;
import gnosoft.springboot.app.vos.Factura;

@Repository
public class DetalleDao {
	
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private IArticuloService articuloService;
	
	
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
	
	
	public List<DetalleFactura> listDetallesFactura(Long id) {
	     return template.query("SELECT * FROM detalles WHERE id_factura=?", (ResultSet rs, int row) ->{
	    		DetalleFactura detalles = new DetalleFactura();
	    		detalles.setId(rs.getLong(1));
		    	Articulo articulo = articuloService.findById(rs.getLong(4));
		    	detalles.setArticulo(articulo);
		    	detalles.setCantidad(rs.getInt(2));
		    	detalles.setTotal(rs.getDouble(3));
		    	detalles.setFactura(rs.getLong(5));
	    		
	    return detalles;
	     }, id);
	}

}
