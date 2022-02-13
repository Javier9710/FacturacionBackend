package gnosoft.springboot.app.dao;


import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import gnosoft.springboot.app.facade.IClienteService;
import gnosoft.springboot.app.vos.Cliente;
import gnosoft.springboot.app.vos.Factura;

@Repository
public class FacturaDao {
	
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private IClienteService clienteDao;
	
	
	
	public Long generaId() {
		Long id=null;
		String sqlQuery = "SELECT MAX(id_factura)" +
		                  " FROM facturas";
		id = (template.queryForObject(sqlQuery, Long.class));
		if(id==null){
			id=1L;
			return id;
		}
		id++;
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
	
	
	public boolean delete(Long id) {
		  String sqlQuery = "delete from facturas where id_factura = ?";
		  template.update(sqlQuery, id);
		  return true;
		}
	
	public Factura findById(Long id) {
	     return template.queryForObject("SELECT * FROM facturas WHERE id_factura=?", (ResultSet rs, int row) ->{
	    		Factura factura= new Factura();
			   	factura.setId(rs.getLong(1));
			   	System.out.println("PRUEBA: "+ rs.getLong(1) );
			   	System.out.println("sasdasd:" +rs.getString(6));
			   	Cliente cliente = clienteDao.findById(rs.getString(6));
			   	System.out.println("no pasa: " +cliente);
			   	factura.setCliente(clienteDao.findById(rs.getString(6)));
			   	factura.setFecha(rs.getDate(2));
			   	factura.setIva(rs.getDouble(3));
			   	factura.setSubTotal(rs.getDouble(4));
			   	factura.setTotal(rs.getDouble(5)); 		
	    return factura;
	     },id);
	}
	
	
	
	public List<Factura> listAll() {
	     return template.query("SELECT * FROM facturas", (ResultSet rs, int row) ->{
	    		Factura factura= new Factura();
		    	factura.setId(rs.getLong(1));
		    	System.out.println("PRUEBA: "+ rs.getLong(1) );
		    	System.out.println("sasdasd:" +rs.getString(6));
		    	Cliente cliente = clienteDao.findById(rs.getString(6));
		    	System.out.println("no pasa: " +cliente);
		    	factura.setCliente(clienteDao.findById(rs.getString(6)));
		    	factura.setFecha(rs.getDate(2));
		    	factura.setIva(rs.getDouble(3));
		    	factura.setSubTotal(rs.getDouble(4));
		    	factura.setTotal(rs.getDouble(5));
	           
	    		
	    return factura;
	     });
	}

}
