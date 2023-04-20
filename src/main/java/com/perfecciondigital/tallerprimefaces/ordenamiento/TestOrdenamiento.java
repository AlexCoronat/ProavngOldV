package com.perfecciondigital.tallerprimefaces.ordenamiento;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestOrdenamiento {

	public static void main(String[] args) {
		OrderBy ordenamiento = new OrderBy();
		ArrayList<Visitante> lstVisitante = new CargadorDatos().ListaVisitantes();
		List<Lector> lstLector = new CargadorDatos().ListaLector();
		String get = "";
		int count = 0;
		for (Visitante vte : lstVisitante) {
			Lector ltr = lstLector.get(count);
			get = ltr.getServidor();
			vte.setLector(ltr, get);
			count++;
		}

		String opcion = "";
		boolean orden = true;
		Scanner in = new Scanner(System.in);
		System.out.println("Ordenar por:");
		System.out.println("[Nombre] [Apellido] [Edad] [País] [Servidor]");
		opcion = in.next();
		System.out.println("Teclea 'true' para orden ascendente ó 'false' para orden descendente");
		orden = in.nextBoolean();
		switch (opcion) {
		case "nombre": {
			ordenamiento.orderByNombre(lstVisitante, orden);
			for (int i = 0; i < lstVisitante.size(); i++) {
				System.out.println(lstVisitante.get(i) + "\n");

			}
		}
			break;
		case "apellido": {
			ordenamiento.orderByApellido(lstVisitante, orden);
			for (int i = 0; i < lstVisitante.size(); i++) {
				System.out.println(lstVisitante.get(i) + "\n");

			}
		}
			break;
		case "edad": {
			ordenamiento.orderByEdad(lstVisitante, orden);
			for (int i = 0; i < lstVisitante.size(); i++) {
				System.out.println(lstVisitante.get(i) + "\n");

			}
		}
			break;
		case "pais": {
			ordenamiento.orderByPais(lstVisitante, orden);
			for (int i = 0; i < lstVisitante.size(); i++) {
				System.out.println(lstVisitante.get(i) + "\n");

			}
		}
			break;
		case "servidor": {
			ordenamiento.orderByServidor(lstVisitante, orden);
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
