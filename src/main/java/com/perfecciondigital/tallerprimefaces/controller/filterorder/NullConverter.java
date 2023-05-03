package com.perfecciondigital.tallerprimefaces.controller.filterorder;

import java.util.ArrayList;

import com.perfecciondigital.tallerprimefaces.model.Visitante;

/**
 * La clase NullConverter nos permite revisar que los elementos extraidos de una
 * clase modelo no tengan valor nulo y transformarlo de ser necesario.
 * 
 * @author Jesús Corona
 * @author Marcos Adil
 *
 */
public class NullConverter {
	/**
	 * nombreToString recibe un objeto de tipo Visitante y por medio de una
	 * condición, se evalua que el objeto no sea nulo, de ser así su valor nulo será
	 * reemplazado por una cadena vacía.
	 * 
	 * @param v Un objeto de tipo Visitante, del cual se evaluarán sus atributos.
	 * @return Retorna un String con el valor obtenido del objeto ó una cadena vacía
	 *         si el objeto es nulo.
	 */
	public static String nombretToString(Visitante v) {
		return v.getNombre() == null ? "" : v.getNombre();
	}

	/**
	 * apellidoToString recibe un objeto de tipo Visitante y por medio de una
	 * condición, se evalua que el objeto no sea nulo, de ser así su valor nulo será
	 * reemplazado por una cadena vacía.
	 * 
	 * @param v Un objeto de tipo Visitante, del cual se evaluarán sus atributos.
	 * @return Retorna un String con el valor obtenido del objeto ó una cadena vacía
	 *         si el objeto es nulo.
	 */
	public static String apellidotToString(Visitante v) {
		return v.getApellido() == null ? "" : v.getApellido();
	}

	/**
	 * EdadToString recibe un objeto de tipo Visitante y por medio de una condición,
	 * se evalua que el objeto no sea nulo, de ser así su valor nulo será
	 * reemplazado por una cadena vacía.
	 * 
	 * @param v Un objeto de tipo Visitante, del cual se evaluarán sus atributos.
	 * @return Retorna un entero con el valor obtenido del objeto ó 0 si el objeto
	 *         es nulo.
	 */
	public static int edadtToInt(Visitante v) {
		try {
			String strEdad = Integer.toString(v.getEdad());
			return strEdad == null ? 0 : v.getEdad();
		} catch (NumberFormatException e) {
			e.getStackTrace();
			return 0;
		}
	}

	/**
	 * paisToString recibe un objeto de tipo Visitante y por medio de una condición,
	 * se evalua que el objeto no sea nulo, de ser así su valor nulo será
	 * reemplazado por una cadena vacía.
	 * 
	 * @param v Un objeto de tipo visitante, del cual se evaluarán sus atributos.
	 * @return Retorna un String con el valor obtenido del objeto ó una cadena vacía
	 *         si el objeto es nulo.
	 */
	public static String paistToString(Visitante v) {
		return v.getPais() == null ? "" : v.getPais();
	}

	/**
	 * listToString nos permite evaluar los elementos contenidos en el ArrayList de
	 * parámetro y convertir con los métodos de conversión de esta clase los valores
	 * que encuentre nulos a cadenas vacías o si el valor nulo es un entero
	 * convertirlo a 0, esto nos permitirá hacer un uso correcto de los metodos de
	 * ordenamiento de la clase OrderBy
	 * 
	 * @param alstEntrada Un ArrayList de tipo Visitante con valores que no es
	 *                    posible modificar
	 * @return Retorna una lista auxiliar con los valores modificados a los cuales
	 *         es posible acceder sin la problemática de obtener valore nulos
	 */
	public static ArrayList<Visitante> listToString(ArrayList<Visitante> alstEntrada) {
		ArrayList<Visitante> alstAuxiliar = new ArrayList<>();
		for (Visitante vte : alstEntrada) {
			alstAuxiliar.add(
					new Visitante(nombretToString(vte), apellidotToString(vte), edadtToInt(vte), paistToString(vte)));
		}
		return alstAuxiliar;
	}
}
