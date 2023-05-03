package com.perfecciondigital.tallerprimefaces.ordenamiento;


import java.util.ArrayList;
import java.util.List;

public class CargadorDatos {
	public ArrayList<Visitantes> ListaVisitantes(){
		
		Visitantes v1=new Visitantes();
		v1.setNombre(null);
		v1.setApellido("Perez");
		v1.setEdad(18);
		v1.setPais("Colombia Medellín");
		  
		Visitantes v2=new Visitantes();
		v2.setNombre("Pablo");
		v2.setApellido("Rodriguez");
		v2.setEdad(22);
		v2.setPais("Madrid España");
		  
		Visitantes v3=new Visitantes();
		v3.setNombre("Marcos");
		v3.setApellido("Velazquez");
		v3.setEdad(22);
		v3.setPais("México Guanajuato León.");
		  
		Visitantes v4=new Visitantes();
		v4.setNombre(null);
		v4.setApellido("Rodriguez");
		v4.setEdad(22);
		v4.setPais("México Durango"); 
		  
		Visitantes v5=new Visitantes();
		v5.setNombre("Leslie");
		v5.setApellido("Mon");
		v5.setEdad(23);
		v5.setPais("México");
		
		ArrayList<Visitantes> lstVisitante = new ArrayList<Visitantes>();
		
		lstVisitante.add(v1);
		lstVisitante.add(v2);
		lstVisitante.add(v3);
		lstVisitante.add(v4);
		lstVisitante.add(v5);
		
		return lstVisitante;
	}
	public static List<Lector> ListaLector(){
		Lector l1 = new Lector();
		l1.setId("hk4598");
		l1.setComunicacion("ip");
		l1.setModelo("Honeywell");
		l1.setServidor("Madrid");
		Lector l2 = new Lector();
		l2.setId("lc5678");
		l2.setComunicacion("serial");
		l2.setModelo("Steren");
		l2.setServidor("Valencia");
		Lector l3 = new Lector();
		l3.setId("wr7821");
		l3.setComunicacion("ip");
		l3.setModelo("Honeywell");
		l3.setServidor("Barcelona");
		Lector l4 = new Lector();
		l4.setId("lc5678");
		l4.setComunicacion("ip");
		l4.setModelo("Honeywell");
		l4.setServidor("Ibiza");
		Lector l5 = new Lector();
		l5.setId("lc5678");
		l5.setComunicacion("ip");
		l5.setModelo("Honeywell");
		l5.setServidor("Sevilla");
		List<Lector> listaLector = new ArrayList<Lector>();
		listaLector.add(l1);
		listaLector.add(l2);
		listaLector.add(l3);
		listaLector.add(l4);
		listaLector.add(l5);
		return listaLector;
	}
}
