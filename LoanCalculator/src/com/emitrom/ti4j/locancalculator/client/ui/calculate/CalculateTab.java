package com.emitrom.ti4j.locancalculator.client.ui.calculate;

import com.emitrom.gwt4.ti.mobile.client.ui.Tab;

public class CalculateTab extends Tab {

	private static final CalculateTab INSTANCE = new CalculateTab();
	
	public static CalculateTab get(){
		return INSTANCE;
	}
	
	private CalculateTab(){
		this.setTitle("Calculate");
		this.setIcon("assets/icon_calculator.png");
		this.setWindow(CalculateWindow.get());
	}
}
