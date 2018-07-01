package com.tecsup.javawebavanzado.sesion03.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.tecsup.javawebavanzado.sesion03.modelo.Persona;

@ManagedBean(name = "personaBean")
@RequestScoped 	
public class PersonaBean {

	private String codPersonaSeleccionado;
	private List<Persona> personas;

	public PersonaBean() {
		personas = new ArrayList<Persona>();

		Persona p1 = new Persona();
		p1.setCodPersona("501");
		p1.setApePaterno("Rodriguez");
		p1.setApeMaterno("Condezo");
		p1.setNombres("David");
		p1.setDireccion("Lima 13");
		p1.setCorreo("rcondezo@gmail.com");

		Persona p2 = new Persona();
		p2.setCodPersona("502");
		p2.setApePaterno("Perez");
		p2.setApeMaterno("Lopez");
		p2.setNombres("Juan");
		p2.setDireccion("Lima 21");
		p2.setCorreo("jperez@gmail.com");

		Persona p3 = new Persona();
		p3.setCodPersona("503");
		p3.setApePaterno("Rodriguez");
		p3.setApeMaterno("Quispe");
		p3.setNombres("Luis");
		p3.setDireccion("Lima 3");
		p3.setCorreo("lflores@gmail.com");

		personas.add(p1);
		personas.add(p2);
		personas.add(p3);

	}

	public List<Persona> buscar(String consulta) {
		consulta = consulta.trim();
		System.out.println(consulta);
		// Logica de filtro

		List<Persona> encontrados = new ArrayList<Persona>();
		for (Persona p : this.personas) {
			if (p.getApePaterno().toUpperCase()
					.startsWith(consulta.toUpperCase())) {
				encontrados.add(p);
			}
		}

		return encontrados;
	}

	public void grabar(){
		System.out.println("Seleccionado: " + codPersonaSeleccionado);
	}

	public String getCodPersonaSeleccionado() {
		return codPersonaSeleccionado;
	}

	public void setCodPersonaSeleccionado(String codPersonaSeleccionado) {
		this.codPersonaSeleccionado = codPersonaSeleccionado;
	}	
}
