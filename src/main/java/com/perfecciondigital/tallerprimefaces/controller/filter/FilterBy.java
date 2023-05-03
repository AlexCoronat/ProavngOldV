package com.perfecciondigital.tallerprimefaces.controller.filter;

import java.util.ArrayList;
import java.util.function.Predicate;

import com.perfecciondigital.tallerprimefaces.model.Visitante;

public class FilterBy {
	static ArrayList<Visitante> visitantesFiltro = new ArrayList<>();
	public static ArrayList<Visitante> filterByNombre(ArrayList<Visitante> lst, String input){
		Predicate<Visitante> filtroNombre = nombre -> NullConverter.convert(nombre.getNombre()).toLowerCase().contains(input.toLowerCase());
		lst.stream().filter(filtroNombre).forEach(vte -> visitantesFiltro.add(vte));
		return visitantesFiltro;
	}
	public static ArrayList<Visitante> filterByApellido(ArrayList<Visitante> lst, String input){
		Predicate<Visitante> filtroApellido = apellido -> NullConverter.convert(apellido.getApellido()).toLowerCase().contains(input.toLowerCase());
		lst.stream().filter(filtroApellido).forEach(vte -> visitantesFiltro.add(vte));
		return visitantesFiltro;
	}
	public static ArrayList<Visitante> filterByEdad(ArrayList<Visitante> lst, int input){
		Predicate<Visitante> filtroEdad = edad -> NullConverter.convert(edad.getEdad()) == input;
		lst.stream().filter(filtroEdad).forEach(vte -> visitantesFiltro.add(vte));
		return visitantesFiltro;		
	}
	public static ArrayList<Visitante> filterByPais(ArrayList<Visitante> lst, String input){
		Predicate<Visitante> filtroPais = pais -> NullConverter.convert(pais.getPais()).toLowerCase().contains(input.toLowerCase());
		lst.stream().filter(filtroPais).forEach(vte -> visitantesFiltro.add(vte));
		return visitantesFiltro;
	}
	public static ArrayList<Visitante> filterByPasaporte(ArrayList<Visitante> lst, String input){
		Predicate<Visitante> filtroPasaporte = pas -> NullConverter.convert(pas.isPasaporte()).toLowerCase().contains(input.toLowerCase());
		lst.stream().filter(filtroPasaporte).forEach(vte -> visitantesFiltro.add(vte));
		return visitantesFiltro;
	}
	public static ArrayList<Visitante> filterByServidor(ArrayList<Visitante> lst, String input){
		Predicate<Visitante> filtroServidor = serv -> NullConverter.convert(serv.getLector().getServidor()).toLowerCase().contains(input.toLowerCase());
		lst.stream().filter(filtroServidor).forEach(vte -> visitantesFiltro.add(vte));
		return visitantesFiltro;
	}
}
	
