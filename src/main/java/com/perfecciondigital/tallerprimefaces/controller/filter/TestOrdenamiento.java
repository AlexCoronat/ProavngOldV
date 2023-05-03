package com.perfecciondigital.tallerprimefaces.controller.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.perfecciondigital.tallerprimefaces.model.Lector;
import com.perfecciondigital.tallerprimefaces.model.Visitante;

public class TestOrdenamiento {

	public static void main(String[] args) {
		ArrayList<Visitante> lstVisitante = CargadorDatos.ListaVisitantes();
		List<Lector> lstLector = CargadorDatos.ListaLector();
		int count = 0;
		for (Visitante vte : lstVisitante) {
			Lector ltr = lstLector.get(count);
			vte.setLector(new Lector(), ltr.getServidor());
			count++;
		}

		String opcion = "";
		boolean orden = true;
		Scanner in = new Scanner(System.in);
		System.out.println("Ordenar por:");
		System.err.println("[Nombre] [Apellido] [Edad] [País] [Pasaporte] [Servidor]");
		opcion = in.next();
		System.err.println("Teclea 'true' para orden ascendente ó 'false' para orden descendente");
		orden = in.nextBoolean();
		switch (opcion) {
		case "nombre": {
			OrderBy.orderByNombre(lstVisitante, orden);
			for (int i = 0; i < lstVisitante.size(); i++) {
				System.out.println(lstVisitante.get(i) + "\n");
			}
		}
			break;
		case "apellido": {
			OrderBy.orderByApellido(lstVisitante, orden);
			for (int i = 0; i < lstVisitante.size(); i++) {
				System.out.println(lstVisitante.get(i) + "\n");
			}
		}
			break;
		case "edad": {
			OrderBy.orderByEdad(lstVisitante, orden);
			for (int i = 0; i < lstVisitante.size(); i++) {
				System.out.println(lstVisitante.get(i) + "\n");
			}
		}
			break;
		case "pais": {
			OrderBy.orderByPais(lstVisitante, orden);
			for (int i = 0; i < lstVisitante.size(); i++) {
				System.out.println(lstVisitante.get(i) + "\n");
			}
		}
			break;
		case "pasaporte": {
			OrderBy.orderByPasaporte(lstVisitante, orden);
			for (int i = 0; i < lstVisitante.size(); i++) {
				System.out.println(lstVisitante.get(i) + "\n");
			}
		}
			break;
		case "servidor": {
			OrderBy.orderByServidor(lstVisitante, orden);
			for (int i = 0; i < lstVisitante.size(); i++) {
				System.out.println(lstVisitante.get(i) + "\n");
			}
		}
			break;
		default:
			break;
		}
	}

}
