package gnosoft.springboot.app.vos;

import java.util.List;

public class FacturaDto{
	
	
	private Long id;
	private String cedula;
    private Long[] itemId;
    private Integer[] cantidad;
    private List<DetalleFactura> detalles;
    private Double subtotal;
    private Double iva;
    private Double total;
    
    //------------------------------------------------------------
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Long[] getItemId() {
		return itemId;
	}
	public void setItemId(Long[] itemId) {
		this.itemId = itemId;
	}
	public Integer[] getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer[] cantidad) {
		this.cantidad = cantidad;
	}
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Double getIva() {
		return iva;
	}
	public void setIva(Double iva) {
		this.iva = iva;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

    
}
