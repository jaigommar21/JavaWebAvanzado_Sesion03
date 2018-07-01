package com.tecsup.javawebavanzado.sesion03.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.tecsup.javawebavanzado.sesion03.modelo.Empleado;

@ManagedBean(name = "gestorEmpleadoBean")
@SessionScoped
public class GestorEmpleadoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Empleado> list;
	private Empleado item = new Empleado();
    private Empleado beforeEditItem = null;
    private boolean editEnabled;
    
	@PostConstruct
	public void init() {

		// Inicializando list
		list = new ArrayList<Empleado>();

		// Cargando datos
		list.add(new Empleado(new Long(1), "Jaime"));
		list.add(new Empleado(new Long(2), "Eduard"));

	}

	/**
	 * 
	 * @param item
	 * @throws CloneNotSupportedException
	 */
	public void edit(Empleado item) throws CloneNotSupportedException {
		beforeEditItem = item.clone();
		this.item = item;
		editEnabled = true;
	}

	
	/**
	 * 
	 * @param item
	 * @throws IOException
	 */
	public void delete(Empleado item) throws IOException {
		// DAO save the delete
		list.remove(item);
	}
	
	/**
	 * 
	 */
    public void add() {
        // DAO save the add
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new Empleado();
    }
    
    /**
     * 
     */
    public void resetAdd() {
        item = new Empleado();
    }


    /**
     * 
     */
    public void saveEdit() {
        // DAO save the edit
        this.item = new Empleado();
        editEnabled = false;
    }

    /**
     * 
     */
    public void cancelEdit() {
        this.item.restore(beforeEditItem);
        this.item = new Empleado();
        editEnabled = false;
    }
    
	/**
	 * 
	 * @return
	 */
	public List<Empleado> getList() {
		return list;
	}

	public boolean isEditEnabled() {
		return editEnabled;
	}

	public Empleado getItem() {
		return item;
	}

//	public void setItem(Empleado item) {
//		this.item = item;
//	}
	
	
}
