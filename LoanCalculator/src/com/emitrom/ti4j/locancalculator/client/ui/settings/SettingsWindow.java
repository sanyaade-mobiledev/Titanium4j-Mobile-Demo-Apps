package com.emitrom.ti4j.locancalculator.client.ui.settings;

import com.emitrom.gwt4.ti.mobile.client.ui.Window;

/**
 * Implements the MainWindow of the application
 *
 */
public class SettingsWindow  extends Window{

	private static final SettingsWindow INSTANCE = new SettingsWindow();
	
	public static SettingsWindow get(){
		return INSTANCE;
	}
	private SettingsWindow(){
		
		this.setWidth(320);
		this.setHeight(480);
		this.setTop(0);
		this.setLeft(0);
		this.setTitle("Settings");
		this.setBarImage("assets/navbar.png");
		this.setBackgroundImage("assets/background.png");
		this.add(SettingsView.get());
		
		
	}
}
