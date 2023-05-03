package com.perfecciondigital.tallerprimefaces.model;

public class Lector {
	String id;
	String comunicacion;
	String modelo;
	String servidor;
	public Lector() {}
	public Lector(String id, String comunicacion, String modelo, String servidor) {
		super();
		this.id = id;
		this.comunicacion = comunicacion;
		this.modelo = modelo;
		this.servidor = servidor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComunicacion() {
		return comunicacion;
	}
	public void setComunicacion(String comunicacion) {
		this.comunicacion = comunicacion;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getServidor() {
		return servidor;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	@Override
	public String toString() {
		return servidor;
	}
	
}
