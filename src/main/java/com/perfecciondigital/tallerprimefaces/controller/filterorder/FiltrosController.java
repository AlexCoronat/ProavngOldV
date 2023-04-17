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

import com.perfecciondigital.tallerprimefaces.controller.CargadorBean;
import com.perfecciondigital.tallerprimefaces.model.Visitantes;
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

public class FiltrosController implements Serializable {

	private static final long serialVersionUID = 3566419322565642011L;

//	private static final Logger logger = LogManager.getLogger(FiltrosController.class);
//
//	@Autowired
//	private FiltrosService service;
//	@Autowired
//	private LectoresService serviceLectores;
//	@Autowired
//	private FiltrosPuertaService serviceFiltroPuerta;
//
//	@Autowired
//	private LoginController loginUsuario;
//
//	@Autowired
//	private MessageSource msg;

	// Lista de filtros en base de datos
//	private List<FiltroTO> filtros;

	// Lista de filtros en base de datos
//	private List<FiltroTO> filtrosAdd;

	// Datos de un nuevo filtro a dar de alta
//	private FiltroTO nuevoFiltro = new FiltroTO();
	
//	//code nico
//	Map<String, String> mapFiltros = new HashMap<String, String>(); //uso
//	String inputString=""; //uso
////	List<FiltroTO> listaFiltroCopia = new ArrayList<>(); //sin usar
//	int cantidadVecesImprimidas=0;
	
//	//@PostConstruct Se comenta el PostConstruct porque se realizarï¿½ la llamada al metodo init cuando se cargue la pï¿½gina de Tarjetas Maestras
//	// con la etiqueta <f:event type="preRenderView" listener="#{servidoresController.init}"/>
//	public void init() {
//		try {
//			
//			if(mapFiltros.isEmpty()) {
//				logger.info("Iniciando filtros...");
//				UsuarioTO logged = (UsuarioTO) loginUsuario.getLoggedUser();
//				filtros = service.findByIdAeropuerto(logged.getIdAeropuerto());
//	
//				filtrosAdd = new ArrayList<FiltroTO>();
//				
//				for (FiltroTO filtro : filtros) {
//					if (!filtro.getNombre().equals("PENDIENTE")) {
//						filtrosAdd.add(filtro);
//					}
//				}
//				//code for de nico
//				for (FiltroTO filtroTO2 : filtrosAdd) {
//					System.out.println("Objeto filtrosAdd: Nombre: "+filtroTO2.getNombre() + " Tiempo: "+filtroTO2.getTiempo());
//				}
//				cantidadVecesImprimidas++;
//				System.out.println("cantidad veces pasadas en el init: "+cantidadVecesImprimidas);
//				logger.info("Se han recuperado todos los filtros del aeropuerto "
//						+ logged.getIdAeropuerto());
//			}else {
//				System.out.println("NO VA A BASE DE DATOS");
//			}
//
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//	}
//
//	public List<FiltroTO> getFiltros() {
//		return filtros;
//	}
//
//	public FiltroTO getNuevoFiltro() {
//		return nuevoFiltro;
//	}
//
//	public void setNuevoFiltro(FiltroTO nuevoFiltro) {
//		this.nuevoFiltro = nuevoFiltro;
//	}
//
//	/**
//	 * Mï¿½todo para insertar nuevo filtro
//	 */
//	public void addFiltro() {
//		try {
//			logger.info("Inicio creaciï¿½n nuevo filtro");
//			// Hay que establecer el idAeropuerto del nuevo filtro
//			UsuarioTO logged = (UsuarioTO) loginUsuario.getLoggedUser();
//			nuevoFiltro.setIdAeropuerto(logged.getIdAeropuerto());
//			// Es importante no reutilizar la variable nuevoFiltro
//			FiltroTO aInsertar = new FiltroTO(nuevoFiltro);
//			service.addFiltro(aInsertar);
//
//			// Se actualiza la vista (el filtro debe ser insertado en orden)
//			boolean insertado = false;
//			for (int i = 0; i < filtros.size(); i++) {
//				FiltroTO s = filtros.get(i);
//				if (aInsertar.getNombre().compareTo(s.getNombre()) <= 0) {
//					filtros.add(i, aInsertar);
//					insertado = true;
//					break;
//				}
//			}
//			if (!insertado) {
//				// Se inserta el ultimo
//				filtros.add(aInsertar);
//			}
//
//			Object[] params = { aInsertar.getNombre() };
//
//			// Todo OK
//			FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
//					msg.getMessage("filtros_nuevo_ok", params, FacesContext
//							.getCurrentInstance().getExternalContext()
//							.getRequestLocale()), msg.getMessage(
//							"filtros_nuevo_ok", null, FacesContext
//									.getCurrentInstance().getExternalContext()
//									.getRequestLocale()));
//			FacesContext.getCurrentInstance().addMessage(null, mensaje);
//			logger.info("Nuevo usuario creado");
//
//			// Para "borrar" los datos introducidos por el usuario
//			nuevoFiltro = new FiltroTO();
//			logger.info("Nuevo filtro creado");
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//	}
//
//	/**
//	 * Mï¿½todo para actualizar los filtros
//	 * 
//	 * @param event
//	 */
//	public void onUpdateFiltro(RowEditEvent event) {
//		try {
//			logger.info("Inicio modificaciï¿½n filtro");
//			FiltroTO filtro = (FiltroTO) event.getObject();
//			service.updateFiltro(filtro);
//
//			Object[] params = { filtro.getNombre() };
//			FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
//					msg.getMessage("filtros_modificado_ok", params,
//							FacesContext.getCurrentInstance()
//									.getExternalContext().getRequestLocale()),
//					msg.getMessage("filtros_modificado_ok", null, FacesContext
//							.getCurrentInstance().getExternalContext()
//							.getRequestLocale()));
//			FacesContext.getCurrentInstance().addMessage(null, mensaje);
//			logger.info("El filtro: " + filtro.getNombre()
//					+ " ha sido modificado");
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//	}
//
//	/**
//	 * Mï¿½todo para cancelar la ediciï¿½n del filtro
//	 * 
//	 * @param event
//	 */
//	public void onCancelFiltro(RowEditEvent event) {
//		try {
//			Object[] params = { ((FiltroTO) event.getObject()).getNombre() };
//			FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
//					msg.getMessage("filtros_cancelado_ok", params, FacesContext
//							.getCurrentInstance().getExternalContext()
//							.getRequestLocale()), msg.getMessage(
//							"filtros_cancelado_ok", null, FacesContext
//									.getCurrentInstance().getExternalContext()
//									.getRequestLocale()));
//			FacesContext.getCurrentInstance().addMessage(null, mensaje);
//			logger.info("Se cancela la ediciï¿½n del filtro");
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//	}
//
//	/**
//	 * Mï¿½todo para eliminar un filtro
//	 */
//	public void onDeleteFiltro(FiltroTO filtro) {
//		try {
//			logger.info("Eliminado el filtro: " + filtro.getNombre());
//
//			Object[] params = { filtro.getNombre() };
//			// Todo OK
//			FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
//					msg.getMessage("filtros_eliminado_ok", params, FacesContext
//							.getCurrentInstance().getExternalContext()
//							.getRequestLocale()), msg.getMessage(
//							"filtros_eliminado_ok", null, FacesContext
//									.getCurrentInstance().getExternalContext()
//									.getRequestLocale()));
//			FacesContext.getCurrentInstance().addMessage(null, mensaje);
//
//			// Por ï¿½ltimo se eliminarï¿½ el registro del filtro pasado por el
//			// mï¿½todo
//			service.deleteFiltro(filtro);
//
//			filtros.remove(filtro);// Para que el refresco de la tabla sea
//									// adecuado
//			logger.info("El filtro: " + filtro.getNombre()
//					+ " a sido eliminado y sus relaciones");
//
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//	}
//
//	public List<FiltroTO> getFiltrosAdd() {
//		return filtrosAdd;
//	}
//
//	public void setFiltrosAdd(List<FiltroTO> filtrosAdd) {
//		this.filtrosAdd = filtrosAdd;
//	}
	
