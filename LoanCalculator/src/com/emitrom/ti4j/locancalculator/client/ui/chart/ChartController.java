package com.emitrom.ti4j.locancalculator.client.ui.chart;

import com.emitrom.gwt4.ti.mobile.client.api.API;
import com.emitrom.gwt4.ti.mobile.client.core.events.TiEvent;
import com.emitrom.gwt4.touch.charts.client.Chart;
import com.emitrom.gwt4.touch.charts.client.Legend;
import com.emitrom.gwt4.touch.charts.client.laf.Label;
import com.emitrom.gwt4.touch.charts.client.series.PieSeries;
import com.emitrom.gwt4.touch.charts.client.theme.Theme;
import com.emitrom.gwt4.touch.client.data.Store;
import com.emitrom.gwt4.touch.client.laf.Position;
import com.emitrom.ti4j.locancalculator.client.common.ChartValueHolder;


/**
 * Creates and update the pie Chart in the ChartPanel
 */
public class ChartController {

	private static Chart chart;
	private static Store store;

	private ChartController(){
		
	}
	
	public  static void createChart(TiEvent event){
		ChartValueHolder value = ChartValueHolder.from(event.getEventData());
		API.get().info("Interest : " + value.getInterest() + ", Payments : " + value.getLoan());
		if(chart == null){
			store = new Store(DataUtil.getValues(value));
			chart = new Chart(store);
			chart.setTheme(Theme.DEFAULT);
			chart.setThemeCls("pie1");
			chart.setAnimate(true);
			chart.setInsetPadding(20);
			chart.setLegend(new Legend(Position.TOP));
			
			PieSeries series = new PieSeries();
			series.setField("value");
			series.setDonut(20);
			series.setShowInLegend(true);
			
			Label label = new Label();
			label.setField("name");
			series.setLabel(label);
			series.setHighlight(true);
			
			chart.setSeries(series);
			
			ChartPanel.get().add(chart);
		}else{
			API.get().info("Chart is not null updating data with " + value.getInterest() + " and " + value.getLoan());
			store.setData(DataUtil.getValues(value));
		}
		
	}
}
