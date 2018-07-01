package com.tecsup.javawebavanzado.sesion03.beans;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import com.tecsup.javawebavanzado.sesion03.exception.DAOExcepcion;
import com.tecsup.javawebavanzado.sesion03.modelo.Categoria;
import com.tecsup.javawebavanzado.sesion03.modelo.Producto;
import com.tecsup.javawebavanzado.sesion03.negocio.GestionCategorias;
import com.tecsup.javawebavanzado.sesion03.negocio.GestionProductos;

@ManagedBean(name = "categoriaBean")
@RequestScoped
public class CategoriaBean {

	private int idCategoria;
	private String nombre;
	private String descripcion;
	private Collection<Categoria> categorias;
	private Collection<Producto> productos;

	public CategoriaBean() {
		GestionCategorias negocio = new GestionCategorias();
		try {
			categorias = negocio.listar();
			System.out.println("Total de categorías: " + categorias.size());
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}

	public void cargarProductos(int idCategoria) {
		System.out.println("Dentro de cargarProductos()");
		GestionProductos negocio = new GestionProductos();
		try {
			productos = negocio.listarPorCategoria(idCategoria);
			System.out.println("Total de productos: " + productos.size());
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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

	public Collection<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Collection<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	public void onCellEdit(CellEditEvent event) {

		Object newValue = event.getNewValue();
		Object oldValue = event.getOldValue();

		DataTable o = (DataTable) event.getSource();
		Categoria objeto = (Categoria) o.getRowData();
		System.out.println(objeto.getId());

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Actualizado", "Antes: " + oldValue + ", Después:"
							+ newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	

	public void onRowEdit(RowEditEvent event) {

		FacesMessage msg = new FacesMessage("Editor Categoria", ""+ ((Categoria) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
}
