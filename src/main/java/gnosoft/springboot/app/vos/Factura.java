package gnosoft.springboot.app.vos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
	
	
	private Long id;
	private Cliente cliente;
	private Date fecha;
	private double subTotal;
	private double iva;
	private double total;
	
	private List<DetalleFactura> detalles;
	
	//-----------------------------------------
	
	
	
	public Factura() {
        this.detalles = new ArrayList<DetalleFactura>();
    }
	
	public Factura(long l, Cliente object, java.sql.Date date, double d, double e, double f, List<DetalleFactura> detalles2) {
		super();
		this.id = l;
		this.cliente = object;
		this.fecha = date;
		this.subTotal = d;
		this.iva = e;
		this.total = f;
		this.detalles = detalles2;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	
	public void agregarDetalle(DetalleFactura detalle) {
        this.detalles.add(detalle);
    }
	
	
	
	

}
