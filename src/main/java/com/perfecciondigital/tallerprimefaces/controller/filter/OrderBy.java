package com.perfecciondigital.tallerprimefaces.controller.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.perfecciondigital.tallerprimefaces.model.Visitante;

/**
 * La clase OrderBy nos permite recibir listas y ordenarlas de forma acendente o
 * descendente Se apoya del ordenamiento sort de la clase Colections.
 * 
 * @author Jesús Corona
 * @author Marcos Adil
 */
public class OrderBy {
	// Ordenamiento para clase visitante
	/**
	 * orderByNombre nos ayuda a ordenar todos los objetos con atributo nombre que
	 * contienen el arraylist que recibe. Hace uso de la clase Colections de java
	 * util y de su funcion sort con el cual realizala ordenación de los datos.
	 * Dentro de sort en el método compare, se reciben dos objetos de tipo
	 * Visitante; Previo a comparar primero se verifíca que el objeto evaluado no
	 * sea nulo con la clase NullConverter y su función nombreToString, de ser así
	 * se sustituye el valor por una cadena vacía.
	 * 
	 * El ordenamiento esta personalizado, está configurado para que ignore los
	 * valores vacíos y ordene solo los que cuentan con un dato válido.
	 * 
	 * @param alstVisitante Es un ArrayList<Visitante> del cual se extraen los datos
	 *                      a ordenar
	 * @param orden         Es de tipo boolean y su función es determinar si la
	 *                      ordenacion sera ASC o DESC
	 */
	public static void orderByNombre(ArrayList<Visitante> alstVisitante, boolean orden) {
		Collections.sort(alstVisitante, new Comparator<Visitante>() {
			@Override
			public int compare(Visitante o1, Visitante o2) {
				if (orden) {
					String strAuxiliar1 = NullConverter.nombretToString(o1);
					String strAuxiliar2 = NullConverter.nombretToString(o2);
					if (strAuxiliar1 == "") {
						strAuxiliar1 = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
					} else if (strAuxiliar2 == "") {
						strAuxiliar2 = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
					}
					return strAuxiliar1.compareTo(strAuxiliar2);
				} else {
					return NullConverter.nombretToString(o2).compareTo(NullConverter.nombretToString(o1));
				}
			}
		});
	}

	/**
	 * orderByApellido nos ayuda a ordenar todos los objetos con atributo apellido
	 * que contienen el arraylist que recibe. Hace uso de la clase Colections de
	 * java util y de su funcion sort con el cual realizala ordenación de los datos.
	 * Dentro de sort en el método compare, se reciben dos objetos de tipo
	 * Visitante; Previo a comparar primero se verifíca que el objeto evaluado no
	 * sea nulo con la clase NullConverter y su función nombreToString, de ser así
	 * se sustituye el valor por una cadena vacía.
	 * 
	 * El ordenamiento esta personalizado, está configurado para que ignore los
	 * valores vacíos y ordene solo los que cuentan con un dato válido.
	 * 
	 * @param alstVisitante Es un ArrayList<Visitante> del cual se extraen los datos
	 *                      a ordenar
	 * @param orden         Es de tipo boolean y su función es determinar si la
	 *                      ordenacion sera ASC o DESC
	 */
	public static void orderByApellido(ArrayList<Visitante> array, boolean orden) {
		Collections.sort(array, new Comparator<Visitante>() {
			@Override
			public int compare(Visitante o1, Visitante o2) {
				if (orden) {
					String strAuxiliar1 = NullConverter.apellidotToString(o1);
					String strAuxiliar2 = NullConverter.apellidotToString(o2);
					if (strAuxiliar1 == "") {
						strAuxiliar1 = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
					} else if (strAuxiliar2 == "") {
						strAuxiliar2 = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
					}
					return strAuxiliar1.compareTo(strAuxiliar2);
				} else {
					return NullConverter.convert(o2.getApellido()).compareTo(NullConverter.convert(o1.getApellido()));
				}
			}
		});
	}

