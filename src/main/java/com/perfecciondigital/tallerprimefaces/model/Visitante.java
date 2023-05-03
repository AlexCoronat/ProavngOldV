package com.perfecciondigital.tallerprimefaces.model;

import java.io.Serializable;
import java.util.Date;

/**
 * La clase Visitante nos permite definir los atributos que tiene una persona
 * visitante
 * 
 * @author Jesús Corona
 * @author Marcos Adil
 */
public class Visitante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	private String apellido;
	private int edad;
	private String pais;
	private Date fechaLlegada;
	private Date fechaSalida;
	private Lector lector;
	private String strLectorVista;
	private boolean pasaporte;
	private String pasaporteVista;
	

	public Visitante() {
		super();
	}

	/**
	 * Constructor para la clase visitante
	 * 
	 * @param nombre   Recibe el nombre de la persona
	 * @param apellido Recibe el apellido de la persona
	 * @param edad     Recibe un valor entero con la edad de la persona
	 * @param pais     Recibe el país de donde proviene la persona
	 */
	public Visitante(String nombre, String apellido, int edad, String pais) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
	}
	
	public Visitante(String nombre, String apellido, int edad, String pais, 
			String pasaporteVista, String strlectorVista) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.pasaporteVista = pasaporteVista;
		this.strLectorVista = strlectorVista;
	}
	
	public String getStrLectorVista() {
		return strLectorVista;
	}

	public void setStrLectorVista(String strLectorVista) {
		this.strLectorVista = strLectorVista;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	/**
	 * Obtiene el atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna valor al atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el atributo apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Asigna valor al atributo apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Obtiene el atributo edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Asigna valor al atributo edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Obtiene el atributo país
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Asigna valor al atributo país
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Obtiene el atributo lector
	 */
	public Lector getLector() {
		return lector;
	}
	

	public boolean isPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(boolean pasaporte) {
		this.pasaporte = pasaporte;
	}

	/**
	 * Recibe un objeto de tipo lector que puede ser instanciado como un objeto
	 * nuevo, este método trabaja con un valor en específico que es el de servidor,
	 * puede ser configurado para operar con los demás atributos de la clase Lector
	 * según sea la necesidad. En caso de utilizar los otros atrubutos configure el
	 * metodo toString para que trabaje con el o los atributos deseados.
	 * 
	 * @param lector Un objeto de tipo Lector el cual es instanciado en el mismo
	 *               argumento y se le asigna valor según su atributo configurado.
	 * @param valor  Es el valor que se le asignará al atributo configurado para la
	 *               variable lector del parametro, como default será para
	 *               "lector.getServidor(valor)".
	 */
	public void setLector(Lector lector, String valor) {
		lector.setServidor(valor);
		this.lector = lector;
	}
	
	public String getPasaporteVista() {
		return pasaporteVista;
	}

	public void setPasaporteVista(String pasaporteVista) {
		this.pasaporteVista = pasaporteVista;
	}
	
	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	@Override
	public String toString() {
		return "[" + nombre + ", " + apellido + ", " + edad + ", " + pais + ", " 
				+pasaporte+", "+ lector.toString() + "]";
	}

	/**
	 * Es una variante del metodo toString
	 * 
	 * @return Devuelve los valores especificados como una cadena String
	 */
	public String toStringVte() {
		return "[" + nombre + ", " + apellido + ", " + edad + ", " + pais + "]";
	}
}