package gnosoft.springboot.app.vos;

public class DetalleFactura {
	
	private Long id;
	private Articulo articulo;
	private int cantidad;
	private double totol;
	private Factura factura;
	
	//-----------------------------------------------
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getTotol() {
		return totol;
	}
	public void setTotol(double totol) {
		this.totol = totol;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	

}
