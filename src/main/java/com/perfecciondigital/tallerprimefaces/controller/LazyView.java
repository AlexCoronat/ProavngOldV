package com.perfecciondigital.tallerprimefaces.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import com.perfecciondigital.tallerprimefaces.model.Car;

@Named("dtLazyView")
@ViewScoped
public class LazyView implements Serializable {
     
    private LazyDataModel<Car> lazyModel;
     
    private Car selectedCar;
     
    @Inject
    private CarService service;
     
    @PostConstruct
    public void init() {
        lazyModel = new LazyCarDataModel(service.createCars(200));
    }
 
    public LazyDataModel<Car> getLazyModel() {
        return lazyModel;
    }
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
     
    public void setService(CarService service) {
        this.service = service;
    }
     
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", event.getObject().getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}