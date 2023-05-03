package com.perfecciondigital.tallerprimefaces.controller.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.perfecciondigital.tallerprimefaces.model.Lector;
import com.perfecciondigital.tallerprimefaces.model.Visitante;

public class TestFiltro {

	public static void main(String[] args) {
		ArrayList<Visitante> lstVisitante = CargadorDatos.ListaVisitantes();
		ArrayList<Visitante> filteredList;
		List<Lector> lstLector = CargadorDatos.ListaLector();
		int count = 0;
		for (Visitante vte : lstVisitante) {
			Lector ltr = lstLector.get(count);
			vte.setLector(new Lector(), ltr.getServidor());
			count++;
		}
		String opcion = "";
		String dato = "";
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < lstVisitante.size(); i++) {
			System.out.println(lstVisitante.get(i) + "\n");
		}
		while (opcion != "salir") {
			System.err.println("[Nombre] [Apellido] [Edad] [País] [Pasaporte] [Servidor] ---> (salir)");
			opcion = in.next();
			System.err.println("Ingresa el valor que deseas buscar:");
			dato = in.next();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch (opcion) {
			case "nombre": {
				filteredList = FilterBy.filterByNombre(lstVisitante, dato);
				for (int i = 0; i < filteredList.size(); i++) {
					System.out.println(filteredList.get(i) + "\n");
				}
			}
				break;
			case "apellido": {
				filteredList = FilterBy.filterByApellido(lstVisitante, dato);
				for (int i = 0; i < filteredList.size(); i++) {
					System.out.println(filteredList.get(i) + "\n");
				}
			}
				break;
			case "edad": {
				try {
					int inputConvert = Integer.parseInt(dato);
					filteredList = FilterBy.filterByEdad(lstVisitante, inputConvert);
					for (int i = 0; i < filteredList.size(); i++) {
						System.out.println(filteredList.get(i) + "\n");
					}
				} catch (NumberFormatException e) {
					// Retornar aquí una función que abra un dialog en PF
					System.err.println("El dato: " + dato + " no es un numero");
				}
			}
				break;
			case "pais": {
				filteredList = FilterBy.filterByPais(lstVisitante, dato);
				for (int i = 0; i < filteredList.size(); i++) {
					System.out.println(filteredList.get(i) + "\n");
				}
			}
				break;
			case "pasaporte": {
				filteredList = FilterBy.filterByPasaporte(lstVisitante, dato);
				for (int i = 0; i < filteredList.size(); i++) {
					System.out.println(filteredList.get(i) + "\n");
				}
			}
				break;
			case "servidor": {
				filteredList = FilterBy.filterByServidor(lstVisitante, dato);
				for (int i = 0; i < filteredList.size(); i++) {
					System.out.println(filteredList.get(i) + "\n");
				}
			}
				break;
			default:
				break;
			}
		}
	}

}
