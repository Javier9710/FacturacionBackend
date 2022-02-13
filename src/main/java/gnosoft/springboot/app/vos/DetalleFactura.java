package gnosoft.springboot.app.vos;

public class DetalleFactura {
	
	private Long id;
	private Articulo articulo;
	private int cantidad;
	private double total;
	private Long factura;
	
	//-----------------------------------------------
	
	public DetalleFactura() {
		
	}
	
	public DetalleFactura(Long id, Articulo articulo, int cantidad, double total, Long factura) {
		super();
		this.id = id;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.total = total;
		this.factura = factura;
	}
	
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Long getFactura() {
		return factura;
	}
	public void setFactura(Long factura) {
		this.factura = factura;
	}
	
	

}
