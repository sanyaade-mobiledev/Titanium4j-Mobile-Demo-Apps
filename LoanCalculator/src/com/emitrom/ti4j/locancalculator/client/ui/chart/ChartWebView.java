package com.emitrom.ti4j.locancalculator.client.ui.chart;

import com.emitrom.gwt4.ti.mobile.client.ui.WebView;

/**
 * WebView that will hold the Touch4j Chart
 */
public class ChartWebView extends WebView {

	private static final ChartWebView INSTANCE = new ChartWebView();
    
	public static ChartWebView get(){
		return INSTANCE;
	}
	
	private ChartWebView(){
		this.setUrl("index.html");
	}
}

