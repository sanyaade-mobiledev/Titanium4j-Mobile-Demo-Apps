package com.emitrom.ti4j.locancalculator.client.ui.chart;

import com.emitrom.gwt4.touch.charts.client.data.BaseChartModel;

/**
 * Representation of a Value in the Pie Chart
 */
public class ChartValue extends BaseChartModel {

    public void setName(String value) {
        set("name", value);
    }

    public void setValue(double value) {
        set("value", value);
    }

}