	/**
	 * orderByEdad nos ayuda a ordenar todos los objetos con atributo edad que
	 * contienen el arraylist que recibe. Hace uso de la clase Colections de java
	 * util y de su funcion sort con el cual realizala ordenación de los datos.
	 * Dentro de sort en el método compare, se reciben dos objetos de tipo
	 * Visitante; Previo a comparar primero se verifíca que el objeto evaluado no
	 * sea nulo con la clase NullConverter y su función nombreToString, de ser así
	 * se sustituye el valor por una cadena vacía.
	 * 
	 * El ordenamiento esta personalizado, está configurado para que ignore los
	 * valores vacíos y ordene solo los que cuentan con un dato válido.
	 * 
	 * @param alstVisitante Es un ArrayList<Visitante> del cual se extraen los datos
	 *                      a ordenar
	 * @param orden         Es de tipo boolean y su función es determinar si la
	 *                      ordenacion sera ASC o DESC
	 */
	public static void orderByEdad(ArrayList<Visitante> array, boolean orden) {
		Collections.sort(array, new Comparator<Visitante>() {
			@Override
			public int compare(Visitante o1, Visitante o2) {
				if (orden) {
					return NullConverter.edadtToInt(o1) - NullConverter.edadtToInt(o2);
				} else {
					return NullConverter.edadtToInt(o2) - NullConverter.edadtToInt(o1);
				}

			}
		});
	}

	/**
	 * orderByPais nos ayuda a ordenar todos los objetos con atributo pais que
	 * contienen el arraylist que recibe. Hace uso de la clase Colections de java
	 * util y de su funcion sort con el cual realizala ordenación de los datos.
	 * Dentro de sort en el método compare, se reciben dos objetos de tipo
	 * Visitante; Previo a comparar primero se verifíca que el objeto evaluado no
	 * sea nulo con la clase NullConverter y su función nombreToString, de ser así
	 * se sustituye el valor por una cadena vacía.
	 * 
	 * El ordenamiento esta personalizado, está configurado para que ignore los
	 * valores vacíos y ordene solo los que cuentan con un dato válido.
	 * 
	 * @param alstVisitante Es un ArrayList<Visitante> del cual se extraen los datos
	 *                      a ordenar
	 * @param orden         Es de tipo boolean y su función es determinar si la
	 *                      ordenacion sera ASC o DESC
	 */
	public static void orderByPais(ArrayList<Visitante> array, boolean orden) {
		Collections.sort(array, new Comparator<Visitante>() {
			@Override
			public int compare(Visitante o1, Visitante o2) {
				if (orden) {
					String strAuxiliar1 = NullConverter.paistToString(o1);
					String strAuxiliar2 = NullConverter.paistToString(o2);
					if (strAuxiliar1 == "") {
						strAuxiliar1 = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
					} else if (strAuxiliar2 == "") {
						strAuxiliar2 = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
					}
					return strAuxiliar1.compareTo(strAuxiliar2);
				} else {
					return NullConverter.paistToString(o2).compareTo(NullConverter.paistToString(o1));
				}

			}
		});
	}

	public static void orderByPasaporte(ArrayList<Visitante> array, boolean orden) {
		Collections.sort(array, new Comparator<Visitante>() {
			@Override
			public int compare(Visitante o1, Visitante o2) {
				if (orden) {
					return NullConverter.pasaporteToString(o1).compareTo(NullConverter.pasaporteToString(o2));
				} else {
					return NullConverter.pasaporteToString(o2).compareTo(NullConverter.pasaporteToString(o1));
				}
			}

		});
	}

	/**
	 * orderByServidor nos ayuda a ordenar todos los objetos con atributo servidor
	 * que contienen el arraylist que recibe. Hace uso de la clase Colections de
	 * java util y de su funcion sort con el cual realizala ordenación de los datos.
	 * Dentro de sort en el método compare, se reciben dos objetos de tipo
	 * Visitante; Previo a comparar primero se verifíca que el objeto evaluado no
	 * sea nulo con la clase NullConverter y su función nombreToString, de ser así
	 * se sustituye el valor por una cadena vacía.
	 * 
	 * El ordenamiento esta personalizado, está configurado para que ignore los
	 * valores vacíos y ordene solo los que cuentan con un dato válido.
	 * 
	 * @param alstVisitante Es un ArrayList<Visitante> del cual se extraen los datos
	 *                      a ordenar
	 * @param orden         Es de tipo boolean y su función es determinar si la
	 *                      ordenacion sera ASC o DESC
	 */
	public static void orderByServidor(List<Visitante> lstLector, boolean orden) {

		Collections.sort(lstLector, new Comparator<Visitante>() {
			@Override
			public int compare(Visitante o1, Visitante o2) {
				if (orden) {
					String strAuxiliar1 = NullConverter.servidorToString(o1);
					String strAuxiliar2 = NullConverter.servidorToString(o2);
					if (strAuxiliar1 == "") {
						strAuxiliar1 = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
					} else if (strAuxiliar2 == "") {
						strAuxiliar2 = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
					}
					return strAuxiliar1.compareTo(strAuxiliar2);
				} else {
					return NullConverter.servidorToString(o2).compareTo(NullConverter.servidorToString(o1));
				}
			}
		});
	}
}
