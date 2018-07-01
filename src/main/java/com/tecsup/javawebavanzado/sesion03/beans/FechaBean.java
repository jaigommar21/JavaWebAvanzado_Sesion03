package com.tecsup.javawebavanzado.sesion03.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "fechaBean")
@RequestScoped
public class FechaBean {

	private Date fecha;
	private String fechaMinima;
	private String fechaMaxima;
	
	public FechaBean(){
		fechaMinima = "2018-01-15";
		fechaMaxima = "2018-02-15";	
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFechaMinima() {
		return fechaMinima;
	}

	public void setFechaMinima(String fechaMinima) {
		this.fechaMinima = fechaMinima;
	}

	public String getFechaMaxima() {
		return fechaMaxima;
	}

	public void setFechaMaxima(String fechaMaxima) {
		this.fechaMaxima = fechaMaxima;
	}

	

}
