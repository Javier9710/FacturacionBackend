package gnosoft.springboot.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	            new ArticuloRowMapper(), cedula);
	}

	private static class ArticuloRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Cliente(rs.getString("id_cliente"), rs.getString("nombre"));
        }
    }

}
