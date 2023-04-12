package com.perfecciondigital.tallerprimefaces.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import com.perfecciondigital.tallerprimefaces.model.Car;

public class LazyCarDataModel extends LazyDataModel<Car> {
	 
    private List<Car> datasource;
 
    public LazyCarDataModel(List<Car> datasource) {
        this.datasource = datasource;
    }
 
    @Override
    public Car getRowData(String rowKey) {
        for (Car car : datasource) {
            if (car.getId().equals(rowKey)) {
                return car;
            }
        }
 
        return null;
    }
 
    @Override
    public Object getRowKey(Car car) {
        return car.getId();
    }
 
    @Override
    public List<Car> load(int first, int pageSize, Map<String, SortMeta> sortMeta, Map<String, FilterMeta> filterMeta) {
        List<Car> data = new ArrayList<>();
 
        //filter
        for (Car car : datasource) {
            boolean match = true;
 
            if (filterMeta != null) {
                for (FilterMeta meta : filterMeta.values()) {
                    try {
                        String filterField = meta.getFilterField();
                        Object filterValue = meta.getFilterValue();
                        String fieldValue = String.valueOf(car.getClass().getField(filterField).get(car));
 
                        if (filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                        }
                        else {
                            match = false;
                            break;
                        }
                    }
                    catch (Exception e) {
                        match = false;
                    }
                }
            }
 
            if (match) {
                data.add(car);
            }
        }
 
        //sort
        if (sortMeta != null && !sortMeta.isEmpty()) {
            for (SortMeta meta : sortMeta.values()) {
                Collections.sort(data, new LazySorter(meta.getSortField(), meta.getSortOrder()));
            }
        }
 
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);
 
        //paginate
        if (dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch (IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}