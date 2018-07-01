package com.tecsup.javawebavanzado.sesion03.beans;


import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "facturaBean")
@RequestScoped
public class FacturaBean {

	private int cantidad;
	private String direccion;
	private Date fechaCreacion;
	private double monto;
	
	public FacturaBean(){
		fechaCreacion = new Date();
		monto = 8000.00;
	}	
	
	public void deportesChangeListener(ValueChangeEvent event){
		System.out.println("Nuevo deporte: " + event.getNewValue().toString());      
    }
	
	public void cantidadValueChanged(ValueChangeEvent event){
		System.out.println("Nueva cantidad: " + event.getNewValue().toString());      
    }	
	
	public void procesar(ActionEvent event) {
		System.out.println("Dentro de procesar...");
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}


}
