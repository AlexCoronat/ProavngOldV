package com.perfecciondigital.tallerprimefaces.ordenamiento;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderBy{
	//Ordenamiento para clase visitante
	public static void isNull() {}
	public void orderByNombre(ArrayList<Visitantes> array,boolean orden) {
		if(orden) {
			Collections.sort(array, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					String aux1, aux2;
					if(o1.getNombre() == null) {
						aux1 = "";
					}else{ 
						aux1 = o1.getNombre();
					}if(o2.getNombre() == null){
						aux2 = "";
					}else {
						aux2 = o2.getNombre();
					}					
					int res=aux1.compareTo(aux2);
					return res;
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
					return o1.getEdad() - o2.getEdad();
				}
			});
		}else {
			Collections.sort(array, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					return o2.getEdad() - o1.getEdad();
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
	public void orderByServidor(List<Visitantes> lstLector,boolean orden) {
		if(orden) {
			Collections.sort(lstLector, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					return o1.getLector().getServidor().compareTo(o2.getLector().getServidor());
				}
			});
		}else {
			Collections.sort(lstLector, new Comparator<Visitantes>() {
				@Override
				public int compare(Visitantes o1, Visitantes o2) {
					return o2.getLector().getServidor().compareTo(o1.getLector().getServidor());

				}
			});
		}
	}
	//Ordenamiento para clase Lector
	public void orderById(List<Lector> lstLector, boolean orden) {
		if(orden) {
			Collections.sort(lstLector, new Comparator<Lector>() {
				@Override
				public int compare(Lector o1, Lector o2) {
					return o1.getId().compareTo(o2.getId());
				}
			});
		}else {
			Collections.sort(lstLector, new Comparator<Lector>() {
				@Override
				public int compare(Lector o1, Lector o2) {
					return o2.getId().compareTo(o1.getId());
				}
			});
		}
	}
	public void orderByCom(List<Lector> lstLector,boolean orden) {
		if(orden) {
			Collections.sort(lstLector, new Comparator<Lector>() {
				@Override
				public int compare(Lector o1, Lector o2) {
					return o1.getComunicacion().compareTo(o2.getComunicacion());
				}
			});
		}else {
			Collections.sort(lstLector, new Comparator<Lector>() {
				@Override
				public int compare(Lector o1, Lector o2) {
					return o2.getComunicacion().compareTo(o1.getComunicacion());
				}
			});
		}
	}
	public void orderByModelo(List<Lector> lstLector,boolean orden) {
		if(orden) {
			Collections.sort(lstLector, new Comparator<Lector>() {
				@Override
				public int compare(Lector o1, Lector o2) {
					return o1.getModelo().compareTo(o2.getModelo());
				}
			});
		}else {
			Collections.sort(lstLector, new Comparator<Lector>() {
				@Override
				public int compare(Lector o1, Lector o2) {
					return o2.getModelo().compareTo(o1.getModelo());
				}
			});
		}
	}
	
}

