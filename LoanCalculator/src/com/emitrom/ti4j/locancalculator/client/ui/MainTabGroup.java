package com.emitrom.ti4j.locancalculator.client.ui;

import com.emitrom.gwt4.ti.mobile.client.ui.TabGroup;
import com.emitrom.gwt4.ti.mobile.client.ui.Window;
import com.emitrom.ti4j.locancalculator.client.ui.calculate.CalculateTab;
import com.emitrom.ti4j.locancalculator.client.ui.chart.ChartWebView;
import com.emitrom.ti4j.locancalculator.client.ui.settings.SettingsTab;


public class MainTabGroup extends TabGroup {

	private static final MainTabGroup INSTANCE = new MainTabGroup();
	
	public static MainTabGroup get(){
		return INSTANCE;
	}

	private Window window;
	
	private MainTabGroup(){
		this.addTab(CalculateTab.get());
		this.addTab(SettingsTab.get());
		window = new Window("Loan Chart");
		window.setBarImage("assets/navbar.png");
		window.setBarColor("#000");
		window.add(ChartWebView.get());
	}
	
	public void openChartWindow(){
		CalculateTab.get().open(window);
	}
}
