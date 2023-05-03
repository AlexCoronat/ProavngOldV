package com.perfecciondigital.tallerprimefaces.controller;

import java.io.Serializable;
import java.util.ArrayList;

import com.perfecciondigital.tallerprimefaces.model.Visitante;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

@SuppressWarnings("deprecation")
@ManagedBean(name = "cargador")
@SessionScoped

public class Cargador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<Visitante> visitantes = new ArrayList<>();
	
	int rows;
 
	public void cargarListado() {
		   
		for (int i = 0; i < 15; i++) {
			String nombre = generarNombres();
			String apellido = generarApellidos(); 
			int edad = generarEdades();
			String pais = generarPaises();
			visitantes.add(new Visitante(nombre, apellido, edad, pais));
		}
		rows = visitantes.size();
	}
	
	public int getRows() {
		return rows;
	}
	
	public void  setRows(int rows) {
		this.rows = rows;
	}
	public static String generarNombres() {
		String dato = ""; 
		String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
				"Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
				"Caritina", "Carlota", "Baltazar" };
		dato = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))];
		return dato;
	}

	public static String generarApellidos() {
		String dato = "";
		String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
				"Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
				"Grigalva", "Loza", "Corona" };
		dato = apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];

		return dato;
	}

	public static int generarEdades() {
		return (int) Math.floor(Math.random() * 70);
	}

	public static String generarPaises() {
		String dato = "";
		String[] paises = { "Albania", "Alemania", "Guinea", "Guatemala", "Brasil", "Jamaica", "Italia", "Catar",
				"China", "Suecia", "Chile", "Colombia", "Mexico", "Monaco", "Ucrania", "España", "Filipinas", "Noruega",
				"Iran", "Rusia" };
//		(int) (Math.floor(Math.random() * ((paises.length - 1) - 0 + 1) + 0))
		dato = paises[(int) (Math.floor(Math.random() * ((paises.length - 1) - 0 + 1) + 0))];
		return dato;
	}

	public ArrayList<Visitante> getVisitantes() {
		return visitantes;    
	}

	public void setVisitantes(ArrayList<Visitante> visitantes) {
		this.visitantes = visitantes;
	}

	public void updateVisitantes() {
		RequestContext req = RequestContext.getCurrentInstance();
		req.execute("PF('dialogo').show;");
	}

}
