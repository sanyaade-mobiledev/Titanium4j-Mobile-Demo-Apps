package com.emitrom.ti4j.locancalculator.client.common;

import com.emitrom.gwt4.ti.mobile.client.core.JsoHelper;
import com.emitrom.gwt4.ti.mobile.client.core.events.TiEvent;

public class ChartEvent extends TiEvent {

	public ChartEvent(){
		jsObj = JsoHelper.createObject();
	}
	
	public  void setLoan(double value){
		JsoHelper.setAttribute(jsObj, "load", value);
	}
	
	public double getLoad(){
		return JsoHelper.getAttributeAsDouble(jsObj, "loan");
	}
}