	//code nico
//	public void filterListener(FilterEvent filterEvent) {
//		System.out.println("+++++++++++++++++++++++++++");
//		System.out.println("Se activo el evento de filter");
//		System.out.println("+++++++++++++++++++++++++++");
//		
//		mapFiltros = filterEvent.getFilters();
//		String strFiltro;
//		
//		for (String key: mapFiltros.keySet()) {
//			strFiltro = key;
//			inputString = mapFiltros.get(key);	
//			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//			System.out.println("Columna o Key: "+strFiltro+ " / " + "Caja de texto: " + inputString);	
//			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		}
//	}
	
	public void onSort(SortEvent event) {
		System.out.println("No funciona");
		OrderBy ordenamiento = new OrderBy();
		ArrayList<Visitantes> vtes = new ArrayList<Visitantes>();
		vtes = new CargadorBean().getVisitantes();
		// determina el orden asc/desc
		boolean blnOrdenSort = event.isAscending();
		// determina el nombre de la columna donde se realizo el evento
		String strNombreColumna = event.getSortColumn().getSortBy().toString();

		switch (strNombreColumna) {
		case "Nombre_de_la_persona": {
			ordenamiento.orderByNombre(vtes, blnOrdenSort);
		}
			break;
//		case "Tiempo_en_minutos": {
//			ordenamiento.orderPorTiempoEnMinutos(controlesPasaporte, blnOrdenSort);
//		}
//			break;
		default:
			break;
		}
	}
	
//	public void postProcessXLS(Object document) {
//		try {
//
//			HSSFWorkbook wb = (HSSFWorkbook) document;
//
//			HSSFSheet sheet = wb.getSheetAt(0);
//			HSSFRow header = sheet.getRow(0);
//			header.setHeightInPoints((short) 18);
//
//			wb.setSheetName(0, msg.getMessage("InformeFiltro_PaginaExportable", null,
//					FacesContext.getCurrentInstance().getExternalContext().getRequestLocale()));
//
//			// Aunque no es necesario podemos establecer estilos a las celdas.
//			// Primero, establecemos el tipo de fuente
//			HSSFFont fuente = wb.createFont();
//			fuente.setFontHeightInPoints((short) 11);
//			fuente.setFontName(HSSFFont.FONT_ARIAL);
//			fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//
//			// Luego creamos el objeto que se encargarï¿½ de aplicar el estilo a
//			// la celda
//			HSSFCellStyle cellStyle = wb.createCellStyle();
//			cellStyle.setWrapText(true);
//			cellStyle.setAlignment(HSSFCellStyle.ALIGN_GENERAL);
//			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//			cellStyle.setWrapText(false);
//			cellStyle.setFont(fuente);
//
//			// Tambiï¿½n, podemos establecer bordes...
//			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
//			cellStyle.setBottomBorderColor((short) 8);
//			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
//			cellStyle.setLeftBorderColor((short) 8);
//			cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
//			cellStyle.setRightBorderColor((short) 8);
//			cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
//			cellStyle.setTopBorderColor((short) 8);
//
//			// Establecemos el tipo de sombreado de nuestra celda
//			cellStyle.setFillForegroundColor((short) 22);
//			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//
//			for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
//				HSSFCell cell = header.getCell(i);
//				cell.setCellStyle(cellStyle);
//				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//				// Ojo. El autoSizoColumn puede dar problemas si no hay entorno
//				// grafico.
//				// http://poi.apache.org/spreadsheet/quick-guide.html#Autofit
//				// To calculate column width Sheet.autoSizeColumn uses Java2D
//				// classes that throw exception if graphical environment
//				// is not available. In case if graphical environment is not
//				// available, you must tell Java that you are running in
//				// headless mode and set the following system property:
//				// java.awt.headless=true .
//				sheet.autoSizeColumn((short) i);
//			}
//			logger.info("Se ha generado el fichero excel para el informe de servidores");
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//
//	}

}