package com.perfecciondigital.tallerprimefaces.controller.filterorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.perfecciondigital.tallerprimefaces.model.Visitantes;

public class OrderBy{
	//Ordenamiento para clase visitante
	public void orderByNombre(ArrayList<Visitantes> array,boolean orden) {
		if(orden) {
			Collections.sort(array, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					return o1.getNombre().compareTo(o2.getNombre());
				}
			});
		}else {
			Collections.sort(array, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					return o2.getNombre().compareTo(o1.getNombre());
				}
			});
		}
	}
	public void orderByApellido(ArrayList<Visitantes> array,boolean orden) {
		if(orden) {
			Collections.sort(array, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					return o1.getApellido().compareTo(o2.getApellido());
				}
			});
		}else {
			Collections.sort(array, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					return o2.getApellido().compareTo(o1.getApellido());
				}
			});
		}
	}
	public void orderByEdad(ArrayList<Visitantes> array,boolean orden) {
		if(orden) {
			Collections.sort(array, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					return o1.getEdad().compareTo(o2.getEdad());
				}
			});
		}else {
			Collections.sort(array, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					return o2.getEdad().compareTo(o1.getEdad());
				}
			});
		}
	}
	public void orderByPais(ArrayList<Visitantes> array,boolean orden) {
		if(orden) {
			Collections.sort(array, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					return o1.getPais().compareTo(o2.getPais());
				}
			});
		}else {
			Collections.sort(array, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					return o2.getPais().compareTo(o1.getPais());
				}
			});
		}
	}
}

