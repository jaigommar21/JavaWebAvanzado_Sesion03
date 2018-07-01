package com.tecsup.javawebavanzado.sesion03.beans;


import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.tecsup.javawebavanzado.sesion03.exception.DAOExcepcion;
import com.tecsup.javawebavanzado.sesion03.modelo.Producto;
import com.tecsup.javawebavanzado.sesion03.negocio.GestionProductos;


@ManagedBean(name = "productoBean")
@RequestScoped
public class ProductoBean {

	private int idProducto;
	private String nombre;
	private String descripcion;
	private float precio;
	private Collection<Producto> productos;
	private Producto seleccionado;
	
	public ProductoBean(){
		GestionProductos negocio = new GestionProductos();
		try {
			//productos = negocio.buscarPorNombre("%");
			productos = negocio.listarPorCategoria(1);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	public Producto getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(Producto seleccionado) {
		this.seleccionado = seleccionado;
	}	
}
