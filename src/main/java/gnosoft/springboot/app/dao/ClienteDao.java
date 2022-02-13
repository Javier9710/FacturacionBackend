package gnosoft.springboot.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gnosoft.springboot.app.vos.Cliente;

@Repository
public class ClienteDao {
	
	@Autowired
	private JdbcTemplate template;
	
	public Cliente save(Cliente cliente) {
		  String sqlQuery = "insert into clientes(id_cliente, nombre) " +
		                    "values (?, ?)";
		  template.update(sqlQuery, 
		                      cliente.getCedula(), 
		                      cliente.getNombre());
		  
		  return cliente;
		}
	
	public Cliente findById(String cedula) {
	    return template.queryForObject("SELECT * FROM clientes WHERE id_cliente = ?",
	            new ClienteRowMapper(), cedula);
	}
	
	
	public List<Cliente> listAll() {
	    return template.query("SELECT * FROM clientes",
	            new ClienteRowMapper());
	}

	private static class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Cliente(rs.getString("id_cliente"), rs.getString("nombre"));
        }
    }
	
	public Cliente update(Cliente cliente) {

		  String sqlQuery = "UPDATE clientes SET nombre=? " +
		                    "WHERE id_cliente=?";
		  template.update(sqlQuery, 
		                      cliente.getNombre(),
		  					  cliente.getCedula());
		  return cliente;
		}

}
