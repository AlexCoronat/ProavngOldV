package com.perfecciondigital.tallerprimefaces.controller.filterorder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
import javax.inject.Named;

//import org.primefaces.event.RowEditEvent;
import org.primefaces.event.data.FilterEvent;
import org.primefaces.event.data.SortEvent;

import javax.faces.event.ActionEvent;
//import org.primefaces.event.data.SortEvent;
//import org.apache.logging.log4j.Logger;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFFont;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.logging.log4j.LogManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;

import com.perfecciondigital.tallerprimefaces.controller.Cargador;
import com.perfecciondigital.tallerprimefaces.model.Visitante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
//import es.aena.scafis.admin.ordenamiento.OrdenamientoPasaporte;
//import es.aena.scafis.service.FiltrosPuertaService;
//import es.aena.scafis.service.FiltrosService;
//import es.aena.scafis.service.LectoresService;
//import es.aena.scafis.service.to.FiltroTO;
//import es.aena.scafis.service.to.UsuarioTO;
//
@Controller
@Scope("session")
@ManagedBean(name = "order")

public class FiltrosController implements Serializable {

	private static final long serialVersionUID = 3566419322565642011L;

	public void onSort(SortEvent event) {
		System.out.println("No funciona");
		OrderBy ordenamiento = new OrderBy();
		Cargador cargador = new Cargador();
		cargador.cargarListado();
		ArrayList<Visitante> vtes = cargador.getVisitantes();
		// determina el orden asc/desc
		boolean blnOrdenSort = event.isAscending();
		// determina el nombre de la columna donde se realizo el evento
		String strNombreColumna = event.getSortColumn().getSortBy().toString();

		switch (strNombreColumna) {
		case "Nombre": {
			ordenamiento.orderByNombre(vtes, blnOrdenSort);
		}
			break;
		case "Apellido": {
			ordenamiento.orderByApellido(vtes, blnOrdenSort);
		}
			break;
		case "Edad":{
			ordenamiento.orderByEdad(vtes, blnOrdenSort);
		}
			break;
		case "Pais":{
			ordenamiento.orderByPais(vtes, blnOrdenSort);
		}
			break;
		default:
			break;
		}
	}
}