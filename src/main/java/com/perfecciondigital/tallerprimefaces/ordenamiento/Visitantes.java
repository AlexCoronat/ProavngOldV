package com.perfecciondigital.tallerprimefaces.ordenamiento;
import java.util.List;

public class Visitantes {

	private String nombre;
	private String apellido;
	private int edad;
	private String pais;
	private Lector lector;

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

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector,String valor) {
		lector.setServidor(valor);
		this.lector = lector;
	}

	@Override
	public String toString() {
		return "[" + nombre + ", " + apellido + ", " + edad + ", " + pais + ", "+lector.toString()+"]";
	}

}