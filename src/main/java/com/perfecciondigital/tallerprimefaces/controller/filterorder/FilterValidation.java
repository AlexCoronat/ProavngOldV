package com.perfecciondigital.tallerprimefaces.controller.filterorder;

import java.util.HashMap;
import java.util.Map;

import org.primefaces.model.filter.FilterConstraint;
public class FilterValidation implements FilterConstraint{

	@Override
	public boolean applies(String value, String filter) {
		if(filter == null || filter.toString().isEmpty()) {
			return true;
		}if(value == null) {
			return true;
		} 
		try {
			Integer.parseInt(filter.toString());
			Integer.parseInt(value.toString());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
}
