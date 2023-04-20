package com.perfecciondigital.tallerprimefaces.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.perfecciondigital.tallerprimefaces.model.Visitantes;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "cargador")
@SessionScoped

public class CargadorBean implements Serializable {

	private ArrayList<Visitantes> visitantes = new ArrayList<>();
	
	private ArrayList<Visitantes> visitantesVista = new ArrayList<>();
	   
 
	public void cargarListado() {
		
		for (int i = 0; i < 10; i++) {
			String nombre = generarNombres(i);
			String apellido = generarApellidos(); 
			int edad = generarEdades();
			String pais = generarPaises();
			visitantes.add(new Visitantes(nombre, apellido, edad, pais));
		}
	}

	public String generarNombres(int i) {
		String dato = "";
		String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
				"Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
				"Caritina", "Carlota", "Baltazar" };
		dato = nombres[i];
		return dato;
	}

	public String generarApellidos() {
		String dato = "";
		String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
				"Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
				"Grigalva", "Loza", "Corona" };
		dato = apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];

		return dato;
	}

	public int generarEdades() {
		return (int) Math.floor(Math.random() * 70);
	}

	public String generarPaises() {
		String dato = "";
		String[] paises = { "Albania", "Alemania", "Guinea", "Guatemala", "Brasil", "Jamaica", "Italia", "Catar",
				"China", "Suecia", "Chile", "Colombia", "Mexico", "Monaco", "Ucrania", "España", "Filipinas", "Noruega",
				"Iran", "Rusia" };
		dato = paises[(int) (Math.floor(Math.random() * ((paises.length - 1) - 0 + 1) + 0))];
		return dato;
	}
	
	
	public ArrayList<Visitantes> getVisitantesVista() {
		return visitantesVista;
	}

	public void setVisitantesVista(ArrayList<Visitantes> visitantesVista) {
		this.visitantesVista = visitantesVista;
	}

	public ArrayList<Visitantes> getVisitantes() {
		return visitantes;    
	}

	public void setVisitantes(ArrayList<Visitantes> visitantes) {
		this.visitantes = visitantes;
	}

	public void updateVisitantes() {
		RequestContext req = RequestContext.getCurrentInstance();
		req.execute("PF('dialogo').show;");
	}

}
