package com.tecsup.javawebavanzado.sesion03.modelo;

public class Empleado {

	Long id;
	
	String nombre;

	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Empleado clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new Empleado(this.getId(), this.getNombre());
	}
	
    public void restore(Empleado emp) {
        this.id = emp.getId();
        this.nombre = emp.getNombre();
    }
	
}
