package com.perfecciondigital.tallerprimefaces.model;

public class Visitantes implements Comparable{

	 private String nombre;
	 private String apellido;
	 private int edad;
	 private String pais;
	 private String nombreVista;
	 private String apellidoVista;
	 private String edadVista;
	 private String paisVista;
	 
	 public Visitantes() {
		super();
	}
	
	public Visitantes(String nombre, String apellido, int edad, String pais) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
	}
		
	public String getNombre() {
	  return nombre;
	 }  
	 public void setNombre(String nombre) {
	  this.nombre = nombre;
	 }
	 public String getApellido() {
	  return apellido;
	 }
	 public void setApellido(String apellido) {
	  this.apellido = apellido;
	 }
	 public int getEdad() {
	  return edad;
	 }
	 public void setEdad(int edad) {
	  this.edad = edad;
	 }
	 public String getPais() {
	  return pais;
	 }
	 public void setPais(String pais) {
	  this.pais = pais;
	 }
	@Override
	public int compareTo(Object o) {
		return 0;
	}

	public String getNombreVista() {
		return nombreVista;
	}

	public void setNombreVista(String nombreVista) {
		this.nombreVista = nombreVista;
	}

	public String getApellidoVista() {
		return apellidoVista;
	}

	public void setApellidoVista(String apellidoVista) {
		this.apellidoVista = apellidoVista;
	}

	public String getEdadVista() {
		return edadVista;
	}

	public void setEdadVista(String edadVista) {
		this.edadVista = edadVista;
	}

	public String getPaisVista() {
		return paisVista;
	}

	public void setPaisVista(String paisVista) {
		this.paisVista = paisVista;
	} 	
}
