package com.perfecciondigital.tallerprimefaces.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.perfecciondigital.tallerprimefaces.model.Car;

@Named("dtSortView")
@ViewScoped
public class SortView implements Serializable {
     
    private List<Car> cars1;
    private List<Car> cars2;
    private List<Car> cars3;
     
    @Inject
    private CarService service;
 
    @PostConstruct
    public void init() {
        cars1 = service.createCars(10);
        cars2 = service.createCars(10);
        cars3 = service.createCars(50);
    }
 
    public List<Car> getCars1() {
        return cars1;
    }
 
    public List<Car> getCars2() {
        return cars2;
    }
     
    public List<Car> getCars3() {
        return cars3;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
}