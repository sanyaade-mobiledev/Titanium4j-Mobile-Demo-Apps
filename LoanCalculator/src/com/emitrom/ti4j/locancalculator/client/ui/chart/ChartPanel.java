package com.emitrom.ti4j.locancalculator.client.ui.chart;

import com.emitrom.gwt4.ti.mobile.client.api.API;
import com.emitrom.gwt4.ti.mobile.client.app.App;
import com.emitrom.gwt4.touch.client.containers.Panel;
import com.emitrom.gwt4.touch.client.core.EventObject;
import com.emitrom.gwt4.touch.client.core.handlers.button.TapHandler;
import com.emitrom.gwt4.touch.client.laf.UI;
import com.emitrom.gwt4.touch.client.layout.FitLayout;
import com.emitrom.gwt4.touch.client.widgets.Button;

public class ChartPanel extends Panel  {

    private static final ChartPanel INSTANCE = new ChartPanel();
    
    public static ChartPanel get(){
    	return INSTANCE;
    }
	private Button button;
    
    
    private ChartPanel(){
    	this.setLayout(new FitLayout());
    	
    	
    	button = new com.emitrom.gwt4.touch.client.widgets.Button("Click me");
    	button.setUi(UI.ACTION);
		button.addTapHandler(new TapHandler() {
			@Override
			public void onTap(com.emitrom.gwt4.touch.client.widgets.Button button,
					EventObject event) {
				API.get().info("Hello World");
				App.get().fireEvent("myEvent", new com.emitrom.ti4j.locancalculator.client.common.ChartEvent());
				
			}
		});
		//this.add(button);
		
    }
    
	
	public Button getButton(){
		return button;
	}
	

}
