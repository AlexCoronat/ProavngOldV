package com.perfecciondigital.tallerprimefaces.controller.filter;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.perfecciondigital.tallerprimefaces.model.Lector;
import com.perfecciondigital.tallerprimefaces.model.Visitante;
/**
 * La clase CargadorDatos nos permita llenar arreglos con el tipo de objeto y
 * los datos especificados
 * 
 * @author Jesús Corona
 * @author Marcos Adil
 *
 */
@ManagedBean(name = "cargadorDatos")
@SessionScoped
public class CargadorDatos {
	/**
	 * ListaVisitantes nos permite llenar un ArrayList con datos específicos que
	 * podran ser usados en otras clases.
	 * 
	 * @return Reotrna una lista (ArrayList) con todos los datos previamente
	 *         cargados
	 */
	static int cantDatos = 5;
	static int rows;
	public ArrayList<Visitante> visitantes = new ArrayList<>();
	ArrayList<Lector> lector = new ArrayList<>(); 
	public void cargarListado(){  
		int count = 0;
		for (int i = 0; i < cantDatos; i++) { 
			Lector ltr = ListaLector().get(count);
			String nombre = generarNombres();
			String apellido = generarApellidos(); 
			int edad = generarEdades();
			boolean pasaporte = generarPasaporte();
			String pasaporteVista = generarPasaporteVista(pasaporte);
			String pais = generarPaises();
			String lector = ltr.getServidor();
			visitantes.add(new Visitante(nombre, apellido, edad, pais,
					pasaporteVista,lector));
			count++; 
		}
		rows = visitantes.size();
	}
	
	public static ArrayList<Visitante> ListaVisitantes() {
		ArrayList<Visitante> visitantes = new ArrayList<>();   
		for (int i = 0; i < cantDatos; i++) {
			String nombre = generarNombres();
			String apellido = generarApellidos(); 
			int edad = generarEdades();
			String pais = generarPaises();
			Lector ltr;
			visitantes.add(new Visitante(nombre, apellido, edad, pais));
		}
		rows = visitantes.size();
		return visitantes;
	}
	/**
	 * ListaLector nos permite llenar un ArrayList con datos específicos que podran
	 * ser usados en otras clases.
	 * 
	 * @return Reotrna una lista (ArrayList) con todos los datos previamente
	 *         cargados
	 */
	public static List<Lector> ListaLector() {
		ArrayList<Lector> lector = new ArrayList<>();   
		for (int i = 0; i < cantDatos; i++) {
			String id = generarId();
			String comunicacion = generarComunicacion(); 
			String modelo = generarModelo();
			String servidor =generarServidor();
			lector.add(new Lector(id, comunicacion, modelo, servidor));
		}
		return lector;
	}
	public void cargaLector() {  
		for (int i = 0; i < cantDatos; i++) {
			String id = generarId();
			String comunicacion = generarComunicacion(); 
			String modelo = generarModelo();
			String servidor =generarServidor();
			lector.add(new Lector(id, comunicacion, modelo, servidor));
		}
	}
	public int getRows() {
		return rows;
	}
	
	public void  setRows(int rows) {
		CargadorDatos.rows = rows;
	}
	public static String generarNombres() {
		String dato = ""; 
		String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
				"Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
				"Caritina", "Carlota", "Baltazar",null};
		dato = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))];
		return dato;
	}

	public static String generarApellidos() {
		String dato = "";
		String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
				"Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
				"Grigalva", "Loza", "Corona",null};
		dato = apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];

		return dato;
	}

	public static int generarEdades() {
		return (int) Math.floor(Math.random() * 70);
	}
	public static boolean generarPasaporte() {
		String dato = "";
		String[] paises = {"true", "false"};
//		(int) (Math.floor(Math.random() * ((paises.length - 1) - 0 + 1) + 0))
		dato = paises[(int) (Math.floor(Math.random() * ((paises.length - 1) - 0 + 1) + 0))];
		return dato == "true" ? true : false;
	}
	public static String generarPasaporteVista(boolean pass) {
		return pass ? "Si" : "No";
	}
	public static String generarPaises() {
		String dato = "";
		String[] paises = { "Albania", "Alemania", "Guinea", "Guatemala", "Brasil", "Jamaica", "Italia", "Catar",
				"China", "Suecia", "Chile", "Colombia", "Mexico", "Monaco", "Ucrania", "España", "Filipinas", "Noruega",
				"Iran", "Rusia",null};
//		(int) (Math.floor(Math.random() * ((paises.length - 1) - 0 + 1) + 0))
		dato = paises[(int) (Math.floor(Math.random() * ((paises.length - 1) - 0 + 1) + 0))];
		return dato;
	}
	public static String generarId() { 
		String dato = ""; 
		String[] nombres = { "SigkjR", "RXxUZf", "gQDAte", "Ucbiji", "rymCSc", "qLbYuz", "WtiMKb", "dbczEu",
				"dUUxTQ", "DRNkqU", "qSJfaF", "AbrbVM", "yftTFZ", "XwkuUF", "ZFLZSL", "XMzePM", "cpLcMY",
				"XHjSez", "pumFur", "dcerBV",null};
		dato = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))];
		return dato == null ? null : dato + "_" + (int) Math.floor(Math.random() * 70);
	}

	public static String generarComunicacion() {
		String[] apellidos = { "Serial", "Ip", "TCP", "SSH",null};
		return apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
	}

	public static String generarModelo() {
		String[] modelo = { "BcpFf", "NC}AC", "ZL3BU", "whzUp", "*6yzr", "4J2&)", ";=Z{e", "NXY!j",
				"rtw;}", "R5bwS", "Cy.r;", "ArM8F", "YrAdh", "U:/[X", "3fYW)", "p=bB{", "qhMQD", "mSjc,",
				"[WV!C", "qFJfD",null};
		String dato = modelo[(int) (Math.floor(Math.random() * ((modelo.length - 1) - 0 + 1) + 0))];
		return dato == null ? null : dato + "_" +(int) Math.floor(Math.random() * 70);
	}

	public static String generarServidor() {
		String[] strServidor = { "Albania", "Alemania", "Guinea", "Guatemala", "Brasil", "Jamaica", "Italia", "Catar",
				"China", "Suecia", "Chile", "Colombia", "Mexico", "Monaco", "Ucrania", "España", "Filipinas", "Noruega",
				"Iran", "Rusia",null};
//		(int) (Math.floor(Math.random() * ((paises.length - 1) - 0 + 1) + 0))
		return strServidor[(int) (Math.floor(Math.random() * ((strServidor.length - 1) - 0 + 1) + 0))];
	}
	public static Date generarFechaLlegada() throws ParseException {
		String strFecha = "";
		int dia = (int) Math.floor(Math.random() * 30);
		int mes = (int) Math.floor(Math.random() * 12);
		strFecha = dia +"/"+mes+"/2023";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		return formato.parse(strFecha);
	}
	public static Date generarFechaSalida() throws ParseException {
		String strFecha = "";
		int dia = (int) Math.floor(Math.random() * 30);
		int mes = (int) Math.floor(Math.random() * 12);
		strFecha = dia +"/"+mes+"/2024";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		return formato.parse(strFecha);
	}
	public ArrayList<Visitante> getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(ArrayList<Visitante> visitantes) {
		this.visitantes = visitantes;
	}

	public ArrayList<Lector> getLector() {
		return lector;
	}

	public void setLector(ArrayList<Lector> lector) {
		this.lector = lector;
	}
	
}
