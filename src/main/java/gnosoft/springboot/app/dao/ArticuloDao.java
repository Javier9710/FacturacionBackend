package gnosoft.springboot.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gnosoft.springboot.app.vos.Articulo;

@Repository
public class ArticuloDao {
	
	@Autowired
	private JdbcTemplate template;
	
	public Articulo save(Articulo articulo) {
		  String sqlQuery = "insert into articulos(nombre, precio) " +
		                    "values (?, ?)";
		  template.update(sqlQuery, 
		                      articulo.getNombre(), 
		                      articulo.getPrecio());
		  
		  return articulo;
		}
	
	public Articulo findById(Long id) {
	    return template.queryForObject("SELECT * FROM articulos WHERE id_articulo = ?",
	            new ArticuloRowMapper(), id);
	}
	
	public List<Articulo> listAll() {
	    return template.query("SELECT * FROM articulos",
	            new ArticuloRowMapper());
	}

	private static class ArticuloRowMapper implements RowMapper<Articulo> {
        @Override
        public Articulo mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Articulo(rs.getLong("id_articulo"), rs.getString("nombre"), rs.getDouble("precio"));
        }
    }
	
	public Articulo update(Articulo articulo) {

		  String sqlQuery = "UPDATE articulos SET nombre=?, precio=? " +
		                    "WHERE id_articulo=?";
		  template.update(sqlQuery, 
		                      articulo.getNombre(), 
		                      articulo.getPrecio(),
		  					  articulo.getId());
		  return articulo;
		}

}
