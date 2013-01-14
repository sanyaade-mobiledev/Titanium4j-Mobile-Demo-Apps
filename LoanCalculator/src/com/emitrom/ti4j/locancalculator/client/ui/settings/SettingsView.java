package com.emitrom.ti4j.locancalculator.client.ui.settings;

import com.emitrom.gwt4.ti.mobile.client.core.events.ui.SwitchEvent;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.SwitchChangeHandler;
import com.emitrom.gwt4.ti.mobile.client.ui.Label;
import com.emitrom.gwt4.ti.mobile.client.ui.Switch;
import com.emitrom.gwt4.ti.mobile.client.ui.View;
import com.emitrom.gwt4.ti.mobile.client.ui.style.Color;
import com.emitrom.gwt4.ti.mobile.client.ui.style.Font;
import com.emitrom.gwt4.ti.mobile.client.ui.style.FontWeight;

/**
 * MainView of the loan calculator
 *
 */
public class SettingsView extends View {

	private final static SettingsView INSTANCE = new SettingsView();
	private boolean autoShowChart;
	private Switch chartOptionSwitch;
	
	public static SettingsView get(){
		return INSTANCE;
	}
	
	private SettingsView(){
		this.setWidth(300);
		this.setHeight(480 - 130);
		this.setLeft(10);
		this.setTop(10);
		this.setBackgroundColor(new Color("#FFF"));
		this.setBorderRadius(5);
		

		
		Label switchLabel = new Label("Auto Show Chart ? ");
		switchLabel.setFont(new Font(14, "Helvetica", FontWeight.BOLD));
		switchLabel.setWidth("auto");
		switchLabel.setHeight(30);
		switchLabel.setLeft(20);
		switchLabel.setTop(20);
		this.add(switchLabel);
		
		chartOptionSwitch = new Switch();
		chartOptionSwitch.setRight(20);
		chartOptionSwitch.setTop(20);
		chartOptionSwitch.setValue(false);
		chartOptionSwitch.addChangeHandler(new SwitchChangeHandler() {
			@Override
			public void onChange(SwitchEvent event) {
			 autoShowChart = chartOptionSwitch.getValue();
			}
		});
		this.add(chartOptionSwitch);
		
	}

	public boolean isAutoShowChart() {
		return autoShowChart;
	}
	
	public void setShowAutoChart(){
		autoShowChart = true;
		chartOptionSwitch.setValue(true);
	}
	
	
}
