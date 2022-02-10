package gnosoft.springboot.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gnosoft.springboot.app.vos.Articulo;

@Repository
public class ArticuloDao {
	
	@Autowired
	private JdbcTemplate template;
	
	public Articulo saveArticulo(Articulo articulo) {
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

	private static class ArticuloRowMapper implements RowMapper<Articulo> {
        @Override
        public Articulo mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Articulo(rs.getLong("id_articulo"), rs.getString("nombre"), rs.getDouble("precio"));
        }
    }
}
